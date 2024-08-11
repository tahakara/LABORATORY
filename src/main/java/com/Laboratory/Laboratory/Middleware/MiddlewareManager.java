package com.Laboratory.Laboratory.Middleware;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.Laboratory.Laboratory.Services.Interfaces.IAuthService;
import com.Laboratory.Laboratory.Services.Interfaces.IRedisService;

@WebFilter("/*")
public class MiddlewareManager implements Filter {

    private IAuthService authService;
    private IRedisService redisService;

    @Autowired
    public MiddlewareManager(IAuthService authService, IRedisService redisService) {
        this.authService = authService;
        this.redisService = redisService;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);// for test remove before flight
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();

        if (requestURI.matches("/admin/.*")) {
            if (requestURI.equals("/admin/login")) {
                
                if (isAuth(httpRequest, "admin")) {
                    // Already Logged In
                    httpResponse.setStatus(302);
                    return;
                }
                // Not Logged In
                httpResponse.setStatus(200);
                chain.doFilter(request, response);
                return;
            }
            //test case 
            if (requestURI.matches("/admin/getall|/admin/logout")) {
                // Not Logged
                httpResponse.setStatus(200);
                chain.doFilter(request, response);
                return;
            }
            //
            if (!isAuth(httpRequest, "admin")) {
                httpResponse.setStatus(401);
                return;
            }
            chain.doFilter(request, response);
        }
        else if (requestURI.matches("/laborant/.*")) {
            if (requestURI.equals("/laborant/login") || requestURI.equals("/laborant/logout")) {
            
                if(isAuth(httpRequest, "laborant")) {
                    // Already Logged In
                    httpResponse.setStatus(302);
                    return;
                }
                // Not Logged In
                httpResponse.setStatus(200);
                chain.doFilter(request, response);
                return;

            } else if (!isAuth(httpRequest, "laborant")) {
                httpResponse.setStatus(401);
                return;
            }
            chain.doFilter(request, response);
        }
        else if (requestURI.matches("/user/.*")) {
            if (requestURI.equals("/user/login")) {
                if (isAuth(httpRequest, "user")) {
                    // Already Logged In
                    httpResponse.setStatus(200);
                    return;
                }
                // Not Logged In
                httpResponse.setStatus(200);
                chain.doFilter(request, response);
                return;
                
            } else if (!isAuth(httpRequest, "user")) {
                httpResponse.setStatus(401);
                return;
            }
            chain.doFilter(request, response);
        }
        
        // Continue request for other requests
        // chain.doFilter(request, response);
        // return;
    }

    private boolean isAuth(HttpServletRequest request, String role) {
        Boolean isAuthed = false;
        Cookie[] cookies = request.getCookies();
    
        if (cookies == null) {
            return false;
        }
    
        Cookie authCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Auth")) {
                authCookie = cookie;
                break;
            }
        }
    
        if (authCookie == null) {
            return false;
        }
    
        switch (role) {
            case "admin":
                Map<String, Object> verifyedJWT = authService.verifyToken(authCookie.getValue());
                if (verifyedJWT.isEmpty()) {
                    isAuthed = false;
                    break;
                }
    
                Object UUID = verifyedJWT.get("UUID");
    
                if (UUID == null) {
                    isAuthed = false;
                    break;
                }
    
                isAuthed = redisService.getAdminValueByKey(UUID.toString())
                    .map(hasValue -> true) // Eğer değer bulunursa true
                    .onErrorResume(throwable -> Mono.just(false)) // Hata durumunda false
                    .block();
                break;
    
            case "laborant":
                verifyedJWT = authService.verifyToken(authCookie.getValue());
                if (verifyedJWT.isEmpty()) {
                    isAuthed = false;
                    break;
                }
    
                UUID = verifyedJWT.get("UUID");
    
                if (UUID == null) {
                    isAuthed = false;
                    break;
                }
    
                isAuthed = redisService.getLaborantValueByKey(UUID.toString())
                    .onErrorReturn(null)
                    .block() != null;
                break;
    
            case "user":
                verifyedJWT = authService.verifyToken(authCookie.getValue());
                if (verifyedJWT.isEmpty()) {
                    isAuthed = false;
                    break;
                }
    
                UUID = verifyedJWT.get("UUID");
    
                if (UUID == null) {
                    isAuthed = false;
                    break;
                }
    
                isAuthed = redisService.getUserValueByKey(UUID.toString())
                    .onErrorReturn(null)
                    .block() != null;
                break;
    
            default:
                isAuthed = false;
                break;
        }
        System.out.println("isAuthed: " + isAuthed);
        return isAuthed;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter'ın başlatılması için gerekli kodlar
    }

    @Override
    public void destroy() {
        // Filter'ın sonlandırılması için gerekli kodlar
    }
}

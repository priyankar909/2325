package com.zynetic2325.backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    // JwtService ko dependency injection se inject kar rahe hain
    @Autowired
    private JwtService jwtService;

    // UserDetailsService bhi inject karenge taaki user info load kar sake
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String email;
        
        // Skip the filter for signup and login
        if (request.getRequestURI().startsWith("/api/auth/signup") || request.getRequestURI().startsWith("/api/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Agar Authorization header null hai ya "Bearer " se start nahi hota, toh request aage bhej do
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // "Bearer " ke baad ka part nikaal ke JWT token banaya
        jwt = authHeader.substring(7);
        email = jwtService.getEmailFromToken(jwt); // Token se email nikala

        // Agar email mil gaya aur SecurityContext me already auth nahi hai
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            // Token valid hai toh auth context set kar do
            if (jwtService.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Spring Security context me user auth set kar rahe hain
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Request ko filter chain ke next filter pe bhej rahe hain
        filterChain.doFilter(request, response);
    }
}

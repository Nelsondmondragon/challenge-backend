package com.nedacort.challengespringbackend.web.security.filter;

//import com.nedacort.challengespringbackend.domain.service.UserDetailService;
//import com.nedacort.challengespringbackend.web.security.JWTUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtFilterRequest  {
//    @Autowired
//    public JWTUtil jwtUtil;
//
//    @Autowired
//    private UserDetailService userDetailService;
//
//
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        String authorizationHeader = request.getHeader("Authorization");
////        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
////            String jwt = authorizationHeader.substring(7);
////            String username = jwtUtil.extractUsername(jwt);
////            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////                UserDetails userDetails = userDetailService.loadUserByUsername(username);
////                if (jwtUtil.validateToken(jwt, userDetails)) {
////                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
////                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////                    SecurityContextHolder.getContext().setAuthentication(authToken);
////                }
////            }
////        }
////        filterChain.doFilter(request, response);
////    }
//}

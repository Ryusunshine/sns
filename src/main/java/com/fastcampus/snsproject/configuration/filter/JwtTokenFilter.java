package com.fastcampus.snsproject.configuration.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    //OncePerRequestFilter는 요청시마다 필터 적용

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // doFilterInternal는 request에서 인증을 수행하는 메서드이다
        //get header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")){
            logger.error("Error occurs while getting header");
            filterChain.doFilter(request, response);//다시 request, response를 필터에 태워준다.
            return ;
        }

    }
}

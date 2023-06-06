package com.henrique.workshopmongo.config.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.henrique.workshopmongo.config.security.TokenService;
import com.henrique.workshopmongo.services.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter {
	
	@Autowired
	public TokenService tokenService;
	
	@Autowired
	public UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = recoverToken(request);
		
		if (token != null ) {
			String username = tokenService.jwtTokenVerifier(token);
			var user = userService.loadUserByUsername(username);
			
			var authorization = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authorization);
		}
		
		filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		if (bearerToken != null) {
			return bearerToken.replace("Bearer ", "");
		}
		
		return null;
	}
}

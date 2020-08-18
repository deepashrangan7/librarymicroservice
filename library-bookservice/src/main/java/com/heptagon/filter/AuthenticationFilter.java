package com.heptagon.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.heptagon.feign.AuthenticationFeign;
import com.heptagon.service.AuthorUserService;

@Component
@Order(1)
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationFeign authenticationFeign;

	@Autowired
	private AuthorUserService userService;

	private String user;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		boolean flag = false;
		String token = null;
		String path = request.getRequestURI();
		if ("/author/add".equals(path) || path.startsWith("/book/view/")|| path.startsWith("/book/all/author/")) {
			filterChain.doFilter(request, response);
			return;
		}
		try {
			token = request.getHeader("Authorization").substring(7);
			flag = authenticationFeign.validateToken(request.getHeader("Authorization"));

		} catch (Exception e) {
			System.out.println("error ocuured " + e.getMessage());
		}
		if (flag) {

			if (user == null) {
				user = authenticationFeign.userName(token);
			}
			if (user != null) {
				UserDetails ud = userService.loadUserByUsername(user);
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(ud, null,
						ud.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}

		}
		filterChain.doFilter(request, response);

	}

}

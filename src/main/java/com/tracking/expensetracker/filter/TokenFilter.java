package com.tracking.expensetracker.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.tracking.expensetracker.ETConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String tokenHeader = req.getHeader("Authorization");
		if(tokenHeader != null) {
			String[] tokenList = tokenHeader.split("TOKEN ");
			if(tokenList.length > 1 && tokenList[1] != null) {
				String token = tokenList[1];
				try {
//					Claims claim = Jwts.parser().setSigningKey(ETConstants.ET_TOKEN_KEY)
//					.parseClaimsJws(token.trim()).getBody();
					Claims claims = Jwts.parser().setSigningKey(ETConstants.ET_TOKEN_KEY)
                            .parseClaimsJws(token).getBody();
					req.setAttribute("userid", Integer.parseInt(claims.get("userid").toString()));					
					
				} catch(Exception e) {
					res.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid/Expired token!!");
					return;
				}
			}
			else {
				res.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization token should be TOKEN [token]!!");				
				return;
			}
		}
		else {
			res.sendError(HttpServletResponse.SC_FORBIDDEN, "No authorization token found!!");
			return;
		}		
		chain.doFilter(request, response);
	}

}

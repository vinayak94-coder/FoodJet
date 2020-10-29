package com.myapp.favourite.JWTFilter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.swagger.models.HttpMethod;

public class JWTFilter extends GenericFilterBean {



  
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
       
        httpServletResponse.setHeader("Acces-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
        httpServletResponse.setHeader("Acces-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Acces-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
        
        String authkey = httpServletRequest.getHeader("Authorization");
        
        if((authkey==null) || (!authkey.startsWith("Bearer")))
        {
        	throw new ServletException("JWT is Missing");
        }
       
        String token=authkey.substring(7);
        
        try
        {
        	JwtParser parser = Jwts.parser().setSigningKey("jwtsecret");
        	Jwt jwtobj = parser.parse(token);
        	Claims claim = (Claims) jwtobj.getBody();
        	String username = claim.getSubject();
        	
        	
        	

        	
        }catch(SignatureException e) {
        	throw new ServletException("signature mismatch");
        }catch(MalformedJwtException e){
        	throw new ServletException ("token is modified");
        }
        
        if(httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name()))
        {
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        
       
  
		
		
    }
		
		
	}




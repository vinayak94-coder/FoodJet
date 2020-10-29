package com.myapp.favourite;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.myapp.favourite.JWTFilter.JWTFilter;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Transactional
public class FavouriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteApplication.class, args);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterRegistrationBean getFilterBean()
	{
		UrlBasedCorsConfigurationSource Urlcorsconfig =new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfig=new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");
		corsConfig.addAllowedOrigin("*");
		
		Urlcorsconfig.registerCorsConfiguration("/**", corsConfig);
		
		FilterRegistrationBean filterBean = new FilterRegistrationBean(new CorsFilter(Urlcorsconfig));
		filterBean.setFilter(new JWTFilter());
		filterBean.addUrlPatterns("/favourite/add","/favourite/email","/favourite/delete");	
		
		return filterBean;
				
				
		
		
	}
}

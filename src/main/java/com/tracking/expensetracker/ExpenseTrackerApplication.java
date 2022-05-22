package com.tracking.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.tracking.expensetracker.controller.UserController;
import com.tracking.expensetracker.filter.TokenFilter;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<TokenFilter> filterRegistrationBean()
	{
		FilterRegistrationBean<TokenFilter> filterBean = new FilterRegistrationBean<TokenFilter>();
		TokenFilter tokenFilter = new TokenFilter();
		filterBean.setFilter(tokenFilter);
		filterBean.addUrlPatterns("/api/categories/*");
		filterBean.addUrlPatterns("/api/transactions/*");
		
		return filterBean;
	}
}

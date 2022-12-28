package com.example.Helloworld;

import com.example.Helloworld.servlet.HelloListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.example.Helloworld.servlet.HelloFilter;
import com.example.Helloworld.servlet.HelloListener;
import com.example.Helloworld.servlet.helloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HttpServletBean;

@SpringBootApplication
public class HelloworldApplication {
	/// Register Servlet.
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean servletBean = new ServletRegistrationBean(new helloServlet());
		servletBean.addUrlMappings("/helloServlet");
		return servletBean;
	}

	/// Register Filter.
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloFilter());
		// Add filter path
		filterBean.addUrlPatterns("/helloServlet");
		return filterBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean listenerBean =
				new ServletListenerRegistrationBean(new HelloListener());
		return listenerBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}


}

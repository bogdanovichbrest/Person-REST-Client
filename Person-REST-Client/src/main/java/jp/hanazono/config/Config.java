package jp.hanazono.config;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "jp.hanazono")
public class Config {

	@Bean
	public AutowiredAnnotationBeanPostProcessor postprocessor() {
		return new AutowiredAnnotationBeanPostProcessor();
	}
	@Bean
	public void addResourceHandler(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
	}

	@Bean
	public InternalResourceViewResolver setupResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}

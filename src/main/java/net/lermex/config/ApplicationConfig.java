package net.lermex.config;

import static org.springframework.context.annotation.ComponentScan.Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import net.lermex.Application;

@Configuration
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
class ApplicationConfig {
	
//	@Bean
//	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//		ppc.setLocation(new ClassPathResource("/persistence.properties"));
//		return ppc;
//	}
	
}
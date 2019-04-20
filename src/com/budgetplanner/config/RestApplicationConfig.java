/**
 * 
 */
package com.budgetplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Pradeep
 *
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan({ "com.budgetplanner.service" ,"com.budgetplanner.controller" })
public class RestApplicationConfig extends WebMvcConfigurerAdapter{
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				//.apis(RequestHandlerSelectors.basePackage("com.budjetplanner.controller"))
				.paths(PathSelectors.any())
				.build();	
	}
	
//	private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//            .title("Budjet Planner")
//            .description("Limit and track the Transaction ")
//            .version("1.0.0")
//            .termsOfServiceUrl("http://localhost:8080/BudjetPlanner")
//            .license("LICENSE")
//            .licenseUrl("http://url-to-license.com")
//            .build();
//    }
	
	@Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
}

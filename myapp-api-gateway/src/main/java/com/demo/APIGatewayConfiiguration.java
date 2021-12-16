package com.demo;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiiguration {

	
	@Bean
	public RouteLocator gatewayRouteLocator(RouteLocatorBuilder builder) {
		
//		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
//																		.filters(f -> f.addRequestHeader("x-my-header", "some header value"))
//																		.uri("http://httbin.org:80");
		
		Function<PredicateSpec, Buildable<Route>> routeFunction2 
				= p -> p.path("/currency-conversion/**")
						.uri("lb://CURRENCY-CONVERSION");
			
		return builder.routes()
//				.route(routeFunction)
				.route(routeFunction2)
				.build();
		
	}
}

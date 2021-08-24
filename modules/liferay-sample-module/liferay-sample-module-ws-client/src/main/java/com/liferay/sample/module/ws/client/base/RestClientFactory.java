package com.liferay.sample.module.ws.client.base;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;

import com.liferay.sample.module.ws.config.RestAPIConfiguration;

import org.osgi.service.component.annotations.Component;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * @author Rafael Oliveira
 */
@Component(service = RestClientFactory.class)
public class RestClientFactory<T> {
	
	public T getAPI(RestAPIConfiguration configuration, Class<T> serviceClass) {
		
		// Create a custom configuration for a CircuitBreaker
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.minimumNumberOfCalls(configuration.minimumNumberOfCallsValue())
				.failureRateThreshold(configuration.failureRateThresholdValue())
				.waitDurationInOpenState(Duration.ofSeconds(configuration.waitDurationInOpenStateValue()))
				.build();

		// Create a CircuitBreakerRegistry with a custom global configuration
		CircuitBreakerRegistry circuitBreakerRegistry =
				CircuitBreakerRegistry.of(circuitBreakerConfig);

		// Log
		circuitBreakerRegistry.getEventPublisher()
				.onEvent(event -> {
					_logger.info("CircuitBreaker {} event type ", event.getEventType());
					_logger.info("CircuitBreaker {} event details ", event);
				});

		CircuitBreaker circuitBreaker = circuitBreakerRegistry
				.circuitBreaker(configuration.apiName());
		
		
		// Log emitted events
		circuitBreaker.getEventPublisher()
			.onEvent(event -> {
				_logger.info("CircuitBreaker {} event log - type " + event.getEventType());
				_logger.info("CircuitBreaker {} event log - details " + event);
			});
		
		RateLimiter rateLimiter = RateLimiter.ofDefaults(configuration.apiName());

		FeignDecorators decorators =
				FeignDecorators.builder()
						.withCircuitBreaker(circuitBreaker)
						.build();

		return (T) Resilience4jFeign.builder(decorators)
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(RestClientFactory.class))
				.logLevel(Logger.Level.FULL)
				.target(serviceClass, configuration.apiBaseUrl());
			    
	}

	// declare at the end, just like References annotations (Liferay best practices)
	private static final org.slf4j.Logger _logger = LoggerFactory.getLogger(RestClientFactory.class.getName());
}

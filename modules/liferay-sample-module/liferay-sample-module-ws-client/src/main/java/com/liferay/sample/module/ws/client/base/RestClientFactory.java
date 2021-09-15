package com.liferay.sample.module.ws.client.base;

import com.liferay.sample.module.ws.config.RestAPIConfiguration;

import feign.Logger;

import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

import feign.slf4j.Slf4jLogger;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.Registry;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;

import java.time.Duration;

import org.osgi.service.component.annotations.Component;

import org.slf4j.LoggerFactory;

/**
 * @author Rafael Oliveira
 */
@Component(service = RestClientFactory.class)
public class RestClientFactory<T> {

	public T getAPI(RestAPIConfiguration configuration, Class<T> serviceClass) {

		// Create a custom configuration for a CircuitBreaker

		CircuitBreakerConfig.Builder circuitBreakerBuilder = CircuitBreakerConfig.custom();

		CircuitBreakerConfig circuitBreakerConfig = circuitBreakerBuilder.minimumNumberOfCalls(
			configuration.minimumNumberOfCallsValue()
		).failureRateThreshold(
			configuration.failureRateThresholdValue()
		).waitDurationInOpenState(
			Duration.ofSeconds(configuration.waitDurationInOpenStateValue())
		).build();

		// Create a CircuitBreakerRegistry with a custom global configuration

		CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);

		// Log

		Registry.EventPublisher<CircuitBreaker> circuitBreakerRegistryEventPublisher =
			circuitBreakerRegistry.getEventPublisher();

		circuitBreakerRegistryEventPublisher.onEvent(
			event -> {
				_logger.info("CircuitBreaker {} event type ", event.getEventType());
				_logger.info("CircuitBreaker {} event details ", event);
			});

		CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(configuration.apiName());

		CircuitBreaker.EventPublisher circuitBreakerEventPublisher = circuitBreaker.getEventPublisher();

		// Log emitted events

		circuitBreakerEventPublisher.onEvent(
			event -> {
				_logger.info("CircuitBreaker {} event log - type " + event.getEventType());
				_logger.info("CircuitBreaker {} event log - details " + event);
			});

		RateLimiter.ofDefaults(configuration.apiName());

		FeignDecorators decorators = FeignDecorators.builder(
		).withCircuitBreaker(
			circuitBreaker
		).build();

		return (T)Resilience4jFeign.builder(
			decorators
		).encoder(
			new GsonEncoder()
		).decoder(
			new GsonDecoder()
		).logger(
			new Slf4jLogger(RestClientFactory.class)
		).logLevel(
			Logger.Level.FULL
		).target(
			serviceClass, configuration.apiBaseUrl()
		);
	}

	private static final org.slf4j.Logger _logger = LoggerFactory.getLogger(RestClientFactory.class.getName());

}
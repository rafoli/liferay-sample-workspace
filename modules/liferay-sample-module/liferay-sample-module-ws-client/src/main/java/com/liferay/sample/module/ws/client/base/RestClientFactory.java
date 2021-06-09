package com.liferay.sample.module.ws.client.base;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;

import com.liferay.sample.module.ws.config.RestAPIConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Oliveira
 */
@Component(service = RestClientFactory.class)
public class RestClientFactory<T> {

	public T getAPI(RestAPIConfiguration configuration, Class<T> serviceClass) {

		CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults(configuration.apiName());
		RateLimiter rateLimiter = RateLimiter.ofDefaults(configuration.apiName());

		FeignDecorators decorators =
				FeignDecorators.builder()
						.withCircuitBreaker(circuitBreaker)
						.withRateLimiter(rateLimiter)
						.build();

		return (T) Resilience4jFeign.builder(decorators)
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger())
				.logLevel(Logger.Level.FULL)
				.target(serviceClass, configuration.apiBaseUrl());
	}
}

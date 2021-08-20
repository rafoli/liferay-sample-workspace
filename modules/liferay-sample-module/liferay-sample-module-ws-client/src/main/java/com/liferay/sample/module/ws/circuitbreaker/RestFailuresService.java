package com.liferay.sample.module.ws.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;

import java.time.Duration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;


public class RestFailuresService {

	public <T> CircuitBreaker CircuitBreakerSample(Class<T> serviceClass) {
		
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.slidingWindowType(SlidingWindowType.COUNT_BASED)
				.slidingWindowSize(10)
				.failureRateThreshold(50.0f)
				.slowCallRateThreshold(50.0f)
				.slowCallDurationThreshold(Duration.ofSeconds(5))
				.build();
		
		CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
		
		CircuitBreaker circuitBreakerSample = circuitBreakerRegistry.circuitBreaker("SampleListAll");	
		
		return circuitBreakerSample;
	}
	
}

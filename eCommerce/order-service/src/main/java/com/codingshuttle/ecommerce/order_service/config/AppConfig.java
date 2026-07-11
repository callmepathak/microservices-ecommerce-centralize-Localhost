package com.codingshuttle.ecommerce.order_service.config;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public Capability capability(final MeterRegistry registry) {
        return new MicrometerCapability(registry);
    }

}



/*
What is Capability?

A Capability in Feign is an extension point that allows you to customize or enhance Feign's behavior.

Think of it like this:

Feign Client
      │
      ▼
HTTP Request
      │
      ▼
Capability can intercept here
      │
      ▼
Add logging
Add metrics
Add tracing
Modify requests

MicrometerCapability is one such capability.
 */


/*
@Bean
public Capability capability(MeterRegistry registry) {
    return new MicrometerCapability(registry);
}
1. Capability is an extension point in OpenFeign that allows you to customize Feign's behavior.
2. MicrometerCapability automatically collects metrics for every Feign client request, such as:
Total number of requests
Response time (latency)
Success and failure counts
3. MeterRegistry is Micrometer's central registry where all application metrics are stored.
These metrics can be exposed through Spring Boot Actuator (for example, /actuator/prometheus) and monitored using tools like Prometheus and Grafana.
One-line interview answer

MicrometerCapability is a Feign extension that automatically records metrics (request count, latency, success/failure) for all Feign client calls and stores them in the MeterRegistry, allowing monitoring tools like Prometheus and Grafana to visualize the performance of Feign requests.
 */

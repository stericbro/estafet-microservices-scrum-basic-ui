package com.estafet.microservices.scrum.basic.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The application class for the {@code basic-ui} web application microservice.
 *
 * This is a Spring Boot application.
 *
 * @author Dennis Williams, Etsfet Ltd.
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /**
     * The entry point.
     * @param args
     *          The arguments - there are none.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

	/**
	 * The Spring Bean to implement distributed tracing.
	 * @return
	 *         The {@link io.opentracing.Tracer} object traces though the application.
	 */
	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new com.uber.jaeger.Configuration("basic-ui",
				com.uber.jaeger.Configuration.SamplerConfiguration.fromEnv(),
				com.uber.jaeger.Configuration.ReporterConfiguration.fromEnv()).getTracer();
	}

	/**
	 * Get the REST client template.
	 *
	 * <p>The {@link RestTemplate} acts as the client for REST operations.</p>
	 *
	 * @param restTemplateBuilder
	 *         The REST template builder.
	 * @return
	 *         The {@link RestTemplate} that implements the REST client.
	 */
	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}

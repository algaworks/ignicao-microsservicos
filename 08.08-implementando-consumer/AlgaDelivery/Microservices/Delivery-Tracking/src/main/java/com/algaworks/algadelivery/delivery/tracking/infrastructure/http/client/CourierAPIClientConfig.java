package com.algaworks.algadelivery.delivery.tracking.infrastructure.http.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class CourierAPIClientConfig {

    @Bean
    public CourierAPIClient courierAPIClient(RestClient.Builder builder) {
        RestClient restClient = builder.baseUrl("http://localhost:8081").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();
        return proxyFactory.createClient(CourierAPIClient.class);
    }

}

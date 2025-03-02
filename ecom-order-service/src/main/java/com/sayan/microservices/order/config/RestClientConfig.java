package com.sayan.microservices.order.config;

import com.sayan.microservices.order.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${inventory.url}")
    private String inventoryServiceUrl;

    /**
     * Creates and configures an InventoryClient bean.
     *
     * @return an instance of InventoryClient
     */
    @Bean
    public InventoryClient inventoryClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(inventoryServiceUrl)
                .build();

        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyfactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyfactory.createClient(InventoryClient.class);
    }
}

package br.com.andretecnologia.config;

import br.com.andretecnologia.todo.JsonPlaceholderToDoRepository;
import br.com.andretecnologia.todo.ToDoRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JsonPlaceholderConfig {

    private final JsonPlaceholderConfigProperties properties;

    public JsonPlaceholderConfig( JsonPlaceholderConfigProperties properties ) {
        this.properties = properties;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri( properties.getRootUri() )
                .build();
    }

    @Bean
    ToDoRepository taskRepository( RestTemplate restTemplate, JsonPlaceholderConfigProperties properties ) {
        return new JsonPlaceholderToDoRepository( restTemplate, properties );
    }
}

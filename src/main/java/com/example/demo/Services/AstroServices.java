package com.example.demo.Services;

import com.example.demo.json.AstroResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroServices {
    private final RestTemplate template;
    private final WebClient client;
//    private final RestTemplateBuilder restTemplateBuilder;

    public AstroServices( RestTemplateBuilder builder) {
//        this.restTemplateBuilder = restTemplateBuilder;
        this.template = builder.rootUri("http://api.open-notify.org").build();
        this.client = WebClient.create("http://api.open-notify.org");
    }
    public String getPeopleInSpace(){
        return this.template.getForObject("/astros.json", String.class);
    }
    public AstroResponse getAstroResponse(){
        return this.template.getForObject("/astros.json", AstroResponse.class);
    }

    public AstroResponse getAstroResponseAsync(){
        return this.client.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofSeconds(2));
    }
}

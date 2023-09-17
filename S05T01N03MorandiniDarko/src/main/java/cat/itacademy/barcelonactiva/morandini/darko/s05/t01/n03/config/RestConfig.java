package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestConfig {
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

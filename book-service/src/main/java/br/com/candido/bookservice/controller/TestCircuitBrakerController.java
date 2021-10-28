package br.com.candido.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("book-service")
public class TestCircuitBrakerController {

    private Logger logger = LoggerFactory.getLogger(TestCircuitBrakerController.class);

    @GetMapping("test")
    //@Retry(name = "default", fallbackMethod = "fallbackMethod")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "default") //limita quantas requisicoes podem ser recebidas no endpoint 
    //@Bulkhead(name = "default") // quantidade de execucoes concorrentes podemos ter
    public String fooTest() {

	logger.info("chamando retry");

	return "String";
    }

    public String fallbackMethod(Exception e) {
	return "fallbackMethod";
    }

}

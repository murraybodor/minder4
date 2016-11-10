package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	private RestTemplate restTemplate;

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	restTemplate = builder.build(); 
		return restTemplate;
	}

    @RequestMapping("/")
    public String index() {
		log.info("in index");
        return "Hello this is the index!";
    }
    
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/greeting")
    public Greeting greetingRestService(@RequestParam(value="name", defaultValue="World") String name) {
		log.info(String.format(template, name));
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/quote")
    public Greeting quoteRestClient(@RequestParam(value="name", defaultValue="World") String name) {
    	Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());
        return new Greeting(counter.incrementAndGet(),
        		quote.toString());
    }
    
}
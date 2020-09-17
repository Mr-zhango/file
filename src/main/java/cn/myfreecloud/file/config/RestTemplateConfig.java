package cn.myfreecloud.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
    	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();  
    	requestFactory.setConnectTimeout(3000);  
    	requestFactory.setReadTimeout(3000);  
       
    	RestTemplate restTemplate = new RestTemplate(requestFactory);  
        return restTemplate;
    }

}

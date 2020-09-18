package cn.myfreecloud.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
    	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();  
    	requestFactory.setConnectTimeout(3000);  
    	requestFactory.setReadTimeout(3000);


    	// 解决url转义问题
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        DefaultUriBuilderFactory uriFactory = new DefaultUriBuilderFactory();
        uriFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        restTemplate.setUriTemplateHandler(uriFactory);
        return restTemplate;
    }

}

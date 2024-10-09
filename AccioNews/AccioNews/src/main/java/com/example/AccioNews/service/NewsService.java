package com.example.AccioNews.service;

import com.example.AccioNews.response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;
    
    String baseUrl = "https://newsapi.org/v2/top-headlines";

    public NewsResponse getNewsBySource(String source,
                                  String apiKey) {
        String url = prepareUrl(source,apiKey);
        return restTemplate.getForObject(url, NewsResponse.class);
    }

    private String prepareUrl(String source, String apiKey) {
        return baseUrl + "?sources=" + source + "&apiKey=" + apiKey;
    }
}

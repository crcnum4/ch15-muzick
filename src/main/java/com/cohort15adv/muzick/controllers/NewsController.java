package com.cohort15adv.muzick.controllers;

import com.cohort15adv.muzick.payloads.ApiResponse.Article;
import com.cohort15adv.muzick.payloads.ApiResponse.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${muzick.props.apikey}")
    public String apiKey;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute() {
        return new ResponseEntity<>("News Routes", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getMusicArticles() {
        String url = "https://newsapi.org/v2/everything?apikey=" + apiKey + "&q=music";

        NewsApi response = restTemplate.getForObject(url, NewsApi.class);

//        List<Article> articleList = new ArrayList<>();

        for (Article article : response.getArticles()) {
            if (article.getSoureName().equals("Wired")) {
                article.setLikes("hi");
//                articleList.add(article);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

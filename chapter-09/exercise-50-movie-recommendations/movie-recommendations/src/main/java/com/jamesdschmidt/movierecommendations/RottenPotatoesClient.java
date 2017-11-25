package com.jamesdschmidt.movierecommendations;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rotten-potatoes", url = "${com.jamesdschmidt.movierecommendations.rottenpotatoes.url}")
public interface RottenPotatoesClient {

  @RequestMapping(value = "/movies", method = RequestMethod.GET)
  List<Movie> getMovies(@RequestParam("apikey") String apikey, @RequestParam("q") String q);
}

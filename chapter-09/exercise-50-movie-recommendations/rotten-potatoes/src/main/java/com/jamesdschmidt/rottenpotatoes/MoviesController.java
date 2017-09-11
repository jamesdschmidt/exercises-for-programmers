package com.jamesdschmidt.rottenpotatoes;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

	@GetMapping("/movies")
	public List<Movie> getMovies(@RequestParam String apiKey, @RequestParam String q) {
		
	}
}

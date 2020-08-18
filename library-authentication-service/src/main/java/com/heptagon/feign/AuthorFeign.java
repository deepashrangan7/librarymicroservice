package com.heptagon.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.heptagon.model.Author;

//to communicate with author service
@FeignClient(name = "library-zuul-gateway")
@RibbonClient(name="library-authorservice")//client side load balancing
public interface AuthorFeign {

	@PostMapping("/library-authorservice/author/add")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author);
}

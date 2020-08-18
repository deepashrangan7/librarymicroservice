package com.heptagon.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.heptagon.model.Author;

//to communicate with author service
@FeignClient(name = "library-zuul-gateway")//fetching port and address from naming server eureka
@RibbonClient(name="library-authorservice")//client side load balancing
public interface AuthorFeign {

	@GetMapping("/library-authorservice/author/view/{authorid}")
	public Author getAuthor(@PathVariable("authorid") Long authorId);//get author object based on ID by calling API end point

}

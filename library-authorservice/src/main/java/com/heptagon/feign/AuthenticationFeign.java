package com.heptagon.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="library-zuul-gateway")
@RibbonClient(name="library-authentication-service")//client side load balancing
public interface AuthenticationFeign {

	@PostMapping("/library-authentication-service/authenticate/validate")
	public boolean validateToken(@RequestBody String token);
	
	@PostMapping("/library-authentication-service/authenticate/username")
	public String userName(String token);
	
}

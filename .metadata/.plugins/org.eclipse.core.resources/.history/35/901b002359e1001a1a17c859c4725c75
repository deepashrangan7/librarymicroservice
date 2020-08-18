package com.heptagon.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="library-authentication-service")
@RibbonClient(name="library-authentication-service")//client side load balancing
public interface AuthenticationFeign {

	@PostMapping("authenticate/validate")
	public boolean validateToken(String token);
	
	@PostMapping("authenticate/username")
	public String userName(String token);
	
}

package org.cx.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 *	FeignClient(name="service服务名",configuration = FeignConfiguration.class)
 *	需要更改feign的配置则需指定configuration，服务配置类
 *	
 *
 */
//@FeignClient(name="cloud-test",configuration = FeignConfiguration.class)
@FeignClient(name="cloud-test")
public interface TestService {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
  String hello(@RequestParam(value = "name") String name);

}

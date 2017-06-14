package org.cx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${server.port}")
  String port;
	
	@RequestMapping(value="/hello")
	public String test(@RequestParam String name) {
		return "--"+name+",port:"+port;
	}
}

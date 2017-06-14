package org.cx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/test")
	public String test(@RequestParam String name) {
		String res = restTemplate.getForObject("http://cloud-test/hello?name="+name, String.class);
		return res;
	}
}

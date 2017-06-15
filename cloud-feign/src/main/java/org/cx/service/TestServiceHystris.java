package org.cx.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceHystris implements TestService {

	@Override
	public String hello(String name) {
		return "sorry" + name;
	}

}

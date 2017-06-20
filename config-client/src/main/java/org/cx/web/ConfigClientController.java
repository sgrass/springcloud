package org.cx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${foo}")
	private String foo;
	
	@RequestMapping(value="/getConfig")
	public String getConfig() {
		return 	foo;
	}
}

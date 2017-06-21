package org.cx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${foo}")
	private String foo;
	
	@RequestMapping(value="/getConfig",method=RequestMethod.GET)
	public String getConfig() {
		return 	foo;
	}
}

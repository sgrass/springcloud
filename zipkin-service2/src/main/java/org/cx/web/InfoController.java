package org.cx.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InfoController {

	private static final Logger LOG = Logger.getLogger(InfoController.class.getName());

	
	@Autowired
  private RestTemplate restTemplate;

  @Bean
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }
  
  @RequestMapping("/hi")
  public String home(){
      LOG.log(Level.INFO, "hi is being called");
      return "hi i'm miya!";
  }

  @RequestMapping("/miya")
  public String info(){
      LOG.log(Level.INFO, "info is being called");
      return restTemplate.getForObject("http://localhost:8881/info",String.class);
  }

}

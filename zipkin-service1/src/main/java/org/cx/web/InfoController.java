package org.cx.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
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
  public String callHome(){
      LOG.log(Level.INFO, "calling trace service-hi  ");
      return restTemplate.getForObject("http://localhost:8882/miya", String.class);
  }
  @RequestMapping("/info")
  public String info(){
      LOG.log(Level.INFO, "calling trace service-hi ");
      return "i'm service-hi";

  }

  @Bean
  public AlwaysSampler defaultSampler(){
      return new AlwaysSampler();
  }
}

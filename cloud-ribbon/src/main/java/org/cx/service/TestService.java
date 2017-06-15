package org.cx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
  @LoadBalanced
  RestTemplate restTemplate() {
      return new RestTemplate();
  }
	
	/**
	 * ribbon调用远程服务
	 * 断路由 继承HystrixCommand 或 HystrixObservableCommand 重写run()或construct()
	 * 	run()是由新创建的线程执行；后者的construct()是由调用程序线程执行
	 * 	run()一个实例只能向调用程序发送（emit）单条数据；后者一个实例可以顺序发送多条数据，甚至还能发送一个范围的数据集
	 * 
	 * @param name
	 * @return
	 */
	@HystrixCommand(fallbackMethod="testFallback")
	public String test(String name) {
		String res = restTemplate.getForObject("http://cloud-test/hello?name="+name, String.class);
		return res;
	}
	
	/**
	 * fallback方法参数必须和原方法一致
	 * @param name
	 * @return
	 */
	public String testFallback(String name) {
    return name + "sorry,error!";
	}
}

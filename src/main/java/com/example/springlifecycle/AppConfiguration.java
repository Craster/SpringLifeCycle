package com.example.springlifecycle;

import com.example.springlifecycle.quoter.processors.DeprecationHandlerBeanFactoryPostProcessor;
import com.example.springlifecycle.quoter.processors.InjectRandomIntAnnotationBeanPostProcessor;
import com.example.springlifecycle.quoter.processors.PostProxyInvokerContextListener;
import com.example.springlifecycle.quoter.processors.ProfilingHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
    return new InjectRandomIntAnnotationBeanPostProcessor();
  }

  @Bean
  public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
    return new ProfilingHandlerBeanPostProcessor();
  }

  @Bean
  public PostProxyInvokerContextListener postProxyInvokerContextListener() {
    return new PostProxyInvokerContextListener();
  }

  @Bean
  public DeprecationHandlerBeanFactoryPostProcessor deprecationHandlerBeanFactoryPostProcessor(){
    return new DeprecationHandlerBeanFactoryPostProcessor();
  }


}

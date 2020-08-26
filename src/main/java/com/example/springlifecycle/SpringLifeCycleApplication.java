package com.example.springlifecycle;

import com.example.springlifecycle.quoter.Quoter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLifeCycleApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SpringLifeCycleApplication.class, args);
    context.getBean(Quoter.class).sayQuote();

  }

}

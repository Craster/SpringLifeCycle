package com.example.springlifecycle;

import com.example.springlifecycle.filecontext.PropertyFileApplicationContext;
import com.example.springlifecycle.quoter.Quoter;
import org.junit.jupiter.api.Test;

class PropertyFileApplicationContextTest {

  @Test
  void test(){

    PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
    context.getBean(Quoter.class).sayQuote();

  }

}

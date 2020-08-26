package com.example.springlifecycle.filecontext;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {
  public PropertyFileApplicationContext(String filename) {

    PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
    int i = reader.loadBeanDefinitions(filename);
    System.out.println("found " + i + " beans");
    refresh();

  }
}

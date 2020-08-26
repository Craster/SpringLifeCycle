package com.example.springlifecycle.quoter.processors;

import com.example.springlifecycle.quoter.annotations.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
    String[] names = factory.getBeanDefinitionNames();
    for (String name : names) {
      BeanDefinition beanDefinition = factory.getBeanDefinition(name);
      String beanClassName = beanDefinition.getBeanClassName();
      if (beanClassName != null) {
        try {

          Class<?> beanClass = Class.forName(beanClassName);
          DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
          if (annotation != null) {
            beanDefinition.setBeanClassName(annotation.newImpl().getName());
          }
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

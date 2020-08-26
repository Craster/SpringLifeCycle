package com.example.springlifecycle.quoter.processors;

import com.example.springlifecycle.quoter.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

    Field[] fields = bean.getClass().getDeclaredFields(); //get fields of bean

    for (Field field : fields) {
      InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class); //Get InjectRandomInt annotation
      if (annotation != null) {
        int min = annotation.min();
        int max = annotation.max();
        Random random = new Random();
        int i = min + random.nextInt(max - min);
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, i); //set i value to field of current bean
      }
    }

    return bean;
  }

}

package com.example.springlifecycle.quoter.processors;

import com.example.springlifecycle.quoter.Profiling;
import com.example.springlifecycle.quoter.ProfilingController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

  private Map<String, Class> map = new HashMap<>();
  private ProfilingController controller = new ProfilingController();

  public ProfilingHandlerBeanPostProcessor() throws Exception {
    MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
    mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (beanClass.isAnnotationPresent(Profiling.class)) {
      map.put(beanName, beanClass);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

    //bean could be already proxy
    Class beanClass = map.get(beanName);
    if (beanClass != null) {
      return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          if (controller.isEnabled()) {
            System.out.println("Profiling...");
            long start = System.nanoTime();
            Object result = method.invoke(bean, args);
            System.out.println("Profiled");
            System.out.println(System.nanoTime() - start);
            return result;
          } else {
            return method.invoke(bean, args);
          }
        }
      });
    }
    return bean;
  }
}

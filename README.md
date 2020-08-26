#Spring Life Cycles

SpringLifeCycleApplication - 3 phase of spring life cycles

- Phase 1 java constructor
- BeforeInitialization of BeanPostProcessors
- Phase 2 @PostConstruct (between before and after  )
- AfterInitialization of BeanPostProcessors
- Phase 3 after proxy configured. Emitted by ApplicationContext on ContextRefreshedEvent and can be listened by ApplicationListener (see PostProxyInvokerContextListener)

If we want to work with configured and proxied beans we should do it with ApplicationListener.

```NOTE: *Do not make proxy class on BeforeInitialization it should always be made on AfterInitialization.*```

## BeanFactoryPostProcessor (BFPP)
DeprecationHandlerBeanFactoryPostProcessor - example how BeanFactoryPostProcessor works
BFPPs runs after beanDefenitions have bean read and can change beanDefenitions.

## Property File ApplicationContext

Custom ApplicationContext that used files to define beans. 

Run test:
PropertyFileApplicationContextTest - example of file properties ApplicationContext


package trp.antonius.dicontainer.ioc.context;

import lombok.Setter;
import lombok.SneakyThrows;
import trp.antonius.dicontainer.ioc.factory.BeanFactory;
import trp.antonius.dicontainer.ioc.postprocessor.BeanPostProcessor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppContext {

    @Setter
    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap = new ConcurrentHashMap<>();

    public AppContext() {
    }

    public <T> T getBean(Class<T> tClass) {
        if (beanMap.containsKey(tClass)) {
            return (T) beanMap.get(tClass);
        }
        T bean = beanFactory.getBean(tClass);
        callPostProcessors(bean);
        beanMap.put(tClass, bean);
        return bean;
    }

    @SneakyThrows
    private void callPostProcessors(Object bean) {
        for (Class<? extends BeanPostProcessor> processor : beanFactory.getBeanConfigurator().getScanner().getSubTypesOf(BeanPostProcessor.class)) {
            BeanPostProcessor postProcessor = processor.getDeclaredConstructor().newInstance();
            postProcessor.process(bean);
        }
    }

}
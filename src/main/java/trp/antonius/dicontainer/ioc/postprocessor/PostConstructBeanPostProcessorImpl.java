package trp.antonius.dicontainer.ioc.postprocessor;

import lombok.SneakyThrows;
import trp.antonius.dicontainer.ioc.annotation.PostConstruct;

import java.lang.reflect.Method;

public class PostConstructBeanPostProcessorImpl implements BeanPostProcessor {

    @SneakyThrows
    @Override
    public void process(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(bean);
            }
        }
    }

}
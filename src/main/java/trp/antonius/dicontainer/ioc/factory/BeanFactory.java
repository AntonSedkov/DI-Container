package trp.antonius.dicontainer.ioc.factory;

import lombok.Getter;
import lombok.SneakyThrows;
import trp.antonius.dicontainer.ioc.annotation.Inject;
import trp.antonius.dicontainer.ioc.config.Configuration;
import trp.antonius.dicontainer.ioc.config.JavaConfiguration;
import trp.antonius.dicontainer.ioc.configurator.BeanConfigurator;
import trp.antonius.dicontainer.ioc.configurator.JavaBeanConfigurator;
import trp.antonius.dicontainer.ioc.context.AppContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    @Getter
    private final BeanConfigurator beanConfigurator;

    private final Configuration configuration;
    private AppContext appContext;

    public BeanFactory(AppContext appContext) {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.receiveInterfaceToImpls());
        this.appContext = appContext;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> tClass) {
        Class<? extends T> implClass = tClass;
        if (implClass.isInterface()) {
            implClass = beanConfigurator.getImplementationClass(implClass);
        }
        T bean = implClass.getDeclaredConstructor().newInstance();
        for (Field field : Arrays.stream(implClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).collect(Collectors.toList())) {
            field.setAccessible(true);
            field.set(bean, appContext.getBean(field.getType()));
        }
        return bean;
    }

}
package trp.antonius.dicontainer.ioc.configurator;

import org.reflections.Reflections;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);

    Reflections getScanner();

}
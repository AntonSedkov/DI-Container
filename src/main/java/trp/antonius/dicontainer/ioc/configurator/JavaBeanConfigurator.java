package trp.antonius.dicontainer.ioc.configurator;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class JavaBeanConfigurator implements BeanConfigurator {

    @Getter
    private final Reflections scanner;
    private final Map<Class, Class> interfaceToImpls;

    public JavaBeanConfigurator(String packageToScan, Map<Class, Class> interfaceToImpls) {
        this.scanner = new Reflections(packageToScan);
        this.interfaceToImpls = new ConcurrentHashMap<>(interfaceToImpls);
    }

    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        return interfaceToImpls.computeIfAbsent(interfaceClass, tClass -> {
            Set<Class<? extends T>> implementationClasses = scanner.getSubTypesOf(interfaceClass);
            if (implementationClasses.size() != 1) {
                throw new RuntimeException("Interface has 0 or more than 1 implementations");
            }
            return implementationClasses.stream().findFirst().get();
        });
    }

}
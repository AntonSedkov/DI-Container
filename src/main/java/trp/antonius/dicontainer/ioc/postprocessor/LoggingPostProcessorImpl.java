package trp.antonius.dicontainer.ioc.postprocessor;

public class LoggingPostProcessorImpl implements BeanPostProcessor {

    @Override
    public void process(Object bean) {
        System.out.println(String.format("Log: bean has been created: %s", bean.getClass()));
    }

}
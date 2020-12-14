package trp.antonius.dicontainer;

import trp.antonius.dicontainer.client.NewYearOrganizer;
import trp.antonius.dicontainer.ioc.context.AppContext;
import trp.antonius.dicontainer.ioc.factory.BeanFactory;

public class Application {

    public AppContext run() {
        AppContext appContext = new AppContext();
        BeanFactory beanFactory = new BeanFactory(appContext);
        appContext.setBeanFactory(beanFactory);
        return appContext;
    }

    public static void main(String[] args) {
        Application application = new Application();
        AppContext context = application.run();

        NewYearOrganizer newYearOrganizer = context.getBean(NewYearOrganizer.class);
        newYearOrganizer.prepareToCelebration();
    }

}
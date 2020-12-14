package trp.antonius.dicontainer.ioc.config;

import java.util.Map;

public interface Configuration {

    String getPackageToScan();

    Map<Class, Class> receiveInterfaceToImpls();

}
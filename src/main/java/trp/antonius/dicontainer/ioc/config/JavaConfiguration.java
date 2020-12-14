package trp.antonius.dicontainer.ioc.config;

import trp.antonius.dicontainer.service.PaymentSystem;
import trp.antonius.dicontainer.service.impl.CashPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration {

    @Override
    public String getPackageToScan() {
        return "trp.antonius.dicontainer";
    }

    @Override
    public Map<Class, Class> receiveInterfaceToImpls() {
        return Map.of(PaymentSystem.class, CashPaymentSystem.class);
    }

}
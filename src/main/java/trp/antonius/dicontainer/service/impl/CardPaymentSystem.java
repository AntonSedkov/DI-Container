package trp.antonius.dicontainer.service.impl;

import trp.antonius.dicontainer.model.Gift;
import trp.antonius.dicontainer.service.PaymentSystem;

public class CardPaymentSystem implements PaymentSystem {

    @Override
    public void pay(Gift gift) {
        System.out.println(String.format("Pay %d for %s by Card", gift.getPrice(), gift.getName()));
    }

}
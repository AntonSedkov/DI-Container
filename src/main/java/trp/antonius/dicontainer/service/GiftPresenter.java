package trp.antonius.dicontainer.service;

import trp.antonius.dicontainer.ioc.annotation.Inject;
import trp.antonius.dicontainer.ioc.annotation.PostConstruct;
import trp.antonius.dicontainer.model.Gift;
import trp.antonius.dicontainer.model.Person;

public class GiftPresenter {

    @Inject
    private GiftChooseHelper giftChooseHelper;

    @Inject
    private PaymentSystem paymentSystem;

    @Inject
    private DeliverySystem deliverySystem;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Gift presenter has been initialized!");
    }

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }

}
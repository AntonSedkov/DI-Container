package trp.antonius.dicontainer.service.impl;

import trp.antonius.dicontainer.model.Gift;
import trp.antonius.dicontainer.model.Person;
import trp.antonius.dicontainer.service.DeliverySystem;

public class PostDeliverySystem implements DeliverySystem {

    @Override
    public void deliver(Gift gift, Person person) {
        System.out.println(String.format("Gift %s delivered to %s by POST", gift.getName(), person.getName()));
    }

}
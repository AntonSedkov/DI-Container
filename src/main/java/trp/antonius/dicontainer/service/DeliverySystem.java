package trp.antonius.dicontainer.service;

import trp.antonius.dicontainer.model.Gift;
import trp.antonius.dicontainer.model.Person;

public interface DeliverySystem {

    void deliver(Gift gift, Person person);

}
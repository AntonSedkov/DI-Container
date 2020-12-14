package trp.antonius.dicontainer.service.impl;

import trp.antonius.dicontainer.ioc.annotation.Inject;
import trp.antonius.dicontainer.model.Gift;
import trp.antonius.dicontainer.model.Person;
import trp.antonius.dicontainer.service.GiftChooseHelper;
import trp.antonius.dicontainer.service.Recommendator;

public class SmartGiftChooseHelper implements GiftChooseHelper {

    @Inject
    private Recommendator recommendator;

    @Override
    public Gift choose(Person person) {
        recommendator.recommend();
        return new Gift("Smart watches", 10000);
    }

}
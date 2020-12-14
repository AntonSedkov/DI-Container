package trp.antonius.dicontainer.client;

import trp.antonius.dicontainer.ioc.annotation.Inject;
import trp.antonius.dicontainer.model.Person;
import trp.antonius.dicontainer.service.GiftPresenter;

public class NewYearOrganizer {

    @Inject
    private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person friend = new Person("Vasil Vasilich");
        giftPresenter.present(friend);
    }

}
package fun.sale.storage;

import fun.sale.domain.Buyer;

import java.util.List;

public class PrivateBuyersStorage extends AbstractBuyerStorage {

    @Override
    protected List<Buyer> initDefaultBuyers(List<Buyer> buyers) {
        buyers.add(new Buyer("Lady bug", 0.95f));
        buyers.add(new Buyer("Spiderman", 0.97f));
        buyers.add(new Buyer("Batman", 0.9f));

        return buyers;
    }
}

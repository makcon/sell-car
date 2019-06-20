package fun.sale.storage;

import fun.sale.domain.Buyer;

import java.util.List;

public class DealerStorage extends AbstractBuyerStorage {

    @Override
    protected List<Buyer> initDefaultBuyers(List<Buyer> buyers) {
        buyers.add(new Buyer("Mike", 0.7f));
        buyers.add(new Buyer("Sofia", 0.6f));
        buyers.add(new Buyer("Maks", 0.5f));

        return buyers;
    }
}

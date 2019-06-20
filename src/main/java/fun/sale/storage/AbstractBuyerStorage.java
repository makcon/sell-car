package fun.sale.storage;

import fun.sale.domain.Buyer;
import fun.sale.domain.BuyerOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public abstract class AbstractBuyerStorage implements BuyersStorage {

    private final List<Buyer> defaultBuyers = initDefaultBuyers(new ArrayList<>());

    @Override
    public Optional<Buyer> findRandom(List<BuyerOffer> toExclude) {
        Collections.shuffle(defaultBuyers);
        List<Buyer> toExcludeBuyers = toExclude.stream()
                .map(BuyerOffer::getBuyer)
                .collect(toList());

        return defaultBuyers.stream()
                .filter(it -> !toExcludeBuyers.contains(it))
                .findFirst();
    }

    protected abstract List<Buyer> initDefaultBuyers(List<Buyer> buyers);
}

package fun.sale.storage;

import fun.sale.domain.Buyer;
import fun.sale.domain.BuyerOffer;

import java.util.*;

@FunctionalInterface
public interface BuyersStorage {

    Optional<Buyer> findRandom(List<BuyerOffer> toExclude);
}

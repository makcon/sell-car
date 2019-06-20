package fun.sale.storage;

import fun.sale.domain.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SellersStorage {

    private static final List<Seller> SELLERS = new ArrayList<>();

    public void save(Seller seller) {
        SELLERS.add(seller);
    }

    public Optional<Seller> findByName(String name) {
        return SELLERS.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst();
    }
}

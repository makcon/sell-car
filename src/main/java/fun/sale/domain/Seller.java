package fun.sale.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seller {

    private final String name;
    private Car car;
    private final List<BuyerOffer> dealerOffers = new ArrayList<>();
    private final List<BuyerOffer> privateBuyerOffers = new ArrayList<>();
    private final List<SoldCar> soldCars = new ArrayList<>();
}

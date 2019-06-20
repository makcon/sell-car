package fun.sale.domain;

import lombok.Data;

@Data
public class BuyerOffer {

    private final Buyer buyer;
    private final int price;
}

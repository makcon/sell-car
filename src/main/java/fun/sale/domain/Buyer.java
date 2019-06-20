package fun.sale.domain;

import lombok.Data;

@Data
public class Buyer {

    private final String name;
    private final float discountFactor;
}

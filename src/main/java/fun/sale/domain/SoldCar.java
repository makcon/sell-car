package fun.sale.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SoldCar {

    private final Car car;
    private final int price;
    private final Buyer buyer;
}

package fun.sale.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private final String model;
    private final int year;
    private final int price;

    public static Car fromString(String input) {
        String[] details = input.split("\\|");

        return Car.builder()
                .model(details[0])
                .year(Integer.parseInt(details[1]))
                .price(Integer.parseInt(details[2]))
                .build();
    }
}

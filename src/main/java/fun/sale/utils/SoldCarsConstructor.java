package fun.sale.utils;

import fun.sale.domain.SoldCar;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SoldCarsConstructor {

    private static final String TEMPLATE =
            "************************************\n" +
                    " Model: %s\n" +
                    " Year: %d\n" +
                    " Requested price: %d\n" +
                    " Sold to buyer '%s' for %s \n" +
                    "************************************";

    public String construct(List<SoldCar> soldCars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (SoldCar car : soldCars) {
            String line = String.format(
                    TEMPLATE,
                    car.getCar().getModel(),
                    car.getCar().getYear(),
                    car.getCar().getPrice(),
                    car.getBuyer().getName(),
                    car.getPrice()
            );
            stringBuilder.append(line);
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}

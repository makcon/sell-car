package fun.sale.utils;

import fun.sale.domain.Car;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AdConstructor {

    private static final String TEMPLATE =
            "********* The car for sale *********\n" +
                    " Model: %s\n" +
                    " Year: %d\n" +
                    " Price: %d\n" +
                    "************************************";

    public String build(Car car) {
        return String.format(TEMPLATE, car.getModel(), car.getYear(), car.getPrice());
    }
}

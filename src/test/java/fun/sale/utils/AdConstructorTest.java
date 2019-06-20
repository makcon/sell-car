package fun.sale.utils;

import fun.sale.domain.Car;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdConstructorTest {

    private static final String TEMPLATE =
            "********* The car for sale *********\n" +
                    " Model: %s\n" +
                    " Year: %d\n" +
                    " Price: %d\n" +
                    "************************************";

    @Test
    public void build_shouldInsertParamsProperly() {
        String model = "Toyota Prius";
        int year = 2006;
        int price = 5000;
        Car car = Car.builder().model(model).year(year).price(price).build();

        String ad = AdConstructor.build(car);

        assertThat(ad, equalTo(String.format(TEMPLATE, model, year, price)));
    }
}
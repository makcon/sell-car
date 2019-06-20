package fun.sale.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void fromString_shouldBuildCorrectObject() {
        var input = "toyota|2006|5000";

        Car car = Car.fromString(input);

        assertThat(car.getModel(), equalTo("toyota"));
        assertThat(car.getYear(), equalTo(2006));
        assertThat(car.getPrice(), equalTo(5000));
    }
}
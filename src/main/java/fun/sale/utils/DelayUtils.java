package fun.sale.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DelayUtils {

    public void delay(int millis) {
        // simple delay emulator
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

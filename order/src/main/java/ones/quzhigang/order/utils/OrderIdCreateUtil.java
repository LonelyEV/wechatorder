package ones.quzhigang.order.utils;

import java.util.Random;

public class OrderIdCreateUtil {

    public static synchronized String getUinqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000)+10000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}

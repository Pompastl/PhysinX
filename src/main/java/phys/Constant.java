package phys;

import java.math.BigDecimal;
import java.util.Random;

public interface Constant {
    static BigDecimal getRandomBigDecimal() {
        int d = new Random().nextInt(999999999);
        return new BigDecimal(d + "." + d);
    }


}

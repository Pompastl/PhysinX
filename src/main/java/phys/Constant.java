package phys;

import java.math.BigDecimal;
import java.util.Random;

public interface Constant {
    static BigDecimal getRandomBigDecimal() {
        int d = new Random().nextInt(999999999);
        return new BigDecimal(d + "." + d);
    }

    static BigDecimal getConversionFactorDistance(SiSystem orig, SiSystem to) throws Exception {

        if (orig == to || (orig == null || to == null))
            throw new Exception("Error: Same units, No need to convert");

        if (orig == SiSystem.DISTANCE_KM && to == SiSystem.DISTANCE_M)
            return new BigDecimal("1000");

        if (orig == SiSystem.DISTANCE_KM && to == SiSystem.DISTANCE_SM)
            return new BigDecimal("100000");

        if (orig == SiSystem.DISTANCE_KM && to == SiSystem.DISTANCE_MM)
            return new BigDecimal("1000000");


        if (orig == SiSystem.DISTANCE_MM && to == SiSystem.DISTANCE_SM)
            return new BigDecimal("0.1");

        if (orig == SiSystem.DISTANCE_MM && to == SiSystem.DISTANCE_M)
            return new BigDecimal("0.001");

        if (orig == SiSystem.DISTANCE_MM && to == SiSystem.DISTANCE_KM)
            return new BigDecimal("0.000001");


        if (orig == SiSystem.DISTANCE_M && to == SiSystem.DISTANCE_SM)
            return new BigDecimal("100");

        if (orig == SiSystem.DISTANCE_M && to == SiSystem.DISTANCE_KM)
            return new BigDecimal("0.001");

        if (orig == SiSystem.DISTANCE_M && to == SiSystem.DISTANCE_MM)
            return new BigDecimal("1000");


        if (orig == SiSystem.DISTANCE_SM && to == SiSystem.DISTANCE_KM)
            return new BigDecimal("100000");

        if (orig == SiSystem.DISTANCE_SM && to == SiSystem.DISTANCE_M)
            return new BigDecimal("0.01");

        if (orig == SiSystem.DISTANCE_SM && to == SiSystem.DISTANCE_MM)
            return new BigDecimal("10");


        throw new Exception("Error: One or both variables are not distance values");
    }

}

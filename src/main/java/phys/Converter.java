package phys;

import java.math.BigDecimal;

public class Converter implements Constant{

    public BigDecimal distance(BigDecimal num, SiSystem orig, SiSystem to) throws Exception {
        return num.multiply(Constant.getConversionFactorDistance(orig, to));
    }

    public BigDecimal time(BigDecimal num, SiSystem orig, SiSystem to) throws Exception {
        return num.multiply(Constant.getConversionFactorTime(orig, to));
    }

}

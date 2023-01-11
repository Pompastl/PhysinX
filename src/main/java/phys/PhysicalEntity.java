package phys;

import java.math.BigDecimal;

public class PhysicalEntity extends Converter{

    protected BigDecimal speed_V0;
    protected BigDecimal speed_V1;
    protected BigDecimal time_t;
    protected BigDecimal boost_a;
    protected BigDecimal distance_S;

    public void setValue(ValueEntity value, double num){
        setValue(value, String.valueOf(num));
    }

    public void setValue(ValueEntity value, long num){
        setValue(value, String.valueOf(num));
    }

    public void setValue(ValueEntity value, String num){
        BigDecimal valueToSet = new BigDecimal(num);
        setValue(value, valueToSet);
    }

    public void setValue(ValueEntity value, BigDecimal num){
        switch (value){
            case BOOST_a -> boost_a = num;
            case DISTANCE_S -> distance_S = num;
            case SPEED_V0 -> speed_V0 = num;
            case SPEED_V1 -> speed_V1 = num;
            case TIME_t -> time_t = num;
        }
    }

    public BigDecimal getValue(ValueEntity value){
        return switch (value) {
            case TIME_t -> time_t;
            case SPEED_V1 -> speed_V1;
            case SPEED_V0 -> speed_V0;
            case DISTANCE_S -> distance_S;
            case BOOST_a -> boost_a;
        };
    }

    public void convert(ValueEntity value, SiSystem orig, SiSystem to) {
        try {
            BigDecimal num = distance(getValue(value), orig, to);
            setValue(value, num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

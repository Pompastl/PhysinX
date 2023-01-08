package phys;

import java.math.BigDecimal;

public class PhysicalEntity {
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

        switch (value){
            case BOOST_a -> boost_a = valueToSet;
            case DISTANCE_S -> distance_S = valueToSet;
            case SPEED_V0 -> speed_V0 = valueToSet;
            case SPEED_V1 -> speed_V1 = valueToSet;
            case TIME_t -> time_t = valueToSet;
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

}

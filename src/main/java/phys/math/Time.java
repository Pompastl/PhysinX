package phys.math;

import phys.PhysicalEntity;
import phys.ValueEntity;

import java.math.BigDecimal;

public class Time extends PhysicalEntity {

    @Override
    public BigDecimal getValue() {
        int formula = getFormula(ValueEntity.TIME_t);

        if (formula == 1)
            return distance_S.divide(getSpeed());

        return null;
    }



}

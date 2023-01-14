package phys.math;

import phys.PhysicalEntity;
import phys.ValueEntity;

import java.math.BigDecimal;

public class Distance extends PhysicalEntity {

    @Override
    public BigDecimal getValue() {
        int formula = getFormula(ValueEntity.DISTANCE_S);

        if (formula == 1)
            return getSpeed().multiply(time_t);


        return null;
    }
}

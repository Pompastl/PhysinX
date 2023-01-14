package phys;

import phys.math.FormulaManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhysicalEntity extends Converter{

    protected BigDecimal speed_V0;
    protected BigDecimal speed_V1;
    protected BigDecimal time_t;
    protected BigDecimal boost_a;
    protected BigDecimal distance_S;
    protected static List<ValueEntity> knowValues = new ArrayList<ValueEntity>();
    protected String formula = "";

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

        if (num.equals(ZERO) && knowValues.contains(value)){
            knowValues.remove(value);
            return;
        }

        knowValues.add(value);
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

    public BigDecimal getValue(){
        return null;
    }

    public void convert(ValueEntity value, SiSystem orig, SiSystem to) throws Exception {

        BigDecimal num = distance(getValue(value), orig, to);
        setValue(value, num);

    }

    protected int getFormula(ValueEntity value){
        FormulaManager formulaManager = new FormulaManager(knowValues);
        int i = formulaManager.getFor(value);
        formula = formulaManager.toString();

        return i;
    }

    protected BigDecimal getSpeed() {
        return speed_V0.equals(ZERO) ? speed_V1 : speed_V0;
    }

    @Override
    public String toString() {
        return formula;
    }
}


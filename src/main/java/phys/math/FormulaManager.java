package phys.math;

import phys.ValueEntity;

import java.util.ArrayList;
import java.util.List;

public class FormulaManager {
    private static List<ValueEntity> knowValues = new ArrayList<>();
    private static String formula = "";

    public FormulaManager(List<ValueEntity> knowValues) {
        FormulaManager.knowValues = knowValues;
    }

    public int getFor(ValueEntity value){
        return switch (value){

            case SPEED_V0 -> 0;
            case SPEED_V1 -> 0;
            case TIME_t -> time();
            case BOOST_a -> 0;
            case DISTANCE_S -> distance();

        };

    }


    private static int time(){
        if (knowValues.contains(ValueEntity.DISTANCE_S) && (knowValues.contains(ValueEntity.SPEED_V0)
                || knowValues.contains(ValueEntity.SPEED_V1)) && knowValues.size() == 2){
            formula = "distance" + " / " + "speed";
            return 1;
        }

        return -1;
    }

    private static int distance(){
        if (knowValues.contains(ValueEntity.TIME_t) && (knowValues.contains(ValueEntity.SPEED_V0)
                || knowValues.contains(ValueEntity.SPEED_V1))){
            formula = "speed" + " * " + "time";
            return 1;
        }

        return -1;
    }


    @Override
    public String toString() {
        return formula;
    }
}

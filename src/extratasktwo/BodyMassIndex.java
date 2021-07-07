package extratasktwo;

public class BodyMassIndex {

    public static String bodyMassIndexCalculation(int mass, double height) {
        double bmi = mass / Math.pow(height, 2.0);

        return bmi < 18.5 ? BodyTypes.UNDERWEIGHT.name() :
                (bmi >= 18.5 && bmi < 25.0) ? BodyTypes.NORMAL_WEIGHT.name() :
                        (bmi >= 25.0 && bmi < 30.0) ? BodyTypes.OVER_WEIGHT.name() :
                                BodyTypes.OBESITY.name();
    }
}

package power;

public class PowerValues {

    private double base;

    private double index;

    public PowerValues(double base, double index) {
        this.base = base;
        this.index = index;
    }

    public double powerRaiseMethod(double base, double index) {
        double value = 1;
        for (int i = 0; i < index; i++) {
            value = value * base;
        }
        return value;
    }

//public double powerRaiseMethod(double base, double index) {
//    if (index == 0) {
//        return 1;
//    } else {
//        return base * powerRaiseMethod(base, index -1);
//    }
//}

}

package Test.Misc;

public class Car {
    private int RPM;
    private int horsepower;
    private int weight;
    private String engine;

    public Car(int RPM, int horsepower, int weight, String engine) {
        this.RPM = RPM;
        this.horsepower = horsepower;
        this.weight = weight;
        this.engine = engine;
    }

    // Getters
    public int getRPM() {
        return RPM;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getWeight() {
        return weight;
    }

    public String getEngine() {
        return engine;
    }

    // Setters
    public void setRPM(int RPM) {
        this.RPM = RPM;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public static void main(String[] args) {
        Car SVJ = new Car(8500, 770, 3362, "6.5L V12");
        System.out.println("This car has a max RPM of " + SVJ.getRPM() + ", has " + SVJ.getHorsepower() +
                " horsepower, weighs " + SVJ.getWeight() + " pounds and has a " + SVJ.getEngine());
    }
}
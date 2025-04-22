import VehicleType.VehicleType;

public abstract class Vehicle {
    private String name;
    private int distance;
    protected VehicleType vehicleType;
    public Vehicle(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name+", typ: "+vehicleType+", ile: "+distance+" km, cena: ";
    }
}

package ge.playapp.brine.patterns.factory.method;

public class Truck  implements AbstractTransport{

    @Override
    public void deliver() {
        System.out.println("Delivers By Truck");
    }
}

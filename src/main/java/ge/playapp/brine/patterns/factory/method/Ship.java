package ge.playapp.brine.patterns.factory.method;

public class Ship implements  AbstractTransport{

    @Override
    public void deliver() {
        System.out.println("Delivers by Ship");
    }
}

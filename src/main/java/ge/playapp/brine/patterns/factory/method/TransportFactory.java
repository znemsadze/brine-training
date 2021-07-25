package ge.playapp.brine.patterns.factory.method;

public class TransportFactory {

    public AbstractTransport getTransport(String transportType){
            if("truck".equals(transportType)){
                return new Truck();
            }else if("ship".equals(transportType)){
                return new Ship();
            }else {
                return null;
            }
    }

}

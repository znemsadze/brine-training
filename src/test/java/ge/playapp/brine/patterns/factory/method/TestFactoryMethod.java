package ge.playapp.brine.patterns.factory.method;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFactoryMethod {


    @Test
    public void Test(){
        TransportFactory transportFactory=new TransportFactory();
        List<AbstractTransport> transports=new ArrayList<>();
        AbstractTransport transport= transportFactory.getTransport("truck");
        transports.add(transport);
        AbstractTransport transport1=transportFactory.getTransport("ship");
        transports.add(transport1);
        transports.forEach(AbstractTransport::deliver);
    }

}

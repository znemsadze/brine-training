package ge.playapp.brine.patterns.factory.abst;

import ge.playapp.brine.patterns.factory.abst.chairs.ChairAbstract;
import ge.playapp.brine.patterns.factory.abst.sofas.SofaAbstract;
import ge.playapp.brine.patterns.factory.abst.tables.TableAbstract;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {



    @Test
    public void testApp(){
        FurnitureFactory furnitureFactory=new ModernFurnitureFactory();
        aboutFurniture(furnitureFactory);
        furnitureFactory=new VintageFurnitureFactory();
        aboutFurniture(furnitureFactory);
    }

    public void aboutFurniture( FurnitureFactory furnitureFactory){
        SofaAbstract sofaAbstract;
        TableAbstract tableAbstract;
        ChairAbstract chairAbstract;
        sofaAbstract=furnitureFactory.createSofa();
        tableAbstract=furnitureFactory.createTable();
        chairAbstract=furnitureFactory.createChair();
        sofaAbstract.haveSexOnIt();
        tableAbstract.eatOnIt();
        chairAbstract.sitOnIt();
    }

}

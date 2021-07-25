package ge.playapp.brine.patterns.factory.abst;

import ge.playapp.brine.patterns.factory.abst.chairs.ChairAbstract;
import ge.playapp.brine.patterns.factory.abst.chairs.VintageChair;
import ge.playapp.brine.patterns.factory.abst.sofas.SofaAbstract;
import ge.playapp.brine.patterns.factory.abst.sofas.VintageSofa;
import ge.playapp.brine.patterns.factory.abst.tables.TableAbstract;
import ge.playapp.brine.patterns.factory.abst.tables.VintageTable;

public class VintageFurnitureFactory implements FurnitureFactory{

    @Override
    public ChairAbstract createChair() {
        return new VintageChair();
    }

    @Override
    public TableAbstract createTable() {
        return new VintageTable();
    }

    @Override
    public SofaAbstract createSofa() {
        return new VintageSofa();
    }
}

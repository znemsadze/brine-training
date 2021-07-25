package ge.playapp.brine.patterns.factory.abst;

import ge.playapp.brine.patterns.factory.abst.chairs.ChairAbstract;
import ge.playapp.brine.patterns.factory.abst.chairs.ModernChair;
import ge.playapp.brine.patterns.factory.abst.sofas.ModernSofa;
import ge.playapp.brine.patterns.factory.abst.sofas.SofaAbstract;
import ge.playapp.brine.patterns.factory.abst.tables.ModerTable;
import ge.playapp.brine.patterns.factory.abst.tables.TableAbstract;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public ChairAbstract createChair() {
        return new ModernChair();
    }

    @Override
    public TableAbstract createTable() {
        return new ModerTable();
    }

    @Override
    public SofaAbstract createSofa() {
        return new ModernSofa();
    }
}

package ge.playapp.brine.patterns.factory.abst;

import ge.playapp.brine.patterns.factory.abst.chairs.ChairAbstract;
import ge.playapp.brine.patterns.factory.abst.sofas.SofaAbstract;
import ge.playapp.brine.patterns.factory.abst.tables.TableAbstract;

public interface FurnitureFactory {

    ChairAbstract createChair();

    TableAbstract createTable();

    SofaAbstract createSofa();

}

package net.majid.creational.abstractfactory;

import net.majid.creational.abstractfactory.product.Computer;

/**
 * @author majid.shoorabi
 * @created 2022-30-July
 * @project IntelliJ IDEA
 */

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}

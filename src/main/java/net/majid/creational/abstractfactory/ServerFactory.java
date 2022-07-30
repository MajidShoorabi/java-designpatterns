package net.majid.creational.abstractfactory;

import net.majid.creational.abstractfactory.product.Computer;
import net.majid.creational.abstractfactory.product.Server;

/**
 * @author majid.shoorabi
 * @created 2022-30-July
 * @project IntelliJ IDEA
 */

public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }
}
package net.majid.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majid.shoorabi
 * @created 2022-30-July
 * @project IntelliJ IDEA
 */

public class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public Employees(List<String> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.getEmpList()){
            temp.add(s);
        }
        return new Employees(temp);
    }

}
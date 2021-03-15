package com.pouzikov.myPackage.Lists.Vectors;

import java.util.List;
import java.util.Vector;

public class MainVector {

    public static void main(String[] args) {
//4:00 all we have to do is just change the ArrayList to Vector because we are using "List". Which is why its always better
//to use that in the declaration. 4:50 we go and see inside the vector code to see that it's using a backed array. youll
//see the diference which is that it's synchronized
//If you don't need thread safety dont use Vector
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

    }
}

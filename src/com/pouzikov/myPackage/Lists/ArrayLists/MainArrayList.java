package com.pouzikov.myPackage.Lists.ArrayLists;
// Video: Array Lists
import com.pouzikov.myPackage.Lists.ArrayLists.Employee;

import java.util.ArrayList;
import java.util.List;
//START 3:19 We are going to be adding the employee class. (Go to Employee)
public class MainArrayList {

    public static void main(String[] args) {
//5:19 We want a list, so lets go ahead and do that. Now the reason I'm saying list rather than array list is by using list,
//if I decide later that I want to use a different type of list, it's easy to change the specific implementation of list
//that I'm using. We arent specifiying capacity because we are only adding four employees and 10 is default. 6:38 Okay,
//so getting back to why I use list here, if I decided I wanted to use a different type of list, I could just replace the
//specific class that I'm using when I create the instance nd this will still work. Because as long as the class that I'm
//using implements the list interface, the compilers happy.
        List<Employee> employeeList = new ArrayList<>();
//7:00 we are going to be adding the new employees now. 8:03 So as I said, what's happening under the covers when we call
//the array list constructor is creating a backing array of 10. 'Cause we saw that the default capacity, if we don't specify
//one, is 10. So we only have four employees so that's okay. It means that when we added our employees, the backing array
//didn't have to be resized.
// 8:27 looking at the add method. 9:31 Why are we using array list? Well, because array list has a bunch of methods that
//let you work with the list items. And so the code to do this has been written for you. You don't have to directly work
//on the array. Also, array list implements the list interface and so as I mentioned earlier, you can swap to another type
//of list that uses the list interface without too much disruption of the existing code.
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));
//10:02 we can print the list. This is a lambda expression.
//        employeeList.forEach(employee -> System.out.println(employee));
//11:11 zero based ability to get stuff, remember this is done in constant time.
//        System.out.println(employeeList.get(1));
//12:00 check if a list is empty.
//        System.out.println(employeeList.isEmpty());
//12:29 we can also replace an employee with another user:
        employeeList.set(1, new Employee("John", "Adams", 4568));
        //employeeList.forEach(employee -> System.out.println(employee));
//Get size of list, not capacity:
        //System.out.println(employeeList.size());
//14:50 if we want to add an employee. Now you've provided an index but because in this case you're sticking him in the
//middle of values, some values are gonna have to be shifted up. So the worst case for this would actually be O(n) because
//the worst case would be you'd want to put him right at the beginning of the array and then all the other elements have
//to be shifted.
        employeeList.add(3, new Employee("John", "Doe", 4567));
        //employeeList.forEach(employee -> System.out.println(employee));
//15:59 if we want the array, let's say we have a list and we're saying okay, well give us that backing array. Give us
//the array that's holding the employees, we can get that by calling the to array method. But we're not going to get an
//employee array. We'll get an object array. 16:24 if we want an employee array, we would just pass in the array of the
//type we want. So instead of just calling the to array method and not passing anything, we would change this call to
//say new employee and the length that we want. Now we have the employee array:
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }
//17:46 Now if you want to know if the list contains an instance, you can call the contains method to check whether the
//list contains an employee. So let's go ahead and do that. So that's system.out.println and we wanna check employeelist.contains
//and we have to pass the object we're looking for. Now we don't have that instance because we didn't save Mary anywhere
//so we'll have to ask for Mary again. And her ID was 22. And let's run. And you'll see that we get false. Now maybe we're
//expecting true, maybe you weren't. And the reason you get false is because we haven't implemented the equals method in
//the employee class. So because there's no equals method, what this method is doing is actually checking to see if they're
//the exact same instance because that's what the default equals method does. (Go to Employee to "equals" method)
//19:50 If we run the code, after adding the equals method, we see that the method returns true.
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));
//20:14 Now that we have the equals method, we can make use of the index of method. And this will look up an employee in
//the list and tell us what index that employee is occupying.
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));
//21:32 how to remove. Now because we're dealing with an array in the background, remove can be expensive because elements
//after the one we removed hav to be shifted down one position. So if we take a look at that, if we go to the source code
//and I want the source code for array list, we'll see here that this is an array copy and that's what's doing the shifting.
//If it has shift elements down to occupy the empty space left by the one that we removed. Okay, so there are a few more
//methods in the array list class but I'm going to leave you to explore them on your own.
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 10 pro 64bit
 */
class EmployeeManagement {

    Scanner sc = new Scanner(System.in);
    GetInput getInput = new GetInput();
    Display display = new Display();

    void addEmployee(ArrayList<Employee> employeeList) {
        display.displayFullList(employeeList);
        System.out.println("--------- Add Employee ---------");
        int id;
        do {
            id = getInput.inputInteger("Enter employee's ID: ", 0, Integer.MAX_VALUE);
            // Check user's entered ID duplicate Employee's ID in the list 
            if (checkDuplicateId(-1, id, employeeList)) {
                System.out.println("This ID already exists. Please try again!");
                continue;
            } else {
                break;
            }
        } while (true);
        // ^: match the beginning of the string
        // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
        // *: stand behind string that occur zero or more times
        // $: match the end of the string
        String firstName = getInput.inputString("Enter employee's first name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
        // ^: match the beginning of the string
        // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
        // *: stand behind string that occur zero or more times
        // $: match the end of the string
        String lastName = getInput.inputString("Enter employee's last name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
        // ^0: phone number must begin with 0
        // [35789]: the 2nd digit of phone number must be one of [35789]
        // \d{8}: phone number must have 8 more digits
        // $: match the end of the string
        String phone = getInput.inputString("Enter employee's phone number: ", "^0[35789]\\d{8}$");
        // ^: match the beginning of the string
        // [a-zA-Z0-9]: match one of letters from 'a' to 'z' (lower or upper case) and digits from 0 to 9
        // +: stand behind string that occur one or more times
        // \.: match character '.'
        // [\\._]: match character '.' or '_'
        // *: stand behind string that occur zero or more times
        // @: match character '@'
        // [a-zA-Z]: match one of letters from 'a' to 'z' (lower or upper case)
        // {1,2}: stand behind string that occur one or two times
        // $: match the end of the string
        String email = getInput.inputString("Enter employee's email: ",
                "^[a-zA-Z0-9]+([\\._][a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+){1,2}$");
        String address = getInput.inputString("Enter employee's address: ", "");
        Date DOB;
        do {
            DOB = getInput.inputDate("Enter employee's date of birth [dd/MM/yyyy]: ");
            Date today = new Date();
            // Check birthday must before today
            if (DOB.before(today)) {
                break;
            } else {
                System.out.println("Date of birth must before today. Please try again!");
                continue;
            }
        } while (true);
        // ^: match the beginning of the string
        // Male|Female: match string 'Male' or 'Female'
        // $: match the end of the string
        String sex = getInput.inputString("Enter employee's sex [Male/Female]: ", "^(Male|Female)$");
        int salary = getInput.inputInteger("Enter employee's salary: ", 0, Integer.MAX_VALUE);
        String agency = getInput.inputString("Enter employee's agency: ", "");
        Employee employee = new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, agency);
        employeeList.add(employee);
        System.out.println("List added successfully!");
        display.displayFullList(employeeList);
    }

    void updateEmployee(ArrayList< Employee> employeeList) {
        // Check empty list
        if (employeeList.isEmpty()) {
            System.out.println("Current list is empty!");
            return;
        } else {
            display.displayFullList(employeeList);
        }
        System.out.println("--------- Update Employee ---------");
        int id;
        Employee searchedEmployee;
        int choice;
        do {
            id = getInput.inputInteger("Enter employee's ID: ", 0, Integer.MAX_VALUE);
            searchedEmployee = searchByID(id, employeeList);
            if (searchedEmployee == null) {
                System.out.println("ID does not exist. Please try again!");
                continue;
            } else {
                break;
            }
        } while (true);
        do {
            display.displayUpdateMenu();
            choice = getInput.inputInteger("Please select an option: ", 1, 11);
            switch (choice) {
                case 1:
                    int newId;
                    do {
                        newId = getInput.inputInteger("Enter employee's ID: ", 0, Integer.MAX_VALUE);
                        // Check user's entered ID duplicate Employee's ID in the list 
                        if (checkDuplicateId(id, newId, employeeList)) {
                            System.out.println("This ID already exists. Please try again!");
                            continue;
                        } else {
                            break;
                        }
                    } while (true);
                    searchedEmployee.setId(newId);
                    break;
                case 2:
                    // ^: match the beginning of the string
                    // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
                    // *: stand behind string that occur zero or more times
                    // $: match the end of the string
                    String firstName = getInput.inputString("Enter employee's first name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
                    searchedEmployee.setFirstName(firstName);
                    break;
                case 3:
                    // ^: match the beginning of the string
                    // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
                    // *: stand behind string that occur zero or more times
                    // $: match the end of the string
                    String lastName = getInput.inputString("Enter employee's last name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
                    searchedEmployee.setFirstName(lastName);
                    break;
                case 4:
                    // ^0: phone number must begin with 0
                    // [35789]: the 2nd digit of phone number must be one of [35789]
                    // \d{8}: phone number must have 8 more digits
                    // $: match the end of the string
                    String phone = getInput.inputString("Enter employee's phone number: ", "^0[35789]\\d{8}$");
                    searchedEmployee.setPhone(phone);
                    break;
                case 5:
                    // ^: match the beginning of the string
                    // [a-zA-Z0-9]: match one of letters from 'a' to 'z' (lower or upper case) and digits from 0 to 9
                    // +: stand behind string that occur one or more times
                    // \.: match character '.'
                    // [\\._]: match character '.' or '_'
                    // *: stand behind string that occur zero or more times
                    // @: match character '@'
                    // [a-zA-Z]: match one of letters from 'a' to 'z' (lower or upper case)
                    // {1,2}: stand behind string that occur one or two times
                    // $: match the end of the string
                    String email = getInput.inputString("Enter employee's email: ",
                            "^[a-zA-Z0-9]+([\\._][a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+){1,2}$");
                    searchedEmployee.setEmail(email);
                    break;
                case 6:
                    String address = getInput.inputString("Enter employee's address: ", "");
                    searchedEmployee.setAddress(address);
                    break;
                case 7:
                    Date DOB;
                    do {
                        DOB = getInput.inputDate("Enter employee's date of birth [dd/MM/yyyy]: ");
                        Date today = new Date();
                        // Check birthday must before today
                        if (DOB.before(today)) {
                            break;
                        } else {
                            System.out.println("Date of birth must before today. Please try again!");
                            continue;
                        }
                    } while (true);
                    searchedEmployee.setDOB(DOB);
                    break;
                case 8:
                    String sex = getInput.inputString("Enter employee's sex [Male/Female]: ", "^(Male|Female)$");
                    searchedEmployee.setSex(sex);
                    break;
                case 9:
                    int salary = getInput.inputInteger("Enter employee's salary: ", 0, Integer.MAX_VALUE);
                    searchedEmployee.setSalary(salary);
                    break;
                case 10:
                    String agency = getInput.inputString("Enter employee's agency: ", "");
                    searchedEmployee.setAgency(agency);
                    break;
            }
        } while (choice < 11);
        System.out.println("List updated successfully!");
        display.displayFullList(employeeList);
    }

    void removeEmployee(ArrayList<Employee> employeeList) {
        // Check empty list
        if (employeeList.isEmpty()) {
            System.out.println("Current list is empty!");
            return;
        } else {
            display.displayFullList(employeeList);
        }
        System.out.println("--------- Remove Employee ---------");
        int id;
        Employee searchedEmployee = null;
        do {
            id = getInput.inputInteger("Enter employee's ID: ", 0, Integer.MAX_VALUE);
            searchedEmployee = searchByID(id, employeeList);
            if (searchedEmployee == null) {
                System.out.println("ID does not exist. Please try again!");
                continue;
            } else {
                break;
            }
        } while (true);
        employeeList.remove(searchedEmployee);
        System.out.println("Employee removed successfully!");
        display.displayFullList(employeeList);
    }

    void searchByName(ArrayList<Employee> employeeList) {
        // Check empty list
        if (employeeList.isEmpty()) {
            System.out.println("Current list is empty!");
            return;
        } else {
            display.displayFullList(employeeList);
        }
        System.out.println("--------- Search Employee ---------");
        String fullname = "";
        ArrayList<Employee> resultList = new ArrayList<>();
        String nameSearch = getInput.inputString("Enter employee's name you want to find: ", "");
        // Loop to access from the first to the last employee of list
        for (Employee employee : employeeList) {
            fullname = employee.getLastName() + " " + employee.getFirstName();
            // Check lowercase fullname of employee contains lowercase name inputted by user
            if (fullname.toLowerCase().contains(nameSearch.toLowerCase())) {
                resultList.add(employee);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("Employee does not exist!");
        } else {
            System.out.println("Search result:");
            display.displayFullList(resultList);
        }
    }

    void sortEmployeeBySalary(ArrayList<Employee> employeeList) {
        // Check empty list
        if (employeeList.isEmpty()) {
            System.out.println("Current list is empty!");
            return;
        } else {
            System.out.println("--------- Sort Employee By Salary ---------");
            display.displayFullList(employeeList);
        }
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // Compare salary of two employees in the list
                if (e1.getSalary() == e2.getSalary()) {
                    return e1.getId() - e2.getId();
                } else {
                    return e1.getSalary() - e2.getSalary();
                }
            }
        });
        System.out.println("List sorted successfully!");
        display.displayFullList(employeeList);
    }

    private boolean checkDuplicateId(int oldId, int newId, ArrayList<Employee> employeeList) {
        // Compare old employee ID with new employee ID
        if (newId == oldId) {
            return false;
        }
        // Loop to access from the first to the last employee of the list
        for (Employee employee : employeeList) {
            // Compare new id entered with employee's id in list
            if (employee.getId() == newId) {
                return true;
            }
        }
        return false;
    }

    private Employee searchByID(int newId, ArrayList<Employee> employeeList) {
        Employee searchedEmployee = null;
        if (employeeList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            // loop to access from the first to the last employee of the list
            for (Employee employee : employeeList) {
                // Compare inputted id with employee's id in list
                if (employee.getId() == newId) {
                    searchedEmployee = employee;
                    break;
                }
            }
        }
        return searchedEmployee;
    }

}

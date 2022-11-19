/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author 10 pro 64bit
 */
class Display {

    public Display() {
    }

    void displayMainMenu() {
        System.out.println("\n======== EMPLOYEE MANAGEMENT SYSTEM ========");
        System.out.println("Main menu:");
        System.out.println("\t1.  Add employees");
        System.out.println("\t2.  Update employees");
        System.out.println("\t3.  Remove employees");
        System.out.println("\t4.  Search employees");
        System.out.println("\t5.  Sort employees by salary");
        System.out.println("\t6.  Exit");
    }

    void displayUpdateMenu() {
        System.out.println("\nUpdate option:");
        System.out.println("\t1.  Update employee's ID");
        System.out.println("\t2.  Update employee's first name");
        System.out.println("\t3.  Update employee's last name");
        System.out.println("\t4.  Update employee's phone number");
        System.out.println("\t5.  Update employee's email");
        System.out.println("\t6.  Update employee's address");
        System.out.println("\t7.  Update employee's date of birth");
        System.out.println("\t8.  Update employee's sex");
        System.out.println("\t9.  Update employee's salay");
        System.out.println("\t10. Update employee's agency");
        System.out.println("\t11. Finish update");
    }

    void displayFieldOfList() {
        System.out.printf("\n| %-3s| %-11s|  %-11s| %-13s|%12s%-18s|%4s%-11s|%5s%-7s|%2s%-5s|%3s%-9s|%5s%-11s|\n",
                "ID", "First Name", "Last Name", "Phone Number", "", "Email", "", "Address", "", "DOB", "", "Sex", "", "Salary", "", "Agency");
        // loop to print a character n times, to draw line
        for (int i = 0; i < 146; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }

    void displayEmployee(Employee employee) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String DOB = dateFormat.format(employee.getDOB());
        System.out.printf("  %-5d%-13s%-15s%-14s%-31s%-16s%-13s%-8s%-13d%-16s\n",
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getPhone(),
                employee.getEmail(), employee.getAddress(), dateFormat.format(employee.getDOB()),
                employee.getSex(), employee.getSalary(), employee.getAgency());
    }

    void displayFullList(ArrayList<Employee> employeeList) {
        // Check empty list
        if (employeeList.isEmpty()) {
            System.out.println("Current list is empty!");
        } else {
            System.out.println("List of Employees: ");
            displayFieldOfList();
            // Loop to access from the first to the last employee of list
            for (Employee employee : employeeList) {
                displayEmployee(employee);
            }
        }
        System.out.println("");
    }

}

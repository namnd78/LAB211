/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * R33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Display display = new Display();
        GetInput getInput = new GetInput();
        ArrayList<Employee> employeeList = new ArrayList<>();
        EmployeeManagement employeeManagement = new EmployeeManagement();
//        // test
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        employeeList.add(new Employee(16, "Long", "Nguyen Van", "0312645678", "asddnasjdn@fpt.edu.vn", "Ho Chi Minh", dateFormat.parse("1/1/1991"), "Male", 45000000, "Ha Noi"));
//        employeeList.add(new Employee(75, "An", "Vu Van", "0912345678", "ddasdjasjd@gmail.com", "Da Nang", dateFormat.parse("9/11/1997"), "Female", 45000000, "Ha Noi"));
//        employeeList.add(new Employee(22, "Thinh", "Vu Tien", "0898765432", "asddasdwag@yahoo.com.vn", "Phu Tho", dateFormat.parse("5/5/2000"), "Male", 9500000, "Long An"));
//        employeeList.add(new Employee(36, "Thanh", "Tran Van", "0578932167", "ssjfissdasj@gmail.com", "Ninh Binh", dateFormat.parse("21/2/1999"), "Male", 100000000, "Hai Phong"));
        do {
            //1. Display a menu
            display.displayMainMenu();
            //2. Require user to select an option
            int choice = getInput.inputInteger("Please select an option: ", 1, 6);
            //3. Perform user selection
            switch (choice) {
                // Add employees
                case 1:
                    employeeManagement.addEmployee(employeeList);
                    break;
                // Update employees
                case 2:
                    employeeManagement.updateEmployee(employeeList);
                    break;
                // Remove employees
                case 3:
                    employeeManagement.removeEmployee(employeeList);
                    break;
                // Search employees
                case 4:
                    employeeManagement.searchByName(employeeList);
                    break;
                // Sort employees by salary
                case 5:
                    employeeManagement.sortEmployeeBySalary(employeeList);
                    break;
                // Exit
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}

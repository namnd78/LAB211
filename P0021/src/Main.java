
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * E33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        GetInput getInput = new GetInput();
        ArrayList<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Nam", 1, "Java"));
//        studentList.add(new Student(2, "Hoang", 1, "C/C++"));
//        studentList.add(new Student(3, "Luc", 2, "C/C++"));
//        studentList.add(new Student(1, "Nam", 1, ".Net"));
//        studentList.add(new Student(2, "Hoang", 3, "C/C++"));
//        studentList.add(new Student(3, "Luc", 4, ".Net"));
//        studentList.add(new Student(1, "Nam", 2, ".Net"));
//        studentList.add(new Student(2, "Hoang", 3, "Java"));
        do {
            // 1. Display program's main menu
            studentManagement.displayMainMenu();
            // 2. Require user to choose an option
            int choice = getInput.inputInteger("Enter your choice: ", 1, 5);
            // 3. Perform user selection
            switch (choice) {
                // Create student
                case 1:
                    studentManagement.createStudent(studentList);
                    break;
                // Find and sort student
                case 2:
                    studentManagement.findAndSort(studentList);
                    break;
                // Update/Delete student
                case 3:
                    studentManagement.updateOrDelete(studentList);
                    break;
                // Report
                case 4:
                    studentManagement.report(studentList);
                    break;
                // Exit
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}

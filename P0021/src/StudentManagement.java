
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
class StudentManagement {

    GetInput getInput = new GetInput();

    void displayMainMenu() {
        System.out.println("\n========== WELCOME TO STUDENT MANAGEMENT ==========");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("\n(Please choose 1 to Create, 2 to Find and Sort,"
                + " 3 to Update/Delete, 4 to Report and 5 to Exit program)");
    }

    void createStudent(ArrayList<Student> studentList) {
        // Loop to create at least 10 students
        do {
            // Check if there are at least 10 students in the list
            if (studentList.size() >= 10) {
                // [yYnN]: match one of characters y,Y,n,N
                String confirm = getInput.inputString("Do you want to continue (Y/N)?: ", "[yYnN]");
                if (confirm.equalsIgnoreCase("n")) {
                    break;
                }
            }
            System.out.println("\n--------- Create Student ---------");
            int id = getInput.inputInteger("Enter student's id: ", 1, Integer.MAX_VALUE);
            String studentName;
            String searchedName = searchNameById(id, studentList);
            // Check exist student's name with entered id
            if (!searchedName.isEmpty()) {
                studentName = searchedName;
                System.out.println("Id already exists. Student's name: " + studentName);
            } else {
                // ^: match the beginning of the string
                // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
                // *: stand behind string that occur zero or more times
                // $: match the end of the string
                studentName = getInput.inputString("Enter student's name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
            }
            //
            int semester = getInput.inputInteger("Enter student's semester: ", 1, Integer.MAX_VALUE);
            String course = getInput.inputCourse();
            // Check new student information duplicate with students in the list
            if (checkDuplicateInformation(id, semester, course, null, studentList)) {
                System.out.println("Create failed! Duplicate student information!");
            } else {
                studentList.add(new Student(id, studentName, semester, course));
                System.out.println("Student created successfully!");
            }
        } while (true);
    }

    private String searchNameById(int id, ArrayList<Student> studentList) {
        String searchedName = "";
        // Loop to access from the first to the last element in the list
        for (Student student : studentList) {
            // Compare entered id with id of student in list
            if (id == student.getStudentID()) {
                searchedName = student.getStudentName();
                break;
            }
        }
        return searchedName;
    }

    private boolean checkDuplicateInformation(int id, int semester, String course, Student studentToUpdate, ArrayList<Student> studentList) {
        if (studentToUpdate != null) {
            // Compare information with variable studentToUpdate (if exist)
            if (studentToUpdate.getStudentID() == id && studentToUpdate.getSemester() == semester
                    && studentToUpdate.getCourse().equals(course)) {
                return false;
            }
        }
        // Loop to access from the first to the last element in the list
        for (Student studentInList : studentList) {
            // Compare entered id, student name, course with elements in list
            if (studentInList.getStudentID() == id
                    && studentInList.getSemester() == semester
                    && studentInList.getCourse().equals(course)) {
                return true;
            }
        }
        return false;
    }

    void findAndSort(ArrayList<Student> studentList) {
        // Check empty list
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        System.out.println("\n--------- Find & Sort ---------");
        String name = getInput.inputString("Enter student's name: ", "");
        ArrayList<Student> listByStudentName = searchStudentByName(name, studentList);
        // Check empty list searched by name
        if (listByStudentName.isEmpty()) {
            System.out.println("No student found!");
        } else {
            sortStudentByName(listByStudentName);
            System.out.printf("\n|%8s%-12s| %-9s| %-7s|\n", "", "Name", "Semester", "Course");
            // Loop to access from the first to the last element in searched list
            for (Student student : listByStudentName) {
                System.out.printf("%2s%-19s|%4s%-6d|%2s%-6s\n",
                        "", student.getStudentName(), "", student.getSemester(), "", student.getCourse());
            }
        }
    }

    private ArrayList<Student> searchStudentByName(String name, ArrayList<Student> studentList) {
        ArrayList<Student> listByStudentName = new ArrayList<>();
        // Loop to access from the first to the last element in the list
        for (Student student : studentList) {
            // Check lowercase user's entered name contains lowercase student's name in the list
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listByStudentName.add(student);
            }
        }
        return listByStudentName;
    }

    private void sortStudentByName(ArrayList<Student> listByStudentName) {
        Collections.sort(listByStudentName, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                return t1.getStudentName().compareTo(t2.getStudentName());
            }
        });
    }

    void updateOrDelete(ArrayList<Student> studentList) {
        // Check empty list
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        System.out.println("\n--------- Update/Delete ---------");
        int id = getInput.inputInteger("Enter student's id: ", 1, Integer.MAX_VALUE);
        ArrayList<Student> listByStudentId = searchStudentById(id, studentList);
        // Check empty list searched by id
        if (listByStudentId.isEmpty()) {
            System.out.println("No student found!");
            return;
        }
        Student student = getStudentInList(listByStudentId);
        // [uUdD]: match one of characters u,U,d,D
        String choice = getInput.inputString("Do you want to update (U) or delete (D) student?: ", "[uUdD]");
        if (choice.equalsIgnoreCase("u")) {
            int newId = getInput.inputInteger("Enter student's id: ", 1, Integer.MAX_VALUE);
            // ^: match the beginning of the string
            // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
            // *: stand behind string that occur zero or more times
            // $: match the end of the string
            String newName = getInput.inputString("Enter student's name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
            int newSemester = getInput.inputInteger("Enter student's semester: ", 1, Integer.MAX_VALUE);
            String newCourse = getInput.inputCourse();
            // Check entered student information duplicate with students in the list
            if (checkDuplicateInformation(newId, newSemester, newCourse, student, studentList)) {
                System.out.println("Update failed! Duplicate student information!");
            } else {
                student.setStudentID(newId);
                student.setStudentName(newName);
                student.setSemester(newSemester);
                student.setCourse(newCourse);
                // Loop to access from the first to the last element in the list
                for (Student studentInList : studentList) {
                    // Compare new id with student's id in the list, to update name of all students having same id with newId
                    if (studentInList.getStudentID() == newId) {
                        studentInList.setStudentName(newName);
                    }
                }
                System.out.println("Student updated successfully!");
            }
        } else {
            studentList.remove(student);
            System.out.println("Student deleted successfully!");
        }
    }

    private ArrayList<Student> searchStudentById(int id, ArrayList<Student> studentList) {
        ArrayList<Student> listByStudentId = new ArrayList<>();
        // Loop to access from the first to the last element in the list
        for (Student student : studentList) {
            // Compare user's entered id with student's id in the list
            if (student.getStudentID() == id) {
                listByStudentId.add(student);
            }
        }
        return listByStudentId;
    }

    private Student getStudentInList(ArrayList<Student> listByStudentId) {
        System.out.printf("\n| %-3s|%8s%-12s| %-9s| %-7s|\n", "No", "", "Name", "Semester", "Course");
        // Loop to access from the first to the last element in the list
        for (int i = 0; i < listByStudentId.size(); i++) {
            Student student = listByStudentId.get(i);
            System.out.printf("%2s%-3d| %-19s|%4s%-6d|%2s%-6s\n", "", (i + 1),
                    student.getStudentName(), "", student.getSemester(), "", student.getCourse());
        }
        int choice = getInput.inputInteger("\nEnter student No.: ", 1, listByStudentId.size());
        return listByStudentId.get(choice - 1);
    }

    void report(ArrayList<Student> studentList) {
        // Check empty list
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        ArrayList<Report> reportList = new ArrayList<>();
        // Loop to access from the first to the last student in the list
        for (Student student : studentList) {
            int totalCourse = 0;
            int id = student.getStudentID();
            String name = student.getStudentName();
            String course = student.getCourse();
            /* Loop to access from the first to the last student in the list, to check
            student have same id and course as above*/
            for (Student studentForCount : studentList) {
                if (student.getStudentID() == studentForCount.getStudentID()
                        && student.getCourse().equals(studentForCount.getCourse())) {
                    totalCourse++;
                }
            }
            // Check id, course duplicate with reports in the list
            if (!checkDuplicateReport(id, course, reportList)) {
                reportList.add(new Report(id, name, course, totalCourse));
            }
        }
        displayReport(reportList);
    }

    private boolean checkDuplicateReport(int id, String course, ArrayList<Report> reportList) {
        // Loop to access from the first to the last element in the list
        for (Report report : reportList) {
            // Compare entered id, course with id and course of report the list
            if (report.getStudentId() == id && report.getCourse().equals(course)) {
                return true;
            }
        }
        return false;
    }

    private void displayReport(ArrayList<Report> reportList) {
        System.out.println("\n--------------- Report ----------------");
        System.out.printf("|%8s%-12s| %-7s| %-6s|\n", "", "Name", "Course", "Total");
        // Loop to access from the first to the last element in the list, to display report
        for (Report report : reportList) {
            System.out.printf("%2s%-19s|%2s%-6s|%3s%-4d\n",
                    "", report.getStudentName(), "", report.getCourse(), "", report.getTotalCourse());
        }
    }
}

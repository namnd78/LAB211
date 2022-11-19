/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10 pro 64bit
 */
public class Report {

    private int studentId;
    private String studentName;
    private String course;
    private int totalCourse;

    public Report() {
    }

    public Report(int studentId, String studentName, String course, int totalCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

}

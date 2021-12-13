package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * vn.edu.hcmus.student.sv19127640.StudentListgui
 * Created by ADMIN
 * Date 12/3/2021 - 9:09 PM
 * Description: student list class
 */
public class StudentList {
    // attribute
    private List<Student> studentList;
    /**
     * default constructor
     */
    public StudentList(){
        this.studentList = new ArrayList<Student>();
    }
    /**
     * copy constructor
     * @param object StudentList
     */
    public StudentList(StudentList object){
        this.studentList = new ArrayList<Student>();
        for (int i = 0; i < object.studentList.size(); i++){
            studentList.add(object.studentList.get(i));
        }
    }
    /**
     * get student list length
     * @return int
     */
    public int getStudentListLength() {
        return studentList.size();
    }
    /**
     * function to find an index of student in student list
     * @param studentID String
     * @return Integer
     */
    public Integer findStudentIndex(String studentID){
        Integer index = null;
        for (int i = 0; i < this.studentList.size(); i++){
            if (this.studentList.get(i).getStudentID().equals(studentID)){
                index = i;
                return index; // found
            }
        }
        return index; // not found
    }
    /**
     * add new student to list
     * @param student Student
     * @return Integer
     */
    public Integer addStudents(Student student){
        // check if this studentID is exists or not
        if (this.findStudentIndex(student.getStudentID()) == null){
            if (student.isValidStudent()){
                this.studentList.add(student);
                return 2; // every thing ok
            }
            return 1; // studentID is unique but other information is invalid
        }
        return 0; // this student is already exists
    }
    /**
     * function to output a student list
     */
    public void output(){
        for (int i = 0; i < this.studentList.size(); i++){
            System.out.printf((i + 1) + "/ ");
            studentList.get(i).output();
        }
    }
    /**
     * function to find a student by ID in student list
     * @param studentID String
     * @return Student
     */
    public Student findAStudent(String studentID){
        Integer index = this.findStudentIndex(studentID);
        if (index != null){
            Student result = new Student();
            result = this.studentList.get(index);
            return result;
        }
        return null;
    }
    /**
     * update student info
     * @param student Student
     * @return boolean
     */
    public boolean updateStudent(Student student) {
        // get the index of this student in list
        Integer index = this.findStudentIndex(student.getStudentID());
        if (index != null){
            // get old student information
            Student oldStudentInfo = this.findAStudent(student.getStudentID());
            if (student.getStudentName().length() == 0)
                student.setStudentName(oldStudentInfo.getStudentName());
            if (student.getStudentGPA().toString().length() == 0)
                student.setStudentGPA(oldStudentInfo.getStudentGPA());
            if (student.getStudentImage().length() == 0)
                student.setStudentImage(oldStudentInfo.getStudentImage());
            if (student.getStudentAddress().length() == 0)
                student.setStudentAddress(oldStudentInfo.getStudentAddress());
            if (student.getStudentNotes().length() == 0)
                student.setStudentNotes(oldStudentInfo.getStudentNotes());
            this.studentList.get(index).setStudentName(student.getStudentName());
            this.studentList.get(index).setStudentGPA(student.getStudentGPA());
            this.studentList.get(index).setStudentImage(student.getStudentImage());
            this.studentList.get(index).setStudentAddress(student.getStudentAddress());
            this.studentList.get(index).setStudentNotes(student.getStudentNotes());
            return true;
        }
        return false;
    }
    /**
     * delete one student by ID
     * @param studentID String
     * @return boolean
     */
    public boolean deleteStudent(String studentID) {
        Integer index = this.findStudentIndex(studentID);
        if (index != null){
            Student studentToRemove = this.findAStudent(studentID);
            this.studentList.remove(studentToRemove);
            return true;
        }
        return false;
    }
    /**
     * function to sort student ID in ascending order
     * @throws IOException throw exception
     */
    public void sortStudentIdAscending() {
        for (int i = 0; i < studentList.size() - 1; i++){
            for (int j = i + 1; j < studentList.size(); j++){
                Student student_1 = studentList.get(i);
                Student student_2 = studentList.get(j);
                if (Integer.parseInt(student_1.getStudentID()) > Integer.parseInt(student_2.getStudentID())){
                    Student temp = new Student(student_1);
                    studentList.set(i, student_2);
                    studentList.set(j, temp);
                }
            }
        }
    }
    /**
     * function to sort student GPA in ascending order
     * @throws IOException throw exception
     */
    public void sortStudentGPAAscending(){
        for (int i = 0; i < studentList.size() - 1; i++){
            for (int j = i + 1; j < studentList.size(); j++){
                Student student_1 = studentList.get(i);
                Student student_2 = studentList.get(j);
                if (student_1.getStudentGPA() > student_2.getStudentGPA()){
                    Student temp = new Student(student_1);
                    studentList.set(i, student_2);
                    studentList.set(j, temp);
                }
            }
        }
    }
    /**
     * function to import student list from CSV file
     * @param filename String
     * @throws IOException throw exception
     */
    public boolean importFromCSV(String filename) throws IOException {
        if (filename.toLowerCase().contains("CSV".toLowerCase())){
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                while (true) {
                    String line = reader.readLine();
                    if (line != null){
                        Student student = Student.parseToStudent(line,",");
                        if (this.findStudentIndex(student.getStudentID()) == null) {
                            // if this student ID is valid => add to list
                            this.studentList.add(student);
                        }
                    } else
                        break;
                }
                return true;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
        return false;
    }

    /**
     * function to export student list to CSV file
     * @param filename String
     * @throws IOException throw exception
     */
    public boolean exportToCSV(String filename) throws IOException {
        if (filename.toLowerCase().contains("CSV".toLowerCase())) {
            try {
                File csvFile = new File(filename);
                PrintWriter out = new PrintWriter(csvFile);

                for (int i = 0; i < this.studentList.size(); i++) {
                    String s = String.format("%s; %s; %s; %s; %s; %s", this.studentList.get(i).getStudentID(),
                            this.studentList.get(i).getStudentName(), this.studentList.get(i).getStudentGPA(),
                            this.studentList.get(i).getStudentImage(), this.studentList.get(i).getStudentAddress(),
                            this.studentList.get(i).getStudentNotes());
                    out.println(s);
                }
                out.flush();
                out.close();
                return true;
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            return false;
        }
        return false;
    }

    /**
     * function to load data from database to the list
     * @param connection Connection
     * @throws SQLException exception
     */
    public void loadFromDatabase(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        // get data from table 'student'
        ResultSet rs = stmt.executeQuery("select * from STUDENT");
        // assign data to list
        while (rs.next()) {
            Student student = new Student();
            student.setStudentID(rs.getString(1));
            student.setStudentName(rs.getString(2));
            student.setStudentGPA(rs.getFloat(3));
            student.setStudentImage(rs.getString(4));
            student.setStudentAddress(rs.getString(5));
            student.setStudentNotes(rs.getString(6));
            this.studentList.add(student);
        }
    }

    /**
     * function to save student list to database
     * @param connection Connection
     * @throws SQLException exception
     */
    public void saveToDB(Connection connection) throws SQLException {
        for (int i = 0; i < this.studentList.size(); i++){
            Student student = this.studentList.get(i);
            // get current list from database
            StudentList listFromDB = new StudentList();
            listFromDB.loadFromDatabase(connection);
            Integer index = listFromDB.findStudentIndex(student.getStudentID());
            if (index == null){ // if this student is not in database => add to database
                String SQL = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = connection.prepareStatement(SQL);
                p.setString(1, student.getStudentID());
                p.setString(2, student.getStudentName());
                p.setFloat(3, student.getStudentGPA());
                p.setString(4, student.getStudentImage());
                p.setString(5, student.getStudentAddress());
                p.setString(6, student.getStudentNotes());
                p.executeUpdate();
                p.close();
            }
            // else do nothing (don't add this student to db)
        }
    }

    /**
     * function to load student list to vector in order to create JTable
     * @return Vector<Vector<String>>
     */
    public Vector<Vector<String>> allList(){
        Vector<Vector<String>> studentsVector = new Vector<Vector<String>>();
        for (int i = 0; i < this.studentList.size(); i++){
            Vector<String> studentVector = new Vector<String>();
            Student student = this.studentList.get(i);
            studentVector.add(student.getStudentID());
            studentVector.add(student.getStudentName());
            studentVector.add(Float.toString(student.getStudentGPA()));
            studentVector.add(student.getStudentImage());
            studentVector.add(student.getStudentAddress());
            studentVector.add(student.getStudentNotes());

            studentsVector.add(studentVector);
        }
        return studentsVector;
    }
}

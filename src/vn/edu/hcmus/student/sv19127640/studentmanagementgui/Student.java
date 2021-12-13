package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 12/3/2021 - 9:10 PM
 * Description: student class
 */
public class Student {
    // attribute
    private String studentID;
    private String studentName;
    private Float studentGPA;
    private String studentImage;
    private String studentAddress;
    private String studentNotes;

    /**
     * default constructor
     */
    public Student(){
        this.studentID = null;
        this.studentName = null;
        this.studentGPA = null;
        this.studentImage = null;
        this.studentAddress = null;
        this.studentNotes = null;
    }

    /**
     * constructor with parameters
     * @param studentID String
     * @param studentName String
     * @param studentGPA Float
     * @param studentImage String
     * @param studentAddress String
     * @param studentNotes String
     */
    public Student(String studentID, String studentName, Float studentGPA, String studentImage, String studentAddress, String studentNotes) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGPA = studentGPA;
        this.studentImage = studentImage;
        this.studentAddress = studentAddress;
        this.studentNotes = studentNotes;
    }
    /**
     * copy constructor
     * @param object Student
     */
    public Student(Student object){
        this.studentID = object.studentID;
        this.studentName = object.studentName;
        this.studentGPA = object.studentGPA;
        this.studentImage = object.studentImage;
        this.studentAddress = object.studentAddress;
        this.studentNotes = object.studentNotes;
    }
    /**
     * getter student ID
     * @return String
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * getter student Name
     * @return String
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * getter student GPA
     * @return Float
     */
    public Float getStudentGPA() {
        return studentGPA;
    }

    /**
     * getter student image
     * @return String
     */
    public String getStudentImage() {
        return studentImage;
    }

    /**
     * getter student address
     * @return String
     */
    public String getStudentAddress() {
        return studentAddress;
    }

    /**
     * getter student notes
     * @return String
     */
    public String getStudentNotes() {
        return studentNotes;
    }

    /**
     * setter student ID
     * @param studentID String
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * setter student Name
     * @param studentName String
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * setter student GPA
     * @param studentGPA String
     */
    public void setStudentGPA(Float studentGPA) {
        this.studentGPA = studentGPA;
    }

    /**
     * setter Student image
     * @param studentImage String
     */
    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    /**
     * setter student address
     * @param studentAddress String
     */
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    /**
     * setter student notes
     * @param studentNotes String
     */
    public void setStudentNotes(String studentNotes) {
        this.studentNotes = studentNotes;
    }

    /**
     * function to output student's information
     */
    public void output(){
        System.out.println(this.studentID + " - " + this.studentName + " - " +this.studentGPA + " - " +
                this.studentImage + " - " +this.studentAddress + " - " +this.studentNotes);
    }

    /**
     * check if the input field is empty
     * @return true or false
     */
    public boolean isValidStudent(){
        if (this.studentID.length() == 0 || this.studentName.length() == 0
                || this.studentGPA.toString().length() == 0 || this.studentImage.length() == 0
                || this.studentAddress.length() == 0 || this.studentNotes.length() == 0)
            return false;
        return true;
    }
    /**
     * parse a String to Student object
     * @param line String
     * @param regex String
     * @return Student
     */
    public static Student parseToStudent(String line, String regex){
        String[] arrStr = line.split(regex);
        Student result = new Student();
        int index = 0;
        result.studentID = arrStr[index++];
        result.studentName = arrStr[index++];
        result.studentGPA = Float.parseFloat(arrStr[index++]);
        result.studentImage = arrStr[index++];
        result.studentAddress = arrStr[index++];
        result.studentNotes = arrStr[index++];
        return result;
    }
    /**
     * override function toString
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", studentID,
                studentName, studentGPA, studentImage, studentAddress, studentNotes);
    }
}


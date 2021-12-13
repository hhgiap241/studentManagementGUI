package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import javax.swing.*;
import java.awt.*;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 12/4/2021 - 12:45 AM
 * Description: Find student by ID panel
 */
public class FindStudentPanel {
    // attribute
    private JPanel findStudentPanel;
    private JButton findBtn;
    private JTextField findText;
    private JLabel findLable;
    private Student foundStudent;

    /**
     * default constructor
     */
    FindStudentPanel(){
        this.foundStudent = new Student();
        findStudentPanel = new JPanel();
        findStudentPanel.setLayout(new BoxLayout(findStudentPanel, BoxLayout.LINE_AXIS));
        findLable = new JLabel("Input student ID: ");
        findText = new JTextField(30);
        findBtn = new JButton("Find");
        findStudentPanel.add(findLable);
        findStudentPanel.add(findText);
        findStudentPanel.add(Box.createRigidArea(new Dimension(15,0)));
        findStudentPanel.add(findBtn);
    }

    /**
     * getter find button
     * @return JButton
     */
    public JButton getFindBtn() {
        return findBtn;
    }

    /**
     * getter the student ID what user input
     * @return JTextField
     */
    public JTextField getFindText() {
        return findText;
    }
    /**
     * getter find lable
     * @return JLable
     */
    public JLabel getFindLable() {
        return findLable;
    }

    /**
     * getter JPanel
     * @return JPanel
     */
    public JPanel getFindStudentPanel(){
        return findStudentPanel;
    }

    /**
     * set found student
     * @param foundStudent Student
     */
    public void setFoundStudent(Student foundStudent) {
        this.foundStudent = foundStudent;
    }

    /**
     * get found student
     * @return Student
     */
    public Student getFoundStudent() {
        return foundStudent;
    }
}

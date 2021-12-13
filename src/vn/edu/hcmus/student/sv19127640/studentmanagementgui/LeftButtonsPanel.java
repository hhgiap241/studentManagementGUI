package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 11/26/2021 - 9:01 PM
 * Description: Left button side panel
 */
public class LeftButtonsPanel extends JPanel{
    // attribute
    private JButton myInfo;
    private JButton addStudent;
    private JButton updateStudent;
    private JButton deleteStudent;
    private JButton viewStudentList;
    private JButton saveStudentDB;
    private JButton importFromCSV;
    private JButton exportToCSV;
    private JButton exitBtn;

    /**
     * default constructor
     */
    LeftButtonsPanel(){
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        myInfo = new JButton("My Information");
        buttonPanel.add(myInfo, gbc);

        gbc.gridy = 1;
        addStudent = new JButton("Add Student");
        buttonPanel.add(addStudent, gbc);
        gbc.gridy = 2;
        updateStudent = new JButton("Update Student Info");

        buttonPanel.add(updateStudent, gbc);
        gbc.gridy = 3;
        deleteStudent = new JButton("Delete Student");
        buttonPanel.add(deleteStudent, gbc);
        gbc.gridy = 4;
        viewStudentList = new JButton("View Student List");
        buttonPanel.add(viewStudentList, gbc);
        gbc.gridy = 5;
        saveStudentDB = new JButton("Save To Database");
        buttonPanel.add(saveStudentDB, gbc);
        gbc.gridy = 6;
        importFromCSV = new JButton("Import From CSV");
        buttonPanel.add(importFromCSV, gbc);
        gbc.gridy = 7;
        exportToCSV = new JButton("Export To CSV");
        buttonPanel.add(exportToCSV, gbc);
        gbc.gridy = 8;
        exitBtn = new JButton("Exit");
        buttonPanel.add(exitBtn, gbc);


        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(new EmptyBorder(30, 10, 10, 10));
        add(buttonPanel);
    }

    /**
     * getter Add student button
     * @return JButton
     */
    public JButton getAddStudent(){
        return this.addStudent;
    }
    /**
     * getter Update student button
     * @return JButton
     */
    public JButton getUpdateStudent(){
        return this.updateStudent;
    }
    /**
     * getter Delete student button
     * @return JButton
     */
    public JButton getDeleteStudent(){
        return this.deleteStudent;
    }
    /**
     * getter View student button
     * @return JButton
     */
    public JButton getViewStudentList(){
        return this.viewStudentList;
    }
    /**
     * getter Save student to database
     * @return JButton
     */
    public JButton getSaveStudentDB(){
        return this.saveStudentDB;
    }
    /**
     * getter Import student from CSV
     * @return JButton
     */
    public JButton getImportFromCSV(){
        return this.importFromCSV;
    }
    /**
     * getter Export student to CSV
     * @return JButton
     */
    public JButton getExportToCSV() {
        return this.exportToCSV;
    }
    /**
     * getter Exit button
     * @return JButton
     */
    public JButton getExitBtn() {
        return this.exitBtn;
    }
    /**
     * getter get My info button
     * @return JButton
     */
    public JButton getMyInfo(){
        return this.myInfo;
    }
}

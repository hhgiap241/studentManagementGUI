package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 11/26/2021 - 9:39 PM
 * Description: Switch panel when click specified button handling
 */

public class SwitchPanelHandling extends JPanel {
    /**
     * panel to show my information
     * @return JPanel
     */
    public JPanel myInformation(){
        JPanel info = new JPanel(new GridBagLayout());
        JLabel overview = new JLabel("My student information", SwingConstants.CENTER);
        overview.setFont(overview.getFont().deriveFont (50.0f));
        overview.setForeground(Color.blue);
        JLabel id = new JLabel("ID:");
        id.setFont(id.getFont().deriveFont (26.0f));
        JLabel name = new JLabel("Name:");
        name.setFont(name.getFont().deriveFont (26.0f));
        JLabel classs = new JLabel("Class:");
        classs.setFont(classs.getFont().deriveFont (26.0f));
        JLabel lecturers = new JLabel("Lecturers:");
        lecturers.setFont(lecturers.getFont().deriveFont (26.0f));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        info.add(id, gbc);
        gbc.gridy = 2;
        info.add(name, gbc);
        gbc.gridy = 3;
        info.add(classs, gbc);
        gbc.gridy = 4;
        info.add(lecturers, gbc);
        JLabel id_1 = new JLabel("19127640");
        id_1.setFont(id_1.getFont().deriveFont (26.0f));
        JLabel name_1 = new JLabel("Hoàng Hữu Giáp");
        name_1.setFont(name_1.getFont().deriveFont (26.0f));
        JLabel classs_1 = new JLabel("Introduction to Java");
        classs_1.setFont(classs_1.getFont().deriveFont (26.0f));
        JLabel lecturers_1 = new JLabel("Nguyễn Văn Khiết,");
        lecturers_1.setFont(lecturers_1.getFont().deriveFont (26.0f));
        JLabel lecturers_2 = new JLabel("Nguyễn Đức Huy");
        lecturers_2.setFont(lecturers_2.getFont().deriveFont (26.0f));
        gbc.gridy = 1;
        gbc.gridx = 1;
        info.add(id_1, gbc);
        gbc.gridy = 2;
        info.add(name_1, gbc);
        gbc.gridy = 3;
        info.add(classs_1, gbc);
        gbc.gridy = 4;
        info.add(lecturers_1, gbc);
        gbc.gridy = 5;
        info.add(lecturers_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        info.add(overview, gbc);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        return info;
    }

    /**
     * function to add student to list and database
     * @param studentList StudentList
     * @param connection Connection
     * @return JPanel
     */
    public JPanel addStudentPanel(StudentList studentList, Connection connection){
        JLabel idLabel;
        JLabel nameLabel;
        JLabel gpaLabel;
        JLabel imageLabel;
        JLabel addressLabel;
        JLabel notesLabel;

        JTextField idText;
        JTextField nameText;
        JTextField gpaText;
        JTextField imageText;
        JTextField addressText;
        JTextArea notesText;
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());
        JPanel contentPanel = new JPanel();
        header = new JLabel("ADD NEW STUDENT", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (20.0f));
        header.setForeground(Color.blue);
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        idLabel = new JLabel("ID");
        contentPanel.add(idLabel, gbc);
        gbc.gridy = 2;
        nameLabel = new JLabel("Name");
        contentPanel.add(nameLabel, gbc);
        gbc.gridy = 3;
        gpaLabel = new JLabel("GPA");
        contentPanel.add(gpaLabel, gbc);
        gbc.gridy = 4;
        imageLabel = new JLabel("Image");
        contentPanel.add(imageLabel, gbc);
        gbc.gridy = 5;
        addressLabel = new JLabel("Address");
        contentPanel.add(addressLabel, gbc);
        gbc.gridy = 6;
        notesLabel = new JLabel("Notes");
        contentPanel.add(notesLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        idText = new JTextField(10);
        contentPanel.add(idText, gbc);
        gbc.gridy = 2;
        nameText = new JTextField(10);
        contentPanel.add(nameText, gbc);
        gbc.gridy = 3;
        gpaText = new JTextField(10);
        contentPanel.add(gpaText, gbc);
        gbc.gridy = 4;
        imageText = new JTextField(10);
        contentPanel.add(imageText, gbc);
        gbc.gridy = 5;
        addressText = new JTextField(10);
        contentPanel.add(addressText, gbc);
        gbc.gridy = 6;
        notesText = new JTextArea(10,20);
        contentPanel.add(notesText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(header, gbc);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setStudentID(idText.getText());
                student.setStudentName(nameText.getText());
                student.setStudentGPA(Float.parseFloat(gpaText.getText()));
                student.setStudentImage(imageText.getText());
                student.setStudentAddress(addressText.getText());
                student.setStudentNotes(notesText.getText());
                Integer isComplete = studentList.addStudents(student);
                if(isComplete == 2){
                    try {
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
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Add new student successfully!!!");
                    idText.setText("");
                    nameText.setText("");
                    gpaText.setText("");
                    imageText.setText("");
                    addressText.setText("");
                    notesText.setText("");
                }else if (isComplete == 1){
                    JOptionPane.showMessageDialog(null, "Blank information, please input again.");
                }else if (isComplete == 0){
                    JOptionPane.showMessageDialog(null, "This student is already exists, please input again.");
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idText.setText("");
                nameText.setText("");
                gpaText.setText("");
                imageText.setText("");
                addressText.setText("");
                notesText.setText("");
            }
        });
        footerContent.add(ok);
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(cancel);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);

        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        return panel;
    }

    /**
     * function to handle update student event
     * @param studentList StudentList
     * @param connection Connection
     * @return JPanel
     */
    public JPanel updateStudentPanel(StudentList studentList, Connection connection){
        JLabel nameLabel;
        JLabel gpaLabel;
        JLabel imageLabel;
        JLabel addressLabel;
        JLabel notesLabel;

        JTextField nameText;
        JTextField gpaText;
        JTextField imageText;
        JTextField addressText;
        JTextArea notesText;
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());

        header = new JLabel("UPDATE STUDENT INFORMATION", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (14.0f));
        header.setForeground(Color.blue);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameLabel = new JLabel("Name");
        contentPanel.add(nameLabel, gbc);
        gbc.gridy = 2;
        gpaLabel = new JLabel("GPA");
        contentPanel.add(gpaLabel, gbc);
        gbc.gridy = 3;
        imageLabel = new JLabel("Image");
        contentPanel.add(imageLabel, gbc);
        gbc.gridy = 4;
        addressLabel = new JLabel("Address");
        contentPanel.add(addressLabel, gbc);
        gbc.gridy = 5;
        notesLabel = new JLabel("Notes");
        contentPanel.add(notesLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        nameText = new JTextField(10);

        contentPanel.add(nameText, gbc);
        gbc.gridy = 2;
        gpaText = new JTextField(10);

        contentPanel.add(gpaText, gbc);
        gbc.gridy = 3;
        imageText = new JTextField(10);

        contentPanel.add(imageText, gbc);
        gbc.gridy = 4;
        addressText = new JTextField(10);

        contentPanel.add(addressText, gbc);
        gbc.gridy = 5;
        notesText = new JTextArea(10,20);

        contentPanel.add(notesText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(header, gbc);
        FindStudentPanel find = new FindStudentPanel();
        JPanel findStudent = find.getFindStudentPanel();
        find.getFindBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = find.getFindText().getText();
                find.setFoundStudent(studentList.findAStudent(studentID));
                if(find.getFoundStudent()  == null){
                    JOptionPane.showMessageDialog(null, "Can't find student " + studentID);
                }else{
                    JOptionPane.showMessageDialog(null, "Found this student");
                    nameText.setText(find.getFoundStudent().getStudentName());
                    gpaText.setText(find.getFoundStudent().getStudentGPA().toString());
                    imageText.setText(find.getFoundStudent().getStudentImage());
                    addressText.setText(find.getFoundStudent().getStudentAddress());
                    notesText.setText(find.getFoundStudent().getStudentNotes());
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student newStudentInfo = new Student();
                newStudentInfo.setStudentID(find.getFindText().getText());
                newStudentInfo.setStudentName(nameText.getText());
                newStudentInfo.setStudentGPA(Float.parseFloat(gpaText.getText()));
                newStudentInfo.setStudentImage(imageText.getText());
                newStudentInfo.setStudentAddress(addressText.getText());
                newStudentInfo.setStudentNotes(notesText.getText());
                boolean isComplete = studentList.updateStudent(newStudentInfo);

                if (isComplete){
                    try {
                        String SQL = "UPDATE STUDENT SET STUDENT_NAME=?,STUDENT_GPA=?,STUDENT_IMAGES=?,STUDENT_ADDRESS=?,STUDENT_NOTES=? WHERE STUDENT_ID=?";
                        PreparedStatement p = connection.prepareStatement(SQL);
                        p.setString(6, newStudentInfo.getStudentID());
                        p.setString(1, newStudentInfo.getStudentName());
                        p.setFloat(2, newStudentInfo.getStudentGPA());
                        p.setString(3, newStudentInfo.getStudentImage());
                        p.setString(4, newStudentInfo.getStudentAddress());
                        p.setString(5, newStudentInfo.getStudentNotes());
                        p.executeUpdate();
                        p.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Update student information successfully!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Failed!!! Check your input again.");
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find.getFindText().setText("");
                nameText.setText("");
                gpaText.setText("");
                imageText.setText("");
                addressText.setText("");
                notesText.setText("");
            }
        });
        footerContent.add(submit);
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(cancel);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);

        panel.add(findStudent, BorderLayout.PAGE_START);
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        return panel;
    }

    /**
     * delete student from list and database
     * @param studentList StudentList
     * @param connection Connection
     * @return JPanel
     */
    public JPanel deleteStudentPanel(StudentList studentList, Connection connection){
        JLabel nameLabel;
        JLabel gpaLabel;
        JLabel imageLabel;
        JLabel addressLabel;
        JLabel notesLabel;

        JTextField nameText;
        JTextField gpaText;
        JTextField imageText;
        JTextField addressText;
        JTextArea notesText;
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());
        header = new JLabel("DELETE STUDENT", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (14.0f));
        header.setForeground(Color.blue);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameLabel = new JLabel("Name");
        contentPanel.add(nameLabel, gbc);
        gbc.gridy = 2;
        gpaLabel = new JLabel("GPA");
        contentPanel.add(gpaLabel, gbc);
        gbc.gridy = 3;
        imageLabel = new JLabel("Image");
        contentPanel.add(imageLabel, gbc);
        gbc.gridy = 4;
        addressLabel = new JLabel("Address");
        contentPanel.add(addressLabel, gbc);
        gbc.gridy = 5;
        notesLabel = new JLabel("Notes");
        contentPanel.add(notesLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 1;
        nameText = new JTextField(10);

        contentPanel.add(nameText, gbc);
        gbc.gridy = 2;
        gpaText = new JTextField(10);

        contentPanel.add(gpaText, gbc);
        gbc.gridy = 3;
        imageText = new JTextField(10);

        contentPanel.add(imageText, gbc);
        gbc.gridy = 4;
        addressText = new JTextField(10);

        contentPanel.add(addressText, gbc);
        gbc.gridy = 5;
        notesText = new JTextArea(10,20);

        contentPanel.add(notesText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(header, gbc);
        FindStudentPanel find = new FindStudentPanel();
        JPanel findStudent = find.getFindStudentPanel();
        find.getFindBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = find.getFindText().getText();
                find.setFoundStudent(studentList.findAStudent(studentID));
                if(find.getFoundStudent()  == null){
                    JOptionPane.showMessageDialog(null, "Can't find student " + studentID);
                }else{
                    JOptionPane.showMessageDialog(null, "Found this student");
                    nameText.setText(find.getFoundStudent().getStudentName());
                    gpaText.setText(find.getFoundStudent().getStudentGPA().toString());
                    imageText.setText(find.getFoundStudent().getStudentImage());
                    addressText.setText(find.getFoundStudent().getStudentAddress());
                    notesText.setText(find.getFoundStudent().getStudentNotes());
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = find.getFindText().getText();
                boolean isComplete = studentList.deleteStudent(studentID);
                if (isComplete){
                    try {
                        String SQL = "DELETE FROM STUDENT WHERE STUDENT_ID=?";
                        PreparedStatement p = connection.prepareStatement(SQL);
                        p.setString(1, studentID);
                        p.executeUpdate();
                        p.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Delete student " + studentID + " successfully!!!");
                    find.getFindText().setText("");
                    nameText.setText("");
                    gpaText.setText("");
                    imageText.setText("");
                    addressText.setText("");
                    notesText.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Failed!!! Check your input again.");
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find.getFindText().setText("");
                nameText.setText("");
                gpaText.setText("");
                imageText.setText("");
                addressText.setText("");
                notesText.setText("");
            }
        });
        footerContent.add(delete);
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(cancel);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);

        panel.add(findStudent, BorderLayout.PAGE_START);
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        return panel;
    }

    /**
     * View student list view
     * @param studentList StudentList
     * @return JPanel
     */
    public JPanel viewStudentList(StudentList studentList){
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());
        header = new JLabel("ALL STUDENTS INFORMATION", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (20.0f));
        header.setForeground(Color.blue);
        TableList tableList = new TableList();
        tableList.setUpTable(studentList);
        int delay = 1; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tableList.setUpTable(studentList);
            }
        };
        new Timer(delay, taskPerformer).start();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        JButton sortByID = new JButton("Sort student ID in ascending order");
        sortByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentList.getStudentListLength() == 0){
                    JOptionPane.showMessageDialog(null, "Nothing to sort!!!");
                }else{
                    studentList.sortStudentIdAscending();
                    tableList.setUpTable(studentList);
                    JOptionPane.showMessageDialog(null, "Sorted student list by ID successfully!!!");
                }
            }
        });
        footerContent.add(sortByID);
        JButton sortByGPA = new JButton("Sort student GPA in ascending order");
        sortByGPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentList.getStudentListLength() == 0){
                    JOptionPane.showMessageDialog(null, "Nothing to sort!!!");
                }else{
                    studentList.sortStudentGPAAscending();
                    tableList.setUpTable(studentList);
                    JOptionPane.showMessageDialog(null, "Sorted student list by GPA successfully!!!");
                }
            }
        });
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(sortByGPA);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);
        JScrollPane scrollPane = new JScrollPane(tableList.getTable(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(header, BorderLayout.PAGE_START);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.PAGE_END);
        return panel;
    }

    /**
     * function to handle import student list from CSV file
     * @param studentList StudentList
     * @return JPanel
     */
    public JPanel importFromCSV(StudentList studentList){
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());
        header = new JLabel("IMPORT STUDENT LIST FROM CSV FILE", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (24.0f));
        header.setForeground(Color.blue);
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel fileXLabel = new JLabel("Input filename (.csv) or choose a file: ");
        JTextField fileXText = new JTextField(30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        final JFileChooser fileDialog = new JFileChooser();
        JButton showFileDialogButton = new JButton("Choose a CSV File");
        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    fileXText.setText(fileDialog.getSelectedFile().getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null,"Open command cancelled by user.");
                }
            }
        });
        footerContent.add(showFileDialogButton);
        JButton importBtn = new JButton("Import");
        importBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = fileXText.getText();
                try {
                    boolean isComplete = studentList.importFromCSV(filename);
                    if (isComplete){ // if import success
                        fileXText.setText("");
                        JOptionPane.showMessageDialog(null, "Imported student list from " + filename);
                    }else{
                        JOptionPane.showMessageDialog(null, "Imported failed. Please check filename again");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(importBtn);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileXText.setText("");
            }
        });
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(cancel);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);

        gbc.insets = new Insets(5,5,5,5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        contentPanel.add(buttonPanel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(fileXLabel, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(header, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(fileXText, gbc);
        panel.add(contentPanel, BorderLayout.PAGE_START);
        return panel;
    }

    /**
     * function to export student list to CSV file
     * @param studentList StudentList
     * @return JPanel
     */
    public JPanel exportToCSV(StudentList studentList){
        JLabel header;
        JPanel panel = new JPanel(new BorderLayout());
        header = new JLabel("EXPORT STUDENT LIST TO CSV FILE", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (24.0f));
        header.setForeground(Color.blue);
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel fileXLabel = new JLabel("Input filename (.csv): ");
        JTextField fileXText = new JTextField(30);
        JButton exportBtn = new JButton("Export");
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 2;
        gbc.gridy = 2;
        contentPanel.add(exportBtn, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(fileXLabel, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(header, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(fileXText, gbc);

        panel.add(contentPanel, BorderLayout.PAGE_START);
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = fileXText.getText();
                if (filename.length() == 0){
                    filename = "output.csv";
                }
                try {
                    boolean isComplete =  studentList.exportToCSV(filename);
                    if (isComplete){
                        JOptionPane.showMessageDialog(null, "Exported to " + filename);
                        fileXText.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Exported failed");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return panel;
    }
}

package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 12/4/2021 - 8:43 PM
 * Description: class to handle JTable
 */
public class TableList {
    // attributes
    private JTable table;
    private DefaultTableModel model;

    /**
     * default constructor
     */
    TableList(){
        model = new DefaultTableModel();
        table = new JTable();
    }

    /**
     * function to set up JTable
     * @param studentList StudentList
     */
    public void setUpTable(StudentList studentList){
        String[] columns = {"ID", "Name", "GPA", "Image", "Address", "Notes"};
        model.setColumnIdentifiers(columns);
        Vector<Vector<String>> temp = new Vector<Vector<String>>();
        temp = studentList.allList();
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        for (Vector<String> i: temp){
            model.addRow(i);
        }
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
    /**
     * getter table
     * @return JTable
     */
    public JTable getTable() {
        return table;
    }
    /**
     * getter model
     * @return DefaultTableModel
     */
    public DefaultTableModel getModel() {
        return model;
    }
}

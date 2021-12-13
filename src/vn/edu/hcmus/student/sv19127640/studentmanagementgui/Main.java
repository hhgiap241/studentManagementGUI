package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import java.sql.SQLException;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 12/5/2021 - 1:11 PM
 * Description: main class
 * db server: "MSSQLSERVER"
 * db username: sa
 * db password: 123
 * db port number: 1433
 * db database name: STUDENT_MANAGEMENT
 */
public class Main {
    /**
     * main function
     * @param  argv String array
     * @throws SQLException
     */
    public static void main(String[] argv) throws SQLException {
        ConnectDatabasePanel connectDatabaseForm = new ConnectDatabasePanel();
        connectDatabaseForm.showGUI();
    }
}

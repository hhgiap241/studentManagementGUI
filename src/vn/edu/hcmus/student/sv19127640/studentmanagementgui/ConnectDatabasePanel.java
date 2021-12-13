package vn.edu.hcmus.student.sv19127640.studentmanagementgui;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * vn.edu.hcmus.student.sv19127640.studentmanagementgui
 * Created by ADMIN
 * Date 11/27/2021 - 1:27 AM
 * Description: Form to connect database
 */
public class ConnectDatabasePanel extends JPanel{
    // attribute
    private JTextField dbServerText;
    private JTextField ipText ;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton connectBtn;
    private JButton exitBtn;
    private Integer portNumber;
    private Connection connection;
    private JFrame frame;

    /**
     * set up GUI for login
     */
    public void setUpGUI(){
        setLayout(new BorderLayout());
        JLabel header = new JLabel("WELCOME TO STUDENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont (18.0f));
        header.setForeground(Color.blue);
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        JLabel dbServer = new JLabel("DB server: ");
        JLabel ip = new JLabel("IP: ");
        JLabel user = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        dbServerText = new JTextField(10);
        ipText = new JTextField(10);
        userText = new JTextField(10);
        passwordText = new JPasswordField(10);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(dbServer, gbc);
        gbc.gridy = 2;
        contentPanel.add(ip, gbc);
        gbc.gridy = 3;
        contentPanel.add(user, gbc);
        gbc.gridy = 4;
        contentPanel.add(password, gbc);
        gbc.weightx = 0.5;
        gbc.gridy = 1;
        gbc.gridx = 1;
        contentPanel.add(dbServerText, gbc);
        gbc.gridy = 2;
        contentPanel.add(ipText, gbc);
        gbc.gridy = 3;
        contentPanel.add(userText, gbc);
        gbc.gridy = 4;
        contentPanel.add(passwordText, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        contentPanel.add(header, gbc);
        gbc.gridy = 5;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        JPanel footerContent = new JPanel();
        footerContent.setLayout(new BoxLayout(footerContent, BoxLayout.X_AXIS));
        connectBtn = new JButton("Connect to database");

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        footerContent.add(connectBtn);
        footerContent.add(Box.createRigidArea(new Dimension(20,0)));
        footerContent.add(exitBtn);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(footerContent);
        contentPanel.add(buttonPanel, gbc);

        add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * show GUI for login to database
     * @throws SQLException exception
     */
    public void showGUI() throws SQLException {
        frame = new JFrame("Set up database connection");

        setOpaque(true);
        frame.setContentPane(this);
        frame.setMinimumSize(new Dimension(500, 250));
        frame.setVisible(true);
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isComplete = createConnection();
                if (isComplete){
                    try {
                        System.out.println(connection.getMetaData());
                        System.out.println(connection.getCatalog());
                        JOptionPane.showMessageDialog(frame, "Connected to database successfully");
                        frame.setVisible(false);
                        StudentManagementPanel studentManagementGUI = new StudentManagementPanel(connection);
                        studentManagementGUI.showGUI();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid input, please input again.");
                }
            }
        });
    }

    /**
     * default constructor
     * @throws SQLException
     */
    ConnectDatabasePanel() throws SQLException {
        setUpGUI();
    }

    /**
     * getter db server name
     * @return JTextField
     */
    public JTextField getDbServerText() {
        return dbServerText;
    }

    /**
     * getter IP
     * @return JTextField
     */
    public JTextField getIpText() {
        return ipText;
    }

    /**
     * getter username
     * @return JTextField
     */
    public JTextField getUserText() {
        return userText;
    }

    /**
     * getter password
     * @return JPasswordField
     */
    public JPasswordField getPasswordText() {
        return passwordText;
    }

    /**
     * getter connect button
     * @return JButton
     */
    public JButton getConnectBtn() {
        return connectBtn;
    }

    /**
     * getter exit button
     * @return JButton
     */
    public JButton getExitBtn() {
        return exitBtn;
    }

    /**
     * getter port number
     * @return Integer
     */
    public Integer getPortNumber() {
        return portNumber;
    }

    /**
     * getter connection
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * get full server name from IP and Server name when user input
     * @return String
     */
    public String getFullServerName (){
        String str = "";
        String [] partialStr = ipText.getText().split(":");
        portNumber = null;
        if (partialStr.length == 1){ // if don't have port number => set to 1433
            portNumber = 1433;
        }else{
            portNumber = Integer.parseInt(partialStr[1]);
        }
        str = partialStr[0] + "\\" + dbServerText.getText();
        return str;
    }

    /**
     * check if user input is valid or not
     * @return boolean
     */
    public boolean isValidInput (){
        if (dbServerText.getText().length() == 0 || ipText.getText().length() == 0 ||
            userText.getText().length() == 0 || passwordText.getPassword().length == 0){
            return false;
        }
        return true;
    }

    /**
     * create a connection to SQL Server
     * @return boolean
     */
    public boolean createConnection(){
        boolean isValidInput = this.isValidInput();
        if (isValidInput) {
            // String serverName = connectDatabaseForm.getDbServerText().getText();
            String username = this.userText.getText();
            String password = String.valueOf(this.passwordText.getPassword());
            // String ip = connectDatabaseForm.getIpText().getText();
            String dbName = "STUDENT_MANAGEMENT";
            String serverName = this.getFullServerName();
            Integer portNumber = this.portNumber;
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser(username);
            ds.setPassword(password);
            ds.setDatabaseName(dbName);
            ds.setServerName(serverName);
            ds.setPortNumber(portNumber);
            try {
                connection = ds.getConnection();
                if (connection != null) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception err) {
                err.printStackTrace();
                System.out.println("Error Trace in getConnection() : " + err.getMessage());
            }
        }
        return false;
    }
}

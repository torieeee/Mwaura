package com.example.patients;

import com.mysql.cj.util.StringInspector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

import java.text.ParseException;
import java.time.LocalDate;
import java.sql.Date;


public class SignUp extends JDialog {
    public JPanel Sign_up;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textPhoneNumber;
    private JTextField textAddress;
    private JTextField textGender;
    private JTextField textID;
    private JPasswordField Password;
    private JPasswordField ConfirmPassword;
    private JButton btnsignUp;
    private JButton btnCancel;
    private JLabel textPhoneNo;
    private JTextField textAge;
    private JTextField textRole;
    private Users user;
    private doctors doctor;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public SignUp(JFrame parent) {
        super(parent);

        setTitle("Create a new Account");
        setContentPane(Sign_up);
        setMinimumSize(new Dimension(500, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnsignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        setVisible(true);
    }

    private void registerUser() {
        String name = textName.getText();
        String age = textAge.getText();
        String ID = textID.getText();
        String email = textEmail.getText();
        String phone_no = textPhoneNumber.getText();
        String gender = textGender.getText();
        String role = textRole.getText();
        String address = textAddress.getText();
        String password = String.valueOf(Password.getPassword());
        String confirmPassword = String.valueOf(ConfirmPassword.getPassword());
        System.out.println("password: " + password);
        System.out.println("confirm password: " + confirmPassword);

        if (name.isEmpty() || email.isEmpty() || ID.isEmpty() || phone_no.isEmpty() || role.isEmpty() || age.isEmpty() || address.isEmpty() || gender.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "try again", JOptionPane.ERROR_MESSAGE);
            return;

        }
        user = addUserToDatabase(name, email, role, age, ID, phone_no, address, gender, password);
        if (user != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to register new user", "Try again", JOptionPane.ERROR_MESSAGE);


        }
    }

    private Users addUserToDatabase(String name, String email, String role, String age, String ID, String phone_no, String address, String gender, String password) {
        Users user = null;
        Connectivity1 connect = new Connectivity1();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");
            ResultSet resultSet=null;
            String sql = "INSERT INTO users(id,name,age,phone_no,gender,address,email,role,user_password)" +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            if (role.equals("doctor")) {


                String private_clinic_address = JOptionPane.showInputDialog("Enter the address of your clinic address:");
                String Medical_license_no = JOptionPane.showInputDialog("Enter your medical license number:");
                String hospital_address = JOptionPane.showInputDialog("Enter your hospital address:");
                String specialization = JOptionPane.showInputDialog("enter your specialization:");

                String name2=JOptionPane.showInputDialog("What is your workplace name?");


                // Update the doctors table with the new information
                String sql2 ="INSERT INTO doctors(private_clinic_address,medical_license_no,hospital_address,specialization,name,id) " +
                        "VALUES(?,?,?,?,?,?)";
                try (
                        PreparedStatement pstmt = connection.prepareStatement(sql2)) {

                    pstmt.setString(6, ID);
                    pstmt.setString(5, name);
                    pstmt.setString(1, private_clinic_address);
                    pstmt.setString(2, Medical_license_no);
                    pstmt.setString(3, hospital_address);
                    pstmt.setString(4, specialization);
                    int rowsUpdated = pstmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Doctor information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error updating doctor information.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                    ;} else if (role.equals("patient")) {
                // Get additional information for patients


                String patient_id=JOptionPane.showInputDialog("Enter your patient id");







                String sql3 = "INSERT INTO patients (patient_id,id, name, address, phone_no) " +
                        "VALUES (?, ?,?, ?, ?)";

                try{
                    PreparedStatement pt2=connection.prepareStatement(sql3);
                    pt2.setString(1,patient_id);
                    pt2.setString(2,ID);
                    pt2.setString(3,name);
                    pt2.setString(4,address);
                    pt2.setString(5,phone_no);
                    int rowsUpdated = pt2.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Patient information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error updating doctor information.");
                    }


                }catch(SQLException ex){
                    ex.printStackTrace();


                }
                
            }


                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, ID);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, age);
                    preparedStatement.setString(4, phone_no);
                    preparedStatement.setString(5, gender);
                    preparedStatement.setString(6, address);
                    preparedStatement.setString(7, email);
                    preparedStatement.setString(8, role);
                    preparedStatement.setString(9, password);

                    int addedRows = preparedStatement.executeUpdate();
                    if (addedRows > 0) {
                        user = new Users();
                        user.name = name;
                        user.email = email;
                        user.address = address;
                        user.password = password;
                        user.age = age;
                        user.role = role;
                        user.phone_no = phone_no;
                        user.id = ID;
                    }
                    preparedStatement.close();
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


                return user;
            }


            public static void main (String[]args){
                SignUp myForm = new SignUp(null);
                Users user = myForm.user;

                if (user != null) {
                    System.out.println("Successful registration of: " + user.name);

                } else {
                    System.out.println("Registration cancelled");
                }
            }
        }


package com.example.patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.example.patients.Users;


public class NewLogin extends JDialog {
    public JPanel Login;
    private JTextField id_No;
    private JTextField txtName;
    private JButton loginbtn;
    private JPasswordField passwordField1;
    public Users user;



    public NewLogin(JFrame parent) {
        super(parent);

        setContentPane(Login);
        setTitle("loginPanel");

        setMinimumSize(new Dimension(400, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=id_No.getText();
                String name = txtName.getText();
                String password = String.valueOf(passwordField1.getPassword());
                 Users user=getAuthenticatedUser(id,name,password);
                if(user!=null){
                    dispose();
                    JOptionPane.showMessageDialog(null, "Successful authentication of: " + user.name);
                    System.out.println("id " + user.id);
                    System.out.println("phone number " + user.phone_no);
                    System.out.println("age " + user.age);
                    System.out.println("address " + user.address);
                    System.out.println("role  " + user.role);
                    System.out.println("gender " + user.gender);
                    System.out.println("email " + user.email);
                }else {
                    JOptionPane.showMessageDialog(NewLogin.this,"Invalid Credentials","Try again",JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });
        setVisible(true);


    }

    public Users getAuthenticatedUser(String id,String name, String password ) {
        Users user= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");

            Statement mine=connection.createStatement();
            String sql="SELECT * FROM users WHERE id=? AND name=? AND user_password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user=new Users();
                user.name=resultSet.getString("name");
                user.email=resultSet.getString("email");
                user.id=resultSet.getString("id");
                user.age= resultSet.getString("age");
                user.address=resultSet.getString("address");
                user.phone_no=resultSet.getString("phone_no");
                user.role=resultSet.getString("role");
                user.gender=resultSet.getString("gender");
                user.password=resultSet.getString("user_password");
user.setRole("role");
            }
mine.close();
            connection.close();
        } catch (Exception e) {
e.printStackTrace();

        }
        return user;
    }


    public static void main(String[] args) {
       NewLogin login=new NewLogin( null);
        Users user=login.user;

    }
}
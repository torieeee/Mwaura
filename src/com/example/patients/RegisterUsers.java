package com.example.patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUsers extends JFrame implements ActionListener {
    private JLabel lblmsg;
    private JTextField txtName,txtID,txtGender,txtPhoneNo,txtEmail,txtAddress,txtAge,txtUserPassword,txtRole;
    private JButton SignUp;
    public RegisterUsers(){
        setLayout(new FlowLayout());
        lblmsg=new JLabel("WELCOME TO DOCTOR ON TIME");
        add(lblmsg);
        txtName=new JTextField("Enter your Name");
        add(txtName);
        txtID=new JTextField("enter your ID number");
        add(txtID);
txtGender=new JTextField("What is your gender?");
add(txtGender);
txtPhoneNo=new JTextField("Enter your phone number");
add(txtPhoneNo);
txtAge=new JTextField("enter your age");
add(txtAge);
txtAddress=new JTextField("where do you live?");
add(txtAddress);
txtRole=new JTextField("Are you a doctor or a petient?");
add(txtRole);
txtEmail=new JTextField("Enter your email address");
        add(txtEmail);
txtUserPassword=new JTextField("set your preferred password");
add(txtUserPassword);
        SignUp=new JButton("Create an account");
        SignUp.addActionListener(this);
        add(SignUp);
    }
    public static void main(String args[]){
        RegisterUsers sign=new RegisterUsers();
        sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sign.setSize(600,700);
        sign.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SignUp) {
            String name = txtName.getText();
            lblmsg.setText("WELCOME  " + name);
            JOptionPane.showMessageDialog(null, "Welcome", "Signed up", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

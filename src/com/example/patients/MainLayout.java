package com.example.patients;
import com.example.patients.SignUp;
import com.example.patients.AppointmentBooking;
import com.example.patients.DoctorPanel;
import com.example.patients.NewLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLayout extends JDialog {

    private JButton registerbtn;
    CardLayout cardLayout;
    private JButton loginButton;
    private JPanel MainFrame;
    private JPanel Panel2;
    public Users user;
    public NewLogin login;
    public SignUp sign;

    public MainLayout(JFrame parent) {
        super(parent);
        setTitle("WELCOME!");
        setContentPane(MainFrame);
        setMinimumSize(new Dimension(200,200));
        setModal(true);
        setVisible(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cardLayout= new CardLayout();
MainFrame=new JPanel(cardLayout);
        registerbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            SignUp sign =new SignUp(null);
            sign.setModal(true);

            sign.setVisible(true);

        }
    });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
NewLogin new1=new NewLogin(null);

            }
        });
    }
public AppointmentBooking app1;
    public static void main(String[] args) {
        MainLayout main=new MainLayout(null);


    }
    public NewLogin login(){


        return login;
    }
}

package com.example.patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static java.awt.Font.BOLD;


public class Registration extends JFrame {
    private JLabel lbl_IntroMsg1, lbl_IntroMsg2;
    private JButton btnPatients, btnDoctor;

    public Registration() {
        JFrame frame_login = new JFrame();
        JPanel panel_login = new JPanel();
        frame_login.setTitle("Welcome to Doctor on time");

        panel_login.setLayout(null);

        frame_login.add(panel_login);
        frame_login.setBounds(410, 150, 400, 400);
        frame_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_login.setResizable(false);
        panel_login.setBackground(new Color(255, 104, 152));
        Font header = new Font("Header", BOLD | Font.ROMAN_BASELINE, 18);
        Font mono = new Font("mono", BOLD | Font.ITALIC, 17);

        lbl_IntroMsg1 = new JLabel("Welcome to Doctor on time");
        lbl_IntroMsg1.setBounds(10, 5, 300, 100);
        lbl_IntroMsg1.setFont(header);

        lbl_IntroMsg2 = new JLabel("Choose your role");

        lbl_IntroMsg2.setFont(mono);
        lbl_IntroMsg2.setBounds(70, 65, 220, 70);

        btnDoctor = new JButton("Doctor");
        btnDoctor.setBounds(100, 120, 150, 30);

        btnPatients = new JButton("Patient");
        btnPatients.setBounds(100, 160, 150, 30);


        panel_login.add(lbl_IntroMsg1);
        panel_login.add(lbl_IntroMsg2);
        panel_login.add(btnDoctor);
        panel_login.add(btnPatients);

        frame_login.setVisible(true);


    }
    }

package com.example.patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AppointmentBooking extends JDialog {
    private JTextField textID;
    private JTextField textSpecialists;
    private JTextField textTime;
    private JButton bookButton;
    private JTextField textAddress;
    private JButton cancelButton;
    private JPanel Booking;
    private JTextField txtAppID;
    private JTextField textDate;


    public AppointmentBooking(JFrame parent) {
    super(parent);
    setTitle("Book an appointment");
    setContentPane(Booking);
    setMinimumSize(new Dimension(450,450));
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    bookButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
bookAppointment();
        }
    });
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    setVisible(true);
}
public Appointments app;
private Appointments bookAppointment() {
    String AppointmentId = txtAppID.getText();
    String PatientID = textID.getText();
    String time = textTime.getText();
    String date = textDate.getText();
    String address = textAddress.getText();
    String specialist = textSpecialists.getText();
String doctor_id=null;



     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");
         String sql="SElECT Medical_license_no FROM doctors WHERE hospital_address=? AND specialization=?";
         PreparedStatement preparedStatement=connection.prepareStatement(sql);
         preparedStatement.setString(1, address);
         preparedStatement.setString(2,specialist);

         ResultSet resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
             doctor_id = resultSet.getString("Medical_license_no");
         }
         if(doctor_id!=null) {
             String sql1 = "INSERT INTO appointments(appointment_id,doctor_seen,doctor_id,patient_id,timing,date_of_appointment,address)" +
                     "VALUES(?,?,?,?,?,?,?)";
             PreparedStatement stmt = connection.prepareStatement(sql1);
             stmt.setString(1,AppointmentId );
             stmt.setString(2, specialist);
             stmt.setString(3, doctor_id);
             stmt.setString(4, PatientID);
             stmt.setString(5, time);
             stmt.setString(6, date);
             stmt.setString(7, address);

             int addedRows = stmt.executeUpdate();
             if (addedRows > 0) {
                 app = new Appointments();
                 app.appointment_id =AppointmentId;
                 app.specialist = specialist;
                 app.doctor_id = doctor_id;
                 app.patient_id = AppointmentId;
                 app.DOA = date;
                 app.timing = time;
                 app.address = address;
             }
             stmt.close();
             preparedStatement.close();
         }
         connection.close();



     }catch(Exception e){
e.printStackTrace();
     }
     return app;
}

    public static void main(String[] args) {
        AppointmentBooking myTime=new AppointmentBooking(null);
        Appointments app=myTime.app;


    }

}

package com.example.patients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorPanel extends JDialog {
    private JTextField txtLicense;
    private JButton viewAppointmentsSchedulesButton;
    private JButton viewDetailsButton;
    private JPanel Doctor_view;
    public doctors doctor;
    public Appointments app;
public DoctorPanel (JFrame parent) {
super(parent);

    setTitle("DOCTORS VIEW");

    setContentPane(Doctor_view);
    setMinimumSize(new Dimension(400,400));
    setModal(true);
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);




    viewAppointmentsSchedulesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
String Medical_licence_no=txtLicense.getText();
app=apply(Medical_licence_no);

            if (app != null) {
                JOptionPane.showMessageDialog(null, "Appointment Details:" + "\n" + "Patient ID: " + app.patient_id + "\n" + "Date of Appointment: " + app.DOA + "\n" + "Timing: " + app.timing + "\n" + "Doctor Seen: " + app.specialist + "\n" + "Appointment ID: " + app.appointment_id + "\n" + "Doctor ID: " + app.doctor_id + "\n" + "Address: " + app.address, "Appointment Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Appointments Found!");
            }

        }
    });
    viewDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String license_no=txtLicense.getText();
            doctor=verify(license_no);

            if(doctor!=null){

                JOptionPane.showMessageDialog(null,"these are your details"+"\n"+doctor.id+"\n"+doctor.name+"\n"+doctor.hospital_address+"\n"+doctor.specialisation+"\n"+doctor.private_clinic_address,"Success",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Oops!");
            }

        }
    });

    setVisible(true);
}
    public Appointments apply(String doctor_id){
    Appointments app=null;
    try{ Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");

        Statement mine=connection.createStatement();
        String sql="SELECT * FROM appointments WHERE doctor_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,doctor_id);
        ResultSet resultSet = preparedStatement.executeQuery();
if(resultSet.next()){
    app=new Appointments();
app.patient_id=resultSet.getString("patient_id");
app.DOA=resultSet.getString("date_of_appointment");
app.timing=resultSet.getString("timing");
app.specialist=resultSet.getString("doctor_seen");
app.appointment_id=resultSet.getString("Appointment_id");
app.doctor_id=resultSet.getString("doctor_id");
app.address=resultSet.getString("address");


}
preparedStatement.close();
mine.close();
connection.close();
    }catch(Exception e){

    }
    return app;

    }
public doctors verify(String Medical_licence_no){
    doctors doctor=null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/victoria", "root", "");
        Statement mine=connection.createStatement();
        String sql="SELECT * FROM doctors WHERE Medical_license_no=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,Medical_licence_no);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            doctor=new doctors();
            doctor.name=resultSet.getString("name");
            doctor.id=resultSet.getString("id");
            doctor.Medical_licence_no=resultSet.getString("Medical_license_no");
            doctor.hospital_address=resultSet.getString("hospital_address");
            doctor.private_clinic_address=resultSet.getString("private_clinic_address");
            doctor.specialisation=resultSet.getString("specialization");
        }
mine.close();
        preparedStatement.close();
        connection.close();

    }catch(Exception e){
e.printStackTrace();
    }
    return doctor;
}






    public static void main(String[] args) {
        DoctorPanel doctorP=new DoctorPanel(null);
        doctors doctor=doctorP.doctor;


    }

}

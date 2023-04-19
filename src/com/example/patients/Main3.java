package com.example.patients;
import com.example.patients.Users;
public class Main3 {

    public static void main(String[] args) {
        // Create a new SignUp window
        SignUp signUpWindow = new SignUp(null);
        signUpWindow.setVisible(true);

        // Wait for the user to sign up or close the window
        while (signUpWindow.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



                }


            // Create a new NewLogin window
            NewLogin newLoginWindow = new NewLogin(null);
            newLoginWindow.setVisible(true);

            // Wait for the user to log in or close the window
            while (newLoginWindow.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Users use = new Users();

                if (use.getRole().equals("doctor")) {
                    // Create a new DoctorPanel window
                    DoctorPanel doctorPanelWindow = new DoctorPanel(null);
                    doctorPanelWindow.setVisible(true);

                    // Wait for the user to view appointments or close the window
                    while (doctorPanelWindow.isVisible()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (use.getRole().equals("patient")) {
                    // Create a new AppointmentBooking window
                    AppointmentBooking appointmentBookingWindow = new AppointmentBooking(null);
                    appointmentBookingWindow.setVisible(true);

                    // Wait for the user to book an appointment or close the window
                    while (appointmentBookingWindow.isVisible()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }

        }

    }
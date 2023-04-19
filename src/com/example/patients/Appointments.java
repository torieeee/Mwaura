package com.example.patients;

public class Appointments {
    public String appointment_id;

    public String doctor_id;
    public String patient_id;
    public String specialist;
    public String address;
    public String timing;
    public String DOA;
    public void Appointments(String appointment_id,String specialist,String doctor_id,String patient_id, String timing,String address,String DOA ){
        this.appointment_id=appointment_id;
        this.specialist=specialist;
        this.doctor_id=doctor_id;
        this.patient_id=patient_id;
        this.timing=timing;
        this.DOA=DOA;
        this.address=address;
    }

    public void setAppointment_id( String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public void setSpecialist(String specialist) {
        this.specialist=specialist;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setDOA(String DOA) {
        this.DOA = DOA;
    }

    public String getAddress() {
        return address;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String  getDoctor_id() {
        return doctor_id;
    }

    public String  getPatient_id() {
        return patient_id;
    }

    public String getDOA() {
        return DOA;
    }

    public String getTiming() {
        return timing;
    }
}

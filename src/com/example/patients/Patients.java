package com.example.patients;

public class Patients {
    private int patient_id;
    private int id;
    private String name;
    private int phone_no;
    private String gender;
    private String email;
    private String DOB;
    private String address;
    public void Patients(int patient_id,int id,String name,int phone_no,String gender,String email,String DOB,String address){
        this.patient_id=patient_id;
        this.id=id;
        this.name=name;
        this.phone_no=phone_no;
        this.gender=gender;
        this.email=email;
        this.DOB=DOB;
        this.address=address;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }
}

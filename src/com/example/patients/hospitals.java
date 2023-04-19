package com.example.patients;

public class hospitals {
    private String Hospital_id;
    private String hospital_name;
    private int no_of_doctors;
    private String location;
    private String specialist_available;
    private void hospitals(String Hospital_id, String hospital_name,int no_of_doctors,String location,String specialist_available){
    this.Hospital_id=Hospital_id;
    this.hospital_name=hospital_name;
    this.no_of_doctors=no_of_doctors;
    this.location=location;
    this.specialist_available=specialist_available;
    }

    public void setHospital_id(String hospital_id) {
        Hospital_id = hospital_id;
    }

    public String getHospital_id() {
        return Hospital_id;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setNo_of_doctors(int no_of_doctors) {
        this.no_of_doctors = no_of_doctors;
    }

    public int getNo_of_doctors() {
        return no_of_doctors;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setSpecialist_available(String specialist_available) {
        this.specialist_available = specialist_available;
    }

    public String getSpecialist_available() {
        return specialist_available;
    }
}

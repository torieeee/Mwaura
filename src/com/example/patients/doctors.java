package com.example.patients;

public class doctors {
    public String Medical_licence_no;
    public String id;
    public String name;
    public String hospital_address;
    public String private_clinic_address;
    public String specialisation;
    public void doctors(String Medical_licence_no,String id,String name,String hospital_address,String private_clinic_address,String specialisation){
        this.Medical_licence_no=Medical_licence_no;
        this.id=id;
        this.name=name;
        this.hospital_address=hospital_address;
        this.private_clinic_address=private_clinic_address;
        this.specialisation=specialisation;

    }

    public void setMedical_licence_no(String Medical_licence_no) {
        this.Medical_licence_no = Medical_licence_no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHospital_address(String hospital_address) {
        this.hospital_address = hospital_address;
    }

    public void setPrivate_clinic_address(String private_clinic_address) {
        this.private_clinic_address = private_clinic_address;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getMedical_licence_no() {
        return Medical_licence_no;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHospital_address() {
        return hospital_address;
    }

    public String getPrivate_clinic_address() {
        return private_clinic_address;
    }

    public String getSpecialisation() {
        return specialisation;
    }
}

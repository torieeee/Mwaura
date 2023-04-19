package com.example.patients;

public class Users {
    public String id;
    public String role;
    public String name;
    public String age;
    public String  phone_no;
    public String gender;
    public String address;
    public String email;
    public String password;
    public  void Users(String id,String name,String role, String age,String phone_no,String gender,String address,String email,String password){
        this.id=id;
        this.name=name;
        this.age=age;
        this.phone_no=phone_no;
        this.gender=gender;
        this.address=address;
        this.email=email;
        this.password=password;
        this.role=role;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String  getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}

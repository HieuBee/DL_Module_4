package com.exercise3.model;

public class Declaration {
    private String name;
    private int yearOfBirth;
    private String sex;
    private String nationality; /*Quốc tịch*/
    private String idCard;
    private String vehicle; /*Phương tiện*/
    private String vehicleNumber; /*Số hiệu phương tiện*/
    private int seats; /*Số ghế*/
    private String startDay;
    private String endDay;
    private String description;
    private String province; /*Tỉnh thành*/
    private String district;/*Quận huyện*/
    private String wards; /*Phuong xa*/
    private String address;
    private long phone;
    private String email;
    private String[] symptom;/*Triệu chứng*/
    private String[] history;

    public Declaration() {
    }

    public Declaration(String name, int yearOfBirth, String sex, String nationality, String idCard, String vehicle, String vehicleNumber, int seats, String startDay, String endDay, String description, String province, String district, String wards, String address, long phone, String email, String[] symptom, String[] history) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.description = description;
        this.province = province;
        this.district = district;
        this.wards = wards;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }
}

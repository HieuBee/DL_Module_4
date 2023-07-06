package com.vadidate.cs8validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;

public class UserDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    @Min(18)
    private int age;
    private String phoneNumber;
    private String email;
    private String nationality;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, int age, String phoneNumber, String email, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
//        Name
        if (userDto.getFirstName().isEmpty()) {
            errors.rejectValue("firstName",null,"Cannot be empty!");
        } else if (userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45){
            errors.rejectValue("firstName",null,"Required, minimum length 5, maximum 45 characters!");
        }

        if (userDto.getLastName().isEmpty()) {
            errors.rejectValue("lastName",null,"Cannot be empty!");
        } else if (userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45){
            errors.rejectValue("lastName",null,"Required, minimum length 5, maximum 45 characters!");
        }
//        phoneNumber
        if (userDto.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber",null,"Cannot be empty");
        } else if (userDto.getPhoneNumber().matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")){
            errors.rejectValue("phoneNumber",null,"Required, minimum length 5, maximum 45 characters!");
        }
//        Age
        if (!(userDto.getAge() >= 18)){
            errors.rejectValue("age",null,"Age must be greater than or equal to 18!");
        }
//        email
        if (userDto.getEmail().isEmpty()) {
            errors.rejectValue("email",null,"Cannot be empty");
        } else if (userDto.getPhoneNumber().matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")){
            errors.rejectValue("email",null,"Email must be in the correct format");
        }
    }
}

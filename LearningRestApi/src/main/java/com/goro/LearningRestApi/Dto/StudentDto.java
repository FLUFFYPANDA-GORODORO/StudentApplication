package com.goro.LearningRestApi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private int rollNo;

}

//  BoilerPlate Code is replaced by Lombok Annotation -> @Data

//    public StudentDto(long id, String name, String email, int rollNo) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.rollNo = rollNo;
//    }
//
//    public StudentDto() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getRollNo() {
//        return rollNo;
//    }
//
//    public void setRollNo(int rollNo) {
//        this.rollNo = rollNo;
//    }


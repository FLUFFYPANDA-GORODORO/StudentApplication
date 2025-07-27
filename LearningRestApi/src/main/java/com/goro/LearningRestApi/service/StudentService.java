package com.goro.LearningRestApi.service;

import com.goro.LearningRestApi.Dto.AddStudentDto;
import com.goro.LearningRestApi.Dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentDto addStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentDto addStudentDto);
}

package com.goro.LearningRestApi.controller;

import com.goro.LearningRestApi.Dto.AddStudentDto;
import com.goro.LearningRestApi.Dto.StudentDto;
import com.goro.LearningRestApi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentDto addStudentDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentDto));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id , @RequestBody AddStudentDto addStudentDto){
        return ResponseEntity.ok(studentService.updateStudent(id , addStudentDto));
    }
}

package com.goro.LearningRestApi.service.impl;

import com.goro.LearningRestApi.Dto.AddStudentDto;
import com.goro.LearningRestApi.Dto.StudentDto;
import com.goro.LearningRestApi.entity.Student;
import com.goro.LearningRestApi.repository.StudentRepository;
import com.goro.LearningRestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(student.getId() , student.getEmail() , student.getName() , student.getRollNo())).toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return modelMapper.map(student , StudentDto.class);
//        StudentDto studentDto = modelMapper.map(student , StudentDto.class);
//        return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentDto addStudentDto) {
        Student newStudent = modelMapper.map(addStudentDto , Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentDto addStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentDto , student);
        student = studentRepository.save(student);
        return modelMapper.map(student , StudentDto.class);
    }
}

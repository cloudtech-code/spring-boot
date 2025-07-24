package com.cloudtech.service;

import com.cloudtech.dto.StudentRequestDto;
import com.cloudtech.entity.Student;
import com.cloudtech.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentRequestDto dto) {
        Student student = new Student();

        student.setStudentName(dto.getStudentName());
        student.setMarks(dto.getMarks());
        student.setAddress(dto.getAddress());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    public Student updateStudent(StudentRequestDto dto, int studentId) {
        Student s = studentRepository.findById(studentId).get();

        s.setStudentName(dto.getStudentName());
        s.setAddress(dto.getAddress());
        s.setMarks(dto.getMarks());

        return studentRepository.save(s);
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student Deleted Successfully";
    }

}

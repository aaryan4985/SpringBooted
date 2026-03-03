package com.aaryan.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Transactional
    public StudentDTO saveStudent(StudentDTO dto) {

        Student student = new Student(dto.getName(), dto.getAge());

        Student saved = studentRepository.save(student);

        return new StudentDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge());
    }
}
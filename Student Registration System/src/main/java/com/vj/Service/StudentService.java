package com.vj.Service;


import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.vj.Repository.StudentRepository;
import com.vj.exception.ResourceNotFoundException;
import com.vj.model.Student;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student create(Student student) {
        normalize(student);
        student.setId(null); // a client-sent id must never overwrite an existing row
        return repository.saveAndFlush(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id"))).getContent();
    }

    @Transactional(readOnly = true)
    public Student getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @Transactional
    public Student update(long id, Student incoming) {
        normalize(incoming);
        Student existing = getById(id);
        existing.setFirstName(incoming.getFirstName());
        existing.setLastName(incoming.getLastName());
        existing.setEmail(incoming.getEmail());
        existing.setPhone(incoming.getPhone());
        existing.setDateOfBirth(incoming.getDateOfBirth());
        existing.setCourse(incoming.getCourse());
        return repository.saveAndFlush(existing);
    }

    @Transactional
    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        repository.deleteById(id);
    }

    private void normalize(Student s) {
        s.setFirstName(s.getFirstName().trim());
        s.setLastName(s.getLastName().trim());
        s.setEmail(s.getEmail().trim().toLowerCase());
        s.setCourse(s.getCourse().trim());
    }
}

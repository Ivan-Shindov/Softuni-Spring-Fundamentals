package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
    private StudentRepository studentRepository;
    private Long dbSize = 0L;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Cacheable(value = "students")
    public List<Student> findAllStudents() {

        // some task which is very time-consuming
        LOGGER.info("complicated stuff, need more time for doing this...");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Thread.interrupted();
        }

        List<Student> all = studentRepository.findAll();

        LOGGER.info("complication finish");

        return all;
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    @Scheduled(cron = "1 * * * * MON-FRI")
    public void cleanCache() {
        LOGGER.info("CLEANING CACHE !!!");
    }

    public void initializeStudents() {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setId(1L).setName("Pesho").setAge(12);
        student2.setId(2L).setName("Pesho2").setAge(123);

        studentRepository.saveAll(List.of(student1,student2));
    }
}

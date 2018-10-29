package com.kotlin.demo.deomapplications.service

import com.kotlin.demo.deomapplications.domain.Student
import com.kotlin.demo.deomapplications.domain.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

/**
 * @author devagoud
 */

interface StudentService {

    fun register(student: Student): Student
    fun deleteStudent(id: String): String
    fun updateStudent(student: Student): Student
    fun getDetails(): List<Student>
    fun getStudent(id: String): Optional<Student>
}

@Service
@Transactional

class StudentServiceImpl(@Autowired var studentRepository: StudentRepository) : StudentService {
    override fun getStudent(id: String): Optional<Student> = studentRepository.findById(id)
    override fun getDetails(): List<Student> = studentRepository.findAll()

    override fun deleteStudent(id: String): String {
        studentRepository.deleteById(id)
        return "deleted successfuly"
    }

    override fun updateStudent(student: Student): Student = studentRepository.save(student)



    override fun register(student: Student): Student {

        return studentRepository.save(student)}
}
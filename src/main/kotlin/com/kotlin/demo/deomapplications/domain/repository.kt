package com.kotlin.demo.deomapplications.domain

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

/**
 * @author devagoud
 */
@Transactional(Transactional.TxType.MANDATORY)
interface StudentRepository:JpaRepository<Student,String> {
    //fun update(student: Student): Student
}
package com.kotlin.demo.deomapplications.controller

import com.kotlin.demo.deomapplications.domain.Student
import com.kotlin.demo.deomapplications.service.StudentService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

/**
 * @author devagoud
 */

@RestController
@Slf4j
class controller(@Autowired var studentService :StudentService) {
    @PostMapping("register")
    @ResponseBody
    fun register(@RequestBody student: Student):Student=studentService.register(student)
    @DeleteMapping("deleted/{id}")
    fun deleteStudent(@PathVariable(value = "id") id:String):String=studentService.deleteStudent(id)
    @PutMapping("update")
    fun updateStudent(@RequestBody student: Student)=studentService.updateStudent(student)
    @GetMapping("getdetails")
    @ResponseBody
    fun getDetails()=studentService.getDetails()
    @GetMapping("getstudent/{id}")
    @ResponseBody
    fun getStudent(@PathVariable("id") id:String)=studentService.getStudent(id)
}




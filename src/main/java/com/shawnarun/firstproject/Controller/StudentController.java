package com.shawnarun.firstproject.Controller;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.Service.StudentService;
import com.shawnarun.firstproject.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(path = "/save")
    private ResponseEntity<StandardResponse> userDetails(
            @RequestBody RequestStudentDTO dto
            ){
        return new ResponseEntity<>(new StandardResponse(
                "Data Received",
                200,
               studentService.saveStudent(dto)
        ),
                HttpStatus.OK);
    }


    @GetMapping("/get-all")
    private ResponseEntity<StandardResponse> getStudentDetails(){
        return new ResponseEntity<>(new StandardResponse(
                "Data Fetched",
                200,
                studentService.getAllStudents()
        ),HttpStatus.OK);
    }



}

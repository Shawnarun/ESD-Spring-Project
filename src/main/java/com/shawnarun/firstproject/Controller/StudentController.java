package com.shawnarun.firstproject.Controller;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.Service.StudentService;
import com.shawnarun.firstproject.Util.StandardResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);


    @PostMapping(path = "/save")
    private ResponseEntity<StandardResponse> userDetails(
            @RequestBody RequestStudentDTO dto
            ){

        LOGGER.info("API Request Received");

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


    @GetMapping(path = "/get-by-id/{id}")
    private ResponseEntity<StandardResponse> getById(
            @PathVariable long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Student Record Fetched",
                200,
                studentService.getById(id)
        ),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-paginated", params = {"size","page"})
        private ResponseEntity<StandardResponse> getAllPaginated(
        @RequestParam int size,
        @RequestParam int page

){
        return new ResponseEntity<>(new StandardResponse(
                "Fetched All Paginated Resposne",
                200,
                studentService.getPaginated(size,page)
        ),HttpStatus.OK);
}

    @GetMapping(path = "/get-all-search", params = {"size","page","searchText"})
    private ResponseEntity<StandardResponse> getAllBySearchText(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam String searchText

    ){
        return new ResponseEntity<>(new StandardResponse(
                "Fetched All Paginated Response BY Search",
                200,
                studentService.getAllBySearch(size,page,searchText)
        ),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-age", params = {"size","page","age"})
    private ResponseEntity<StandardResponse> getAllByAge(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam int age

    ){
        return new ResponseEntity<>(new StandardResponse(
                "Fetched All Paginated Response BY Age",
                200,
                studentService.getAllByAge(size,page,age)
        ),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-age-with-search", params = {"size","page","age","searchText"})
    private ResponseEntity<StandardResponse> getAllByAgeAndSearchText(
            @RequestParam int size,
            @RequestParam int page,
            @RequestParam int age,
            @RequestParam String searchText

    ){
        return new ResponseEntity<>(new StandardResponse(
                "Fetched All Paginated Response",
                200,
                studentService.getAllByAgeAndSearch(size,page,age,searchText)
        ),HttpStatus.OK);
    }


 @DeleteMapping(path = "/delete/{id}")
private ResponseEntity<StandardResponse> deleteStudent(
        @PathVariable long id
 ){
        return new ResponseEntity<>(new StandardResponse(
                "Record Deleted",
                204,
                studentService.deleteStudent(id)
        ),HttpStatus.OK);
}


    //GET -> Fetched data
    //PUT -> Update data
    //POST -> Save data
    //DELETE -> Delete data

    @PutMapping(path = "/update/{id}")
    private ResponseEntity<StandardResponse> updateStudent(
            @RequestBody RequestStudentDTO dto,
            @PathVariable long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Data Updates",
                200,
                studentService.updateStudent(dto , id)
        ),
                HttpStatus.OK);
    }
}

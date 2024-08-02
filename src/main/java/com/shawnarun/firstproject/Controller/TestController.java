package com.shawnarun.firstproject.Controller;


import com.shawnarun.firstproject.Service.TestService;
import com.shawnarun.firstproject.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https:localhost:8080/api/v1/test/message-1
@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {

@Autowired
private TestService t1;

@GetMapping(path = "/message")
private ResponseEntity<StandardResponse> message(){

    String data = t1.getMessage();

    return new ResponseEntity<>(new StandardResponse(
            "Successfully API Worked",
            200,
            data
    ),HttpStatus.OK);


}





}

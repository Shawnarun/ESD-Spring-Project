package com.shawnarun.firstproject.Service;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.DTO.ResponseDTO.ResponseStudentDTO;

import java.util.List;

public interface StudentService {

     String saveStudent(RequestStudentDTO dto);

     List<ResponseStudentDTO> getAllStudents();
}

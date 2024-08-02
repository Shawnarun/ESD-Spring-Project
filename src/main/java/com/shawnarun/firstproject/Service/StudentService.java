package com.shawnarun.firstproject.Service;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.DTO.ResponseDTO.ResponseStudentDTO;

public interface StudentService {

     ResponseStudentDTO getStudent(RequestStudentDTO dto);
}

package com.shawnarun.firstproject.Service.Impl;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.DTO.ResponseDTO.ResponseStudentDTO;
import com.shawnarun.firstproject.Service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    public ResponseStudentDTO getStudent(RequestStudentDTO dto) {
        return new ResponseStudentDTO(
                dto.getFullName(),
                dto.getAge(),
                dto.getNic()
        );
    }
}

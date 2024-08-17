package com.shawnarun.firstproject.Service;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.DTO.ResponseDTO.ResponseStudentDTO;

import java.util.List;

public interface StudentService {

     String saveStudent(RequestStudentDTO dto);

     List<ResponseStudentDTO> getAllStudents();

     String deleteStudent(long id);

     String updateStudent(RequestStudentDTO dto, long id);

     ResponseStudentDTO getById(long id);

     List<ResponseStudentDTO> getPaginated(int size, int page);

     List<ResponseStudentDTO> getAllBySearch(int size, int page, String searchText);

     List<ResponseStudentDTO> getAllByAge(int size, int page, int age);

     List<ResponseStudentDTO> getAllByAgeAndSearch(int size, int page, int age, String searchText);
}

package com.shawnarun.firstproject.Service.Impl;

import com.shawnarun.firstproject.DTO.RequestDTO.RequestStudentDTO;
import com.shawnarun.firstproject.DTO.ResponseDTO.ResponseStudentDTO;
import com.shawnarun.firstproject.Entity.Student;
import com.shawnarun.firstproject.Repo.StudentRepo;
import com.shawnarun.firstproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String saveStudent(RequestStudentDTO dto) {

        Student student = new Student(
                dto.getFullName(),
                dto.getNic(),
                dto.getAge()
        );

        studentRepo.save(student);

        return dto.getFullName();
    }


    public List<ResponseStudentDTO> getAllStudents() {
        ArrayList<ResponseStudentDTO> arrayList = new ArrayList<>();

        List<Student> students = studentRepo.findAll();

        for (Student s : students){
              arrayList.add(
                      new ResponseStudentDTO(
                             s.getName(),
                             s.getAge(),
                             s.getNic()
                      )
              );
        }


        return arrayList;
    }


    public String deleteStudent(long id) {

        Optional<Student> student = studentRepo.findById(id);

        if(student.isEmpty()){
            throw new RuntimeException("Student Doesnt Exist");
        }

        studentRepo.delete(student.get());
        return student.get().getName();
    }

    @Override
    public String updateStudent(RequestStudentDTO dto, long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student Doesnt Exist");
        }

        student.get().setName(dto.getFullName());
        student.get().setAge(dto.getAge());
        student.get().setNic(dto.getNic());

        studentRepo.save(student.get());
        return dto.getFullName();
    }
}

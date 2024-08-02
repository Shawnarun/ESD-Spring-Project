package com.shawnarun.firstproject.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudentDTO {
    private String fullName;
    private String age;
    private String nic;
}

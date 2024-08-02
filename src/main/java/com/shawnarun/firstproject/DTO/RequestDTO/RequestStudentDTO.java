package com.shawnarun.firstproject.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudentDTO {
    private String fullName;
    private String age;
    private String nic;
}

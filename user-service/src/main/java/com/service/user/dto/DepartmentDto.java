package com.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Integer id;
    private String name;
    private String address;
    private String pinCode;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}

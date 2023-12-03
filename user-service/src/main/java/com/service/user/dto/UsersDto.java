package com.service.user.dto;

import com.service.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer departmentId;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private DepartmentDto department;

    public UsersDto(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.departmentId = user.getDepartmentId();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }
}

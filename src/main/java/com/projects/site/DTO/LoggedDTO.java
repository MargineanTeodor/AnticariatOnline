package com.projects.site.DTO;
import com.projects.site.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoggedDTO {
    private Long id;
    private Long userID;
    private String action;
}

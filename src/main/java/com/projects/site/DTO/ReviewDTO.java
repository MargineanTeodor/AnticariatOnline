package com.projects.site.DTO;
import com.projects.site.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {
    private long id;
    private String review;
    private long idCarte;
}

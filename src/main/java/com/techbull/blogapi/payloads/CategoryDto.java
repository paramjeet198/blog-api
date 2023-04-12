package com.techbull.blogapi.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDto {


    private int id;

    @NotBlank
    @Size(min = 3, max = 12, message = "Title must be min of 3 and max of 12 characters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Description must be min of 10 characters")
    private String categoryDescription;

}

package com.techbull.blogapi.payloads;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class UserDto {

    private long id;

    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @Email(message = "Email is not valid!!")
    private String email;


    @Size(min = 6, message = "Password must be min of 6 characters")
    private String password;

    @NotEmpty
    private String about;

}

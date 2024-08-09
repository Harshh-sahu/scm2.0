package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Minimum 3 Character Is required")
    private String name;
    @Email(message = "Invalid email Address")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "Password Is required")
    @Size(min = 6, message = "Min 6character are required")
    private String password;
    @NotBlank(message = "about is required")
    private String about;
    @Size(min = 8, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;

}

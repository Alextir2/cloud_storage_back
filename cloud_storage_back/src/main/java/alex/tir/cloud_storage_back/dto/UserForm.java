package alex.tir.cloud_storage_back.dto;


import alex.tir.cloud_storage_back.validation.ValidPassword;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class UserForm {
    @Size(min = 1, max = 255)
    private String firstName;

    @Size(min = 1, max = 255)
    private String lastName;

    @Email
    private String email;

    @ValidPassword
    private String password;
}

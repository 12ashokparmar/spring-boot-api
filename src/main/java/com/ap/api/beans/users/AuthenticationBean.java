package com.ap.api.beans.users;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Validated
public class AuthenticationBean implements Serializable {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;
   // private Integer unitId;

}

package ma.youcode.marjanepromotion2.Controllers.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.marjanepromotion2.Enums.Access;
import ma.youcode.marjanepromotion2.Enums.Gender;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Size(min = 5, max = 50, message = "Name should be min 5 to 50 characters")
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    private String password;

//    @NotBlank(message = "Access cannot be blank")
    @NotNull(message = "Access cannot be null")
    private Access access;

//    @NotBlank(message = "Gender cannot be blank")
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
}

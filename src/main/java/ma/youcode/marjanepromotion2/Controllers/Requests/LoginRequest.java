package ma.youcode.marjanepromotion2.Controllers.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be Null")
    private String email;
    @NotBlank(message = "Password cannot be Blank")
    @NotNull(message = "Password cannot be Null")
    private String password;
}

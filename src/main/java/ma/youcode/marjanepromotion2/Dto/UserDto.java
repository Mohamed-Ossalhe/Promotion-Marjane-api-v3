package ma.youcode.marjanepromotion2.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ma.youcode.marjanepromotion2.Entities.User;
import ma.youcode.marjanepromotion2.Enums.Access;
import ma.youcode.marjanepromotion2.Enums.Gender;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDto {
    @Size(min = 5, max = 50, message = "Name should be min 5 to 50 characters")
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "/^[a-zA-Z]{5,50}$/")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be null")
    @Pattern(regexp = "/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$/")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()\\[\\]{}\\-_+=~`|:;\\\"'<>,./?])(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;

//    @Convert(converter = Access.AccessConverter.class)
//    @NotBlank(message = "Access cannot be blank")
    @NotNull(message = "Access cannot be null")
    @NotEmpty(message = "Access cannot be empty")
    private Access access;

//    @Convert(converter = Gender.AccessConverter.class)
//    @NotBlank(message = "Gender cannot be blank")
    @NotNull(message = "Gender cannot be null")
    @NotEmpty(message = "Gender cannot be empty")
    private Gender gender;

    public User toModel() {
        User userEntity = new User();
        userEntity.setName(getName());
        userEntity.setEmail(getEmail());
        userEntity.setPassword(getPassword());
        userEntity.setAccess(getAccess());
        userEntity.setGender(getGender());

        return userEntity;
    }
}

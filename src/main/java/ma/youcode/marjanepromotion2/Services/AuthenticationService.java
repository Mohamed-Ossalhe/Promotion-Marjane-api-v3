package ma.youcode.marjanepromotion2.Services;

import lombok.RequiredArgsConstructor;
import ma.youcode.marjanepromotion2.Controllers.Requests.LoginRequest;
import ma.youcode.marjanepromotion2.Controllers.Requests.RegisterRequest;
import ma.youcode.marjanepromotion2.Controllers.Responses.AuthenticationResponse;
import ma.youcode.marjanepromotion2.Dto.UserDto;
import ma.youcode.marjanepromotion2.Security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        UserDto user = new UserDto(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getAccess(),
                request.getGender()
        );
        userService.register(user);
        var jwtToken = jwtService.generateToken(user.toModel());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(LoginRequest request) {
        Logger.getLogger(getClass().getName()).log(Level.INFO, request.toString());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.findUserByEmail(request.getEmail());
        Logger.getLogger(getClass().getName()).log(Level.INFO, user.toString());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

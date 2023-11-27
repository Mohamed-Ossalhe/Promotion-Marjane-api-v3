package ma.youcode.marjanepromotion2.Controllers.Auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.marjanepromotion2.Controllers.Requests.LoginRequest;
import ma.youcode.marjanepromotion2.Controllers.Requests.RegisterRequest;
import ma.youcode.marjanepromotion2.Controllers.Responses.AuthenticationResponse;
import ma.youcode.marjanepromotion2.Services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) throws Exception {
//        return ResponseEntity.ok(request);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

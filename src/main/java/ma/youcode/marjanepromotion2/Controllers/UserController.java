package ma.youcode.marjanepromotion2.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.marjanepromotion2.Controllers.Requests.RegisterRequest;
import ma.youcode.marjanepromotion2.Entities.User;
import ma.youcode.marjanepromotion2.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/super-admin/create-admin")
    public ResponseEntity<User> addAdmin(@Valid @RequestBody RegisterRequest request) throws Exception {
        return ResponseEntity.ok(userService.addAdmin(request));
    }
}

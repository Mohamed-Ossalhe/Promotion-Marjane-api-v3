package ma.youcode.marjanepromotion2.Services;

import lombok.RequiredArgsConstructor;
import ma.youcode.marjanepromotion2.Controllers.Requests.RegisterRequest;
import ma.youcode.marjanepromotion2.Dto.UserDto;
import ma.youcode.marjanepromotion2.Entities.User;
import ma.youcode.marjanepromotion2.Enums.Access;
import ma.youcode.marjanepromotion2.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void register(UserDto user) throws Exception {
        saveUser(user);
    }

    public User saveUser(UserDto user) throws Exception {
        Map<String, String> userExist = isAlreadyExist(user);
        if (!userExist.isEmpty())
            throw new Exception("User already Exists: " + String.valueOf(user));
        User newUser = userRepository.save(user.toModel());
        assert newUser != null;
        if (newUser.getId() == null)
            throw new Exception("Could not create User");
        return newUser;
    }

    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.orElse(null);
    }

    private Map<String, String> isAlreadyExist(UserDto user) {
        Map<String, String> matches = new HashMap<String, String>();
        Optional<User> existEmail = userRepository.findUserByEmail(user.getEmail());
        if (existEmail.isPresent()) {
            matches.put("Email", "Email already exist");
        }
        return matches;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addAdmin(RegisterRequest request) throws Exception {
        UserDto user = new UserDto(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Access.ADMINISTRATOR,
                request.getGender()
        );
        return saveUser(user);
    }
}

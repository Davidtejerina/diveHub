package alexDavid.service;

import alexDavid.Auth.SignupRequest;
import alexDavid.models.User.Role;
import alexDavid.models.User.User;
import alexDavid.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Primary
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }

    public User loadUserByUserEmail(String email){
        return userDetailsRepository.findByEmail(email);
    }
    public User save(User user) {
        return userDetailsRepository.save(user);
    }

    public User updateUser(String email, User user) {

        User userUpdated = (User) this.loadUserByUsername(email);
        userUpdated.setName(user.getName());
        userUpdated.setSurnames(user.getSurnames());
        userDetailsRepository.save(userUpdated);
        return userUpdated;
    }


    public User create(SignupRequest signupRequest){
        User user = new User(
                null,
                signupRequest.getNickname(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getName(),
                signupRequest.getSurnames(),
                signupRequest.getEmail(),
                signupRequest.getBirthday(),
                signupRequest.getAddress(),
                null,
                LocalDateTime.now(),
                LocalDateTime.now(),
                Role.USER
        );
        return this.save(user);
    }


}
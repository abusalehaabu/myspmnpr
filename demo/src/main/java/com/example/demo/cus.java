/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Your own classes
import com.example.demo;
import your.package.name.UsRepository;
import your.package.name.us;

@Service
public class cus implements UserDetailsService {

    @Autowired
    private UsRepository usRepository;  // Assuming usRepository is where you store users
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        us user = usRepository.findByemail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getEmail())
                .password(user.getPassword())  // Ensure this is the hashed password
                .roles("USER")  // Set roles as needed
                .build();
    }
}*/

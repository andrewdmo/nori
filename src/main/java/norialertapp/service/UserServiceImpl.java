package norialertapp.service;
import norialertapp.entity.Users;
import norialertapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by katherine_celeste on 10/8/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    @Autowired
//    private EmailSenderService  emailSenderService;

    @Override
    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void saveUser(Users user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setEmailVerfiy(false);
//        Users savedUser =
                userRepo.save(user);
//
//        String encryptedUserId = EncryptDecryptUtils.encrypt(String.valueOf(savedUser.getId()));
//        // send email to user activate his account
//        String verifyEmailLink = Constants.ROOT_URL + "activate" + "?token=" + encryptedUserId;
//        emailSenderService.sendRegistrationSuccessEmail(user.getFirstname(), user.getEmail(), verifyEmailLink, Constants.ROOT_URL);
    }

    public boolean passwordMatch(String password, String dbPassword){
        return passwordEncoder.matches(password, dbPassword);
    }
}

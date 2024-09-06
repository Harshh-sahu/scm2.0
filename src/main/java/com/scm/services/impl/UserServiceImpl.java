package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helper.AppConstants;
import com.scm.helper.Helper;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.EmailService;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // set the user role

        user.setRoleList(List.of(AppConstants.ROLE_USER));

        String emailToken = UUID.randomUUID().toString();
        user.setEmailToken(emailToken);
        User savedUser = userRepo.save(user);

        String emailLink = Helper.getLinkedForEmailVerification(emailToken);

        // emailService.sendEmail(savedUser.getEmail(), "Verify Account : smart COntact Manager", emailLink);

        String htmlBody = "<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<style>" +
                "body { font-family: 'Arial', sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; color: #333; }"
                +
                ".container { max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
                +
                "h1 { color: #4CAF50; font-size: 24px; margin-bottom: 20px; text-align: center; }" +
                "p { font-size: 16px; line-height: 1.6; margin-bottom: 20px; }" +
                ".btn { display: block; width: 200px; text-align: center; background-color: #4CAF50; color: white; padding: 12px 0; text-decoration: none; border-radius: 5px; font-size: 18px; margin: 0 auto; }"
                +
                ".footer { margin-top: 20px; text-align: center; font-size: 14px; color: #888; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Welcome to Smart Contact Manager!</h1>" +
                "<p>Hello Customer,</p>" + // You can replace this with dynamic name
                "<p>We are excited to have you on board. Your email has been successfully verified, and your Smart Contact Manager account is now activated.</p>"
                +
                "<p>Click the button below to get started:</p>" +
                "<a href='" + emailLink + "' class='btn'>Login Now</a>" + // Dynamic link here
                "<p>If you encounter any issues, feel free to reach out to our support team.</p>" +
                "<p>Thank you for choosing Smart Contact Manager.</p>" +
                "<div class='footer'>" +
                "<p>Smart Contact Manager Team</p>" +
                "<p>&copy; 2024 Smart Contact Manager</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
        emailService.sendEmailWithHtml(savedUser.getEmail(), "Welcome to Smart Contact Manager!", htmlBody);

        return savedUser;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not Found !"));

        // update kro user ko
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not Found !"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElse(null);

    }
}

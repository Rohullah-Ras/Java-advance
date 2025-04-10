package nl.sibrenrocva.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.sibrenrocva.demo.model.User;
import nl.sibrenrocva.demo.repository.UserRepository;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogItemService logItemService;

    public boolean authenticateUser(User inputUser) {
        String username = inputUser.getUsername();
        String password = inputUser.getPassword();

        // Stap 1: Zoek gebruiker op
        User dbUser = userRepository.findByUsername(username);
        if (dbUser == null) {
            logItemService.log("warning", "Gebruiker niet gevonden: " + username);
            return false;
        }

        // Stap 2: Vergelijk wachtwoord
        String hashedPassword = hashPassword(password, Base64.getDecoder().decode(dbUser.getSalt()));
        if (!hashedPassword.equals(dbUser.getPassword())) {
            logItemService.log("warning", "Fout wachtwoord voor gebruiker: " + username);
            return false;
        }

        return true; // Inloggen gelukt
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public boolean validatePassword(String password, String storedHash, byte[] salt) {
        String hashedPassword = hashPassword(password, salt);
        return hashedPassword.equals(storedHash);
    }
}
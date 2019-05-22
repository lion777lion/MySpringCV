package com.lion.cv.security;
import com.lion.cv.DataFiles.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String email;
  
  public UserEntity toUser(PasswordEncoder passwordEncoder) {
    return new UserEntity(username, passwordEncoder.encode(password), email);
  }
  
}

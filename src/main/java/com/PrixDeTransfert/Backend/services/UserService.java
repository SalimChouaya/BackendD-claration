package com.PrixDeTransfert.Backend.services;
 
 
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;


 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.PrixDeTransfert.Backend.dto.CredentialsDto;
import com.PrixDeTransfert.Backend.dto.SignUpDto;
import com.PrixDeTransfert.Backend.dto.UserDto;
import com.PrixDeTransfert.Backend.exceptions.AppException;
import com.PrixDeTransfert.Backend.mappers.UserMapper;
import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.repositories.userRepository;

import jakarta.transaction.Transactional;
 

@RequiredArgsConstructor
@Service

public class UserService {
 	@Autowired
    private final userRepository userRepository;
 	@Autowired
    private final PasswordEncoder passwordEncoder;
 	@Autowired
    private final UserMapper userMapper;
 
	public UserDto login(CredentialsDto credentialsDto) {
    User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}
package com.PrixDeTransfert.Backend.controllers;
 



import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.config.UserAuthenticationProvider;
import com.PrixDeTransfert.Backend.dto.CredentialsDto;
import com.PrixDeTransfert.Backend.dto.SignUpDto;
import com.PrixDeTransfert.Backend.dto.UserDto;
import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@RestController
public class userController {
	
	 	@Autowired
	 	private final UserService userService ;
	 	@Autowired
	    private  final  UserAuthenticationProvider userAuthenticationProvider;
	 	
   public static Long iduser;
		@PostMapping("/login")
	    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto, HttpServletResponse response,HttpSession session) {
	       
			UserDto userDto = userService.login(credentialsDto);
	        userDto.setToken(userAuthenticationProvider.createToken(userDto));
	        Cookie cookie = new Cookie("token", userDto.getToken());
	        cookie.setPath("/");
	        cookie.setMaxAge(3600); // set cookie expiration time in seconds, adjust as needed
	        response.addCookie(cookie);
	        iduser=userDto.getId();
	        System.out.println("La valeur de la variable est : " + iduser);
			/* session.setAttribute("iduser", userDto.getId()); */
	        
	        return ResponseEntity.ok(userDto);
	    }

	    @PostMapping("/register")
	    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user,HttpSession session) {
	        UserDto createdUser = userService.register(user);
	        session.setAttribute("iduser", createdUser.getId());
	        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
	        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
	    }
	    
	    
	    @GetMapping("/test")
	    public String test() {
	    	return "test valid ";
	    }

}


 


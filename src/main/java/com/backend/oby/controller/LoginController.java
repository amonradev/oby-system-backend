package com.backend.oby.controller;

import com.backend.oby.entity.Clients;
import com.backend.oby.entity.User;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.services.ClientsService;
import com.backend.oby.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public String login(@RequestBody User user) {
       return  this.userService.verifyLogin(user);
    }
}

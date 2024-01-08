package com.own.api.controller;

import com.own.api.dto.Entry.ProductEntryDTO;
import com.own.api.dto.Entry.UserEntryDTO;
import com.own.api.dto.Modify.ProductModifyDTO;
import com.own.api.dto.Modify.UserModifyDTO;
import com.own.api.dto.Out.ProductOutDTO;
import com.own.api.dto.Out.UserOutDTO;
import com.own.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Controller
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserOutDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutDTO> getUserForId(@PathVariable Long id){
        return new ResponseEntity<>(userService.searchForId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserOutDTO> putUser(@RequestBody UserModifyDTO user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserOutDTO> postUser(@RequestBody UserEntryDTO user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>("User with id " + id + " eliminated", HttpStatus.NO_CONTENT);
    }


}

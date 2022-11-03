package org.example.jpa.jpademo.controller;

import org.example.jpa.jpademo.domain.User;
import org.example.jpa.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userdetails/app/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //http://localhost:8080/userdetails/app/users
    @PostMapping("/user")
    public ResponseEntity<?> insertUser(@RequestBody User user){

        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUserDetails(){
        return new ResponseEntity<>(userService.gerAllUser(),HttpStatus.FOUND);
    }
    //http://localhost:8080/userdetails/app/user/kumar@mail.com
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> fetchByName(@PathVariable String userName){
        return new ResponseEntity<>(userService.getUserByName(userName),HttpStatus.FOUND);
    }

    //http://localhost:8080/userdetails/app/user/kumar@mail.com
    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String email){
        return new ResponseEntity<>(userService.updateUser(user,email),HttpStatus.OK);
    }

}

package com.nedacort.challengespringbackend.web.controller;

//import com.nedacort.challengespringbackend.domain.UserDto;
//import com.nedacort.challengespringbackend.domain.dto.AuthenticationResponse;
//import com.nedacort.challengespringbackend.domain.service.UserDetailService;
//import com.nedacort.challengespringbackend.web.security.JWTUtil;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailService userDetailService;
//
//    @Autowired
//    private JWTUtil jwtUtil;
//
////    @PostMapping("/login")
////    @ApiOperation(value = "Inicio de Sesion generando JWT")
////    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody UserDto request) {
////        try {
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
////                    (request.getUsername(), request.getPassword()));
////            UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
////            String jwt = jwtUtil.generateToken(userDetails);
////            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
////        } catch (BadCredentialsException e) {
////            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
////        }
////    }
//
////    @PostMapping("/register")
////    @ApiOperation(value = "Creacion de un Usuario")
////    @ApiResponses(value = {@ApiResponse(code = 201, message = "Usuario Creado"),
////            @ApiResponse(code = 400, message = "peticion invalida")})
////    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
////        return new ResponseEntity<>(userDetailService.save(userDto), HttpStatus.CREATED);
////    }
//
//
//}

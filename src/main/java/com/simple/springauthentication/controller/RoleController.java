package com.simple.springauthentication.controller;

import com.simple.springauthentication.domain.Role;
import com.simple.springauthentication.dto.request.AddRoleToUserDTO;
import com.simple.springauthentication.dto.request.RoleRequestDTO;
import com.simple.springauthentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Role> saveRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/create").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roleRequestDTO));
    }

    @PostMapping("/assign")
    public ResponseEntity<Role> saveRole(@RequestBody AddRoleToUserDTO addRoleToUserDTO) {
        userService.addRoleToUser(addRoleToUserDTO.getUserName(), addRoleToUserDTO.getRoleName());
        return ResponseEntity.ok().build();
    }

}

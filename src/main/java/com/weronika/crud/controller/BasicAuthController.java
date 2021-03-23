/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weronika.crud.controller;
import com.weronika.crud.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
}

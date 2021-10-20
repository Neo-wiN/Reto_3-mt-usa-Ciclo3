package com.boat.controller;

import com.boat.model.Admin;
import com.boat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController //es esencialmente una combinación de @Controller y @ResponseBody .
@RequestMapping("/Admin") //Controlador que nos redirecciona  a un conjunto de  formularios 
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return adminService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }
}

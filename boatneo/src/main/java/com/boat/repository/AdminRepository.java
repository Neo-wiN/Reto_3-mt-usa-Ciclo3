package com.boat.repository;

import com.boat.model.Admin;
import com.boat.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Es el package que contiene las interfaces que extienden de JPA para que estas clases se conecten a la base de datos
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
}

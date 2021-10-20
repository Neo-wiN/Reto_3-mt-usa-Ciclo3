package com.boat.service;

import com.boat.model.Boat;
import com.boat.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service  // se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea 
public class BoatService {

    @Autowired  //se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring 
    private BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boat) {
        if (boat.getId() == null) {
            return boatRepository.save(boat);
        } else {
            Optional<Boat> e = boatRepository.getBoat(boat.getId());
            if (e.isEmpty()) {
                return boatRepository.save(boat);
            } else {
                return boat;
            }
        }
    }
}

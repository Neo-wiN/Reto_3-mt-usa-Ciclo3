package com.boat.repository;

import com.boat.model.Message;
import com.boat.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Es el package que contiene las interfaces que extienden de JPA para que estas clases se conecten a la base de datos
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
}

package com.boat.service;

import com.boat.model.Message;
import com.boat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  // se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea 
public class MessageService {

    @Autowired  //se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring 
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
}

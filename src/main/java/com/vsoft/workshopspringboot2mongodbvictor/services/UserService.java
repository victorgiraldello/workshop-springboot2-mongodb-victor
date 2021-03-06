package com.vsoft.workshopspringboot2mongodbvictor.services;

import com.vsoft.workshopspringboot2mongodbvictor.domain.User;
import com.vsoft.workshopspringboot2mongodbvictor.dto.UserDTO;
import com.vsoft.workshopspringboot2mongodbvictor.repository.UserRepository;
import com.vsoft.workshopspringboot2mongodbvictor.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newObj = repo.findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User obj) {
        newObj.get().setName(obj.getName());
        newObj.get().setEmail(obj.getEmail());
    }
}

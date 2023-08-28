package com.projectAlura.picpay.services;

import com.projectAlura.picpay.domain.user.User;
import com.projectAlura.picpay.domain.user.UserType;
import com.projectAlura.picpay.dtos.UserDTO;
import com.projectAlura.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo logista não está autorizado a realizar transação");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser((newUser));
        return newUser;
    }

    public List<User> getAllUser(){
        return this.repository.findAll();
    }


    public void saveUser(User user){
        this.repository.save(user);
    }
}

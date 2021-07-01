package com.accessor.backendtest.service;

import com.accessor.backendtest.error.UserNotFoundException;
import com.accessor.backendtest.model.User;
import com.accessor.backendtest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    //Nutzer erstellen
    @Override
    public User saveUser(User user) {
        user.setTime(new Date());
        return userRepo.save(user);
    }

    //Alle Nutzer ausgeben
    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    //Bestimmten Nutzer ausgeben
    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) throw new UserNotFoundException("User Not Available");
        return user.get();
    }

    //Bestimmten Nutzer löschen
    @Override
    public String deleteUserById(Long id) {
        userRepo.deleteById(id);
        return "Department successfully deleted!";
    }

    //Bestimmten Nutzer aktualisieren
    @Override
    public User updateUser(Long id, User user) {
        User updatedUser = user;
        if (userRepo.findById(id).isPresent()) updatedUser = userRepo.findById(id).get();
        //Die Bedingungen: Die Felder sollten nicht leer oder null sein. Sollte ein Feld nicht angegeben werden, sollte
        //der Wert unverändert bleiben.
        //Vorname
        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName()))
            updatedUser.setFirstName(user.getFirstName());
        //Nachname
        if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName()))
            updatedUser.setFirstName(user.getLastName());
        //Adresse
        if(Objects.nonNull((user.getAddress())) && "".equalsIgnoreCase(user.getAddress()))
            updatedUser.setAddress(user.getAddress());
        //Farbe
        if(Objects.nonNull(user.getColor()) && "".equalsIgnoreCase(user.getColor()))
            updatedUser.setColor(user.getColor());

        return userRepo.save(updatedUser);
    }
}

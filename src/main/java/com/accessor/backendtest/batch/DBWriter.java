package com.accessor.backendtest.batch;

import com.accessor.backendtest.model.User;
import com.accessor.backendtest.repo.UserRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void write(List<? extends User> users) throws Exception {
        System.out.println("Data Saved for Users: " + users);
        userRepo.saveAll(users);

    }
}

package com.accessor.backendtest.batch;

import com.accessor.backendtest.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> COLOR_NAMES = new HashMap<>();

    public Processor() {
        COLOR_NAMES.put("1", "Blau");
        COLOR_NAMES.put("2", "Gruen");
        COLOR_NAMES.put("3", "Violett");
        COLOR_NAMES.put("4", "Rot");
        COLOR_NAMES.put("5", "Gelb");
        COLOR_NAMES.put("6", "Tuerkis");
        COLOR_NAMES.put("7", "Weiss");
    }

    @Override
    public User process(User user) throws Exception {
        String colorCode = user.getColor();
        String color = COLOR_NAMES.get(colorCode);
        user.setColor(color);
        user.setTime(new Date());
        System.out.printf("Converted from [%s] to [%s]%n", colorCode, color);
        return user;
    }
}

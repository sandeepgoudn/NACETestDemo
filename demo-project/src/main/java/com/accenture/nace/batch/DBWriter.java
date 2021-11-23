package com.accenture.nace.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.nace.model.NaceOrder;
import com.accenture.nace.repository.NaceRepository;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<NaceOrder> {

    private NaceRepository userRepository;

    @Autowired
    public DBWriter (NaceRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends NaceOrder> users) throws Exception{
        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}

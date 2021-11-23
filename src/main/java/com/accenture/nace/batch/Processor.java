package com.accenture.nace.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.accenture.nace.model.NaceOrder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<NaceOrder, NaceOrder> {


    @Override
    public NaceOrder process(NaceOrder user) throws Exception {
    	
    	System.out.println("Inside of Processor");
        return user;
    }
}
package com.accenture.nace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.nace.model.NaceOrder;

public interface NaceRepository extends JpaRepository<NaceOrder, Integer> {
}

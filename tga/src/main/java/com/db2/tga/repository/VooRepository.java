package com.db2.tga.repository;

import com.db2.tga.models.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {
}

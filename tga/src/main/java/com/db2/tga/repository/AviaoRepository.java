package com.db2.tga.repository;

import com.db2.tga.models.Aviao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Integer> {
}

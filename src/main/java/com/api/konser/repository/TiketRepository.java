package com.api.konser.repository;

import com.api.konser.entity.TIket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiketRepository extends JpaRepository<TIket, Integer> {
    List<TIket> findByNamaTiket(String namaTiket);
}

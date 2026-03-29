package com.ecole.musique.ecole_musique.repository;

import com.ecole.musique.ecole_musique.model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Long> {
}

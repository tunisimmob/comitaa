package com.ingarch.materiaux.repository;
import com.ingarch.materiaux.models.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@SuppressWarnings("unused")
@Repository
public interface ActualiteRepository extends JpaRepository<Actualite, Long> {



}

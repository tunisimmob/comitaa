package com.ingarch.materiaux.repository;
import com.ingarch.materiaux.models.DevenezFranchiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@SuppressWarnings("unused")
@Repository
public interface DevenezFranchiserRepository extends JpaRepository<DevenezFranchiser, Long> {

    @Transactional
    DevenezFranchiser findTop1ByOrderByIdDesc();


}

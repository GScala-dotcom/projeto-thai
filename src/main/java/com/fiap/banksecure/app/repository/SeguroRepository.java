package com.fiap.banksecure.app.repository;

import com.fiap.banksecure.app.domain.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {


}

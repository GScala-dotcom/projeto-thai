package com.fiap.banksecure.app.repository;

import com.fiap.banksecure.app.domain.model.TipoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSeguroRepository extends JpaRepository<TipoSeguro, Long> {


}

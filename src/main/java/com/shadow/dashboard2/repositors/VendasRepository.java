package com.shadow.dashboard2.repositors;

import com.shadow.dashboard2.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {

}

package com.shadow.dashboard2.repositors;

import com.shadow.dashboard2.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {

    // Consulta JPQL para somar o campo vendasTotal
    @Query("SELECT SUM(v.priceTotal) FROM Vendas v")
    Double calcularSomaVendasTotal();

}

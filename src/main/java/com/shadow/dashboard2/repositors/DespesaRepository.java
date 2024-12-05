package com.shadow.dashboard2.repositors;

import com.shadow.dashboard2.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {


    @Query("SELECT SUM(d.price) FROM Despesa d")
        Double obterSomaTotalPrice();


    }



package com.ED_API.__ED_API.repositories;

import com.ED_API.__ED_API.entities.PlanSelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanSelRepo extends JpaRepository<PlanSelEntity,Integer> {

    @Query("from PlanSelEntity where caseNum=:caseNum")
   public PlanSelEntity findByCaseNumber(long caseNum);

}

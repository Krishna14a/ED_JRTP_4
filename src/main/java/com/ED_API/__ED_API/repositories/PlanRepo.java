package com.ED_API.__ED_API.repositories;



import com.ED_API.__ED_API.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {
}
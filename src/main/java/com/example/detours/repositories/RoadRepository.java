package com.example.detours.repositories;

import com.example.detours.entities.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends JpaRepository<Road,Integer> {
}

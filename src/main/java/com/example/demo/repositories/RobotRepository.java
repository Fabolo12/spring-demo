package com.example.demo.repositories;

import com.example.demo.dto.CostRobotsDto;
import com.example.demo.models.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<Robot, String> {
    @Query("SELECT r FROM Robot r ORDER BY r.name DESC")
    Iterable<Robot> findAllWithSort();

    @Query("SELECT new com.example.demo.dto.CostRobotsDto(count(*),  sum(r.cost)) FROM Robot r")
    CostRobotsDto getCosts();
}

package com.example.demo.services;

import com.example.demo.models.Robot;
import com.example.demo.repositories.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {
    private final RobotRepository repository;

    @Autowired
    public RobotService(final RobotRepository repository) {
        this.repository = repository;
    }

    public List<Robot> findAll() {
        return repository.findAll();
    }

    public String save(final Robot robot) {
        return repository.save(robot).getId();
    }

    public String update(final Robot robot) {
        final Robot oldRobot = repository.findById(robot.getId()).orElseThrow();
        oldRobot.setName(robot.getName());
        return save(oldRobot);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public Iterable<Robot> findAllWithSort() {
        return repository.findAllWithSort();
    }
}

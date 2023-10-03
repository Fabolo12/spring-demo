package com.example.demo.models;

import com.example.demo.validators.RobotValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@ToString
public class Robot {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private int cost;

    @PrePersist
    public void prePersist() {
        RobotValidator.getInstance().valid(this);
    }

    @PreUpdate
    public void preUpdate() {
        RobotValidator.getInstance().valid(this);
    }
}

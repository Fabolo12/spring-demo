package com.example.demo.validators;

import com.example.demo.models.Robot;

public class RobotValidator implements Validator<Robot> {

    private static RobotValidator validator;

    private RobotValidator() {
    }

    public static RobotValidator getInstance() {
        if (validator == null) {
            validator = new RobotValidator();
        }
        return validator;
    }

    @Override
    public void valid(final Robot value) {
        if (value.getCost() < 0) {
            throw new IllegalStateException("Robot " + value.getId() + " has negative cost");
        }
    }
}

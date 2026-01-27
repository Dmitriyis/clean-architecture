package com.course.cleanarchitecture.domain.doctor.core.application.commands;

public interface AddReceptionInDoctorCommandHandler {
    void execute(AddReceptionInDoctorCommand addReceptionInDoctorCommand) throws NoSuchFieldException;
}

package com.andersen.maks.service;

import com.andersen.maks.model.Project;

import java.util.List;

public interface ProjectService {

    boolean addProject(Project project);
    void delete(long id);
    Project editProject(Project project);
    List<Project> getAll();

}

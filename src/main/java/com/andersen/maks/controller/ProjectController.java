package com.andersen.maks.controller;

import com.andersen.maks.model.Project;
import com.andersen.maks.service.DeveloperService;
import com.andersen.maks.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    private ProjectService projectService;
    private DeveloperService developerService;

    public ProjectController(){

    }

    @Autowired
    public ProjectController(ProjectService projectService, DeveloperService developerService){
        this.projectService = projectService;
        this.developerService = developerService;
    }


    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public ModelAndView displayNewProjectForm(){
        ModelAndView mv = new ModelAndView("addProject");
        mv.addObject("headerMessage", "Add Project Details");
        mv.addObject("project", new Project());
        return mv;
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView saveNewProject(@ModelAttribute Project project, @RequestParam int developerId, BindingResult result){
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");

        if (result.hasErrors()){
            return new ModelAndView("error");
        }
        project.setDeveloper(developerService.getDeveloperById(developerId));
        boolean isAdded = projectService.addProject(project);
        if (isAdded){
            mv.addObject("message", "New Project added");
        }else {
            return new ModelAndView("error");
        }
        return mv;
    }



}

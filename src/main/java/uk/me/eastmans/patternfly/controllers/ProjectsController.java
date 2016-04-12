package uk.me.eastmans.patternfly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.services.ProjectService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collections;

/**
 * Created by meastman on 08/04/16.
 */
@Controller
public class ProjectsController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/projects")
    public String listProjects(Model model)
    {
        Iterable<Project> projects = projectService.listAllProjects();

        model.addAttribute("projects", projects);
        return "projects";
    }

    @RequestMapping("/project/{id}")
    public String viewProject(Model model, @PathVariable Long id)
    {
        // Try to get the project
        Project project = projectService.getProjectById(id);

        model.addAttribute("project", project);
        return "project";
    }

    @RequestMapping("/addProject")
    public String addProject(Model model)
    {
        model.addAttribute("project", new Project());
        return "addProject";
    }


    @RequestMapping(value="/createProject",method= RequestMethod.POST)
    public String createProject(@Valid @ModelAttribute Project p, BindingResult bindingResult, Model model)
    {
        // Validate the project
        if (!bindingResult.hasErrors()) {
            projectService.saveProject(p);
            return "redirect:/projects";
        }

        return "addProject";
    }


}

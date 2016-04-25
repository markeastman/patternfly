package uk.me.eastmans.patternfly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.services.MigrationComponentService;
import uk.me.eastmans.patternfly.services.ProjectService;

import javax.validation.Valid;

/**
 * Created by meastman on 08/04/16.
 */
@Controller
public class ComponentsController {

    @Autowired
    private MigrationComponentService migrationComponentService;

    @RequestMapping("/component/{id}")
    public String viewComponent(Model model, @PathVariable Long id)
    {
        // Try to get the project
        MigrationComponent component = migrationComponentService.getMigrationComponentById(id);

        model.addAttribute("component", component);
        return "component";
    }

}

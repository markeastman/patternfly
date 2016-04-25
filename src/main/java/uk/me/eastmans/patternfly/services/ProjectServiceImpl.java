package uk.me.eastmans.patternfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.repositories.ProjectRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meastman on 08/04/16.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> listAllProjects() {
        return projectRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Project getProjectById(Long id) {
        // Get the project but also make sure components list is loaded, do not know of a better way in JPA
        Project p = projectRepository.findOne(id);
        if (p != null)
        {
            List l = p.getComponents();
            if (!l.isEmpty())
                l.get(0);
        }
        return p;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.delete(id);
    }
}

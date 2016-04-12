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
        return projectRepository.findOne(id);
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

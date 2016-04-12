package uk.me.eastmans.patternfly.services;

import uk.me.eastmans.patternfly.domain.Project;

import java.util.List;
import java.util.Map;

/**
 * Created by meastman on 22/12/15.
 */
public interface ProjectService {
    Iterable<Project> listAllProjects();

    Project getProjectById(Long id);

    Project saveProject(Project project);

    void deleteProject(Long id);
}

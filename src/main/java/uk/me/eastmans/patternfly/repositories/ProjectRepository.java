package uk.me.eastmans.patternfly.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uk.me.eastmans.patternfly.domain.Project;

import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findAllByOrderByNameAsc();
}

package uk.me.eastmans.patternfly.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;

import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
public interface MigrationComponentRepository extends CrudRepository<MigrationComponent, Long> {
}

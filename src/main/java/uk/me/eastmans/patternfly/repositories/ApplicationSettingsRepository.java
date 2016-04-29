package uk.me.eastmans.patternfly.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.me.eastmans.patternfly.domain.ApplicationSettings;
import uk.me.eastmans.patternfly.domain.Project;

import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
public interface ApplicationSettingsRepository extends CrudRepository<ApplicationSettings, Long> {
}

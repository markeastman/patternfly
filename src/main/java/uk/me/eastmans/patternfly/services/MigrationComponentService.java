package uk.me.eastmans.patternfly.services;

import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;

/**
 * Created by meastman on 22/12/15.
 */
public interface MigrationComponentService {
    MigrationComponent getMigrationComponentById(Long id);
}

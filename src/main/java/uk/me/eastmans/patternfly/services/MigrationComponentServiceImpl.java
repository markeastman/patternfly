package uk.me.eastmans.patternfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.repositories.MigrationComponentRepository;
import uk.me.eastmans.patternfly.repositories.ProjectRepository;

import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
@Service
public class MigrationComponentServiceImpl implements MigrationComponentService {
    @Autowired
    private MigrationComponentRepository migrationComponentRepository;

    @Override
    public MigrationComponent getMigrationComponentById(Long id) {
        return migrationComponentRepository.findOne(id);
    }
}

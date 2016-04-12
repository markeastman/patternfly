package uk.me.eastmans.patternfly.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.repositories.ProjectRepository;

import java.util.List;
import java.util.Random;

/**
 * Created by meastman on 08/04/16.
 */
@Component
public class WindupLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProjectRepository projectRepository;

    private Logger log = Logger.getLogger(WindupLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Project p1 = new Project("Allianz demo");
        projectRepository.save(p1);

        Project p2 = new Project("Allianz full");
        for (int i = 1; i < 40; i++)
        {
            MigrationComponent c = new MigrationComponent( "application_" + i );
            p2.addComponent(c);
        }
        projectRepository.save(p2);

    }
}

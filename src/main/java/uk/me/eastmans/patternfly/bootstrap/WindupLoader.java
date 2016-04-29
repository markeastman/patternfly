package uk.me.eastmans.patternfly.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uk.me.eastmans.patternfly.domain.*;
import uk.me.eastmans.patternfly.repositories.ApplicationSettingsRepository;
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

    @Autowired
    private ApplicationSettingsRepository settingsRepository;

    private Logger log = Logger.getLogger(WindupLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Create a master config item
        ApplicationSettings settings = new ApplicationSettings();
        settings.setId(1L);
        settings.setLocalFileLocation("/home/meastman/windup");
        settingsRepository.save(settings);

        Project p1 = new Project("Allianz demo");
        projectRepository.save(p1);

        Project p2 = new Project("Allianz full");
        ComponentGroup g1 = new ComponentGroup("Finance Web");
        p2.addComponentGroup(g1);
        ComponentGroup g2 = new ComponentGroup("HR Backend");
        p2.addComponentGroup(g2);

        for (int i = 1; i <= 40; i++)
        {
            MigrationComponent c = new MigrationComponent( "application_" + i + ".ear" );
            p2.addComponent(c);
            if (i == 3 || i == 11 || i == 12 || i == 13 ) {
                c.setComponentGroup(g1);
                c.setStatus(MigrationComponentStatus.PROCESSED);
                c.setStoryPoints(1049);
                c.setIncidentCount("10/21/32");
            }
            else if (i == 6 || i == 7 || i > 32) {
                c.setComponentGroup(g2);
                c.setStatus(MigrationComponentStatus.ANALYSIS_IN_PROGRESS);
            }
        }
        projectRepository.save(p2);

    }
}

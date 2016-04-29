package uk.me.eastmans.patternfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.eastmans.patternfly.domain.ApplicationSettings;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.repositories.ApplicationSettingsRepository;
import uk.me.eastmans.patternfly.repositories.ProjectRepository;

import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
@Service
public class ApplicationSettingsServiceImpl implements ApplicationSettingsService {
    @Autowired
    private ApplicationSettingsRepository settingsRepository;

    private ApplicationSettings settingsCache;

    private String lock = "mutex"; // for synchronized block

    @Override
    public ApplicationSettings getSingleton() {
        if (settingsCache == null) {
            loadApplicationSeetings();
        }
        return settingsCache;
    }

    @Override
    public ApplicationSettings saveApplicationSettings(ApplicationSettings settings) {
        // Need to force reload of cache item
        settingsRepository.save(settings);
        settingsCache = null;
        loadApplicationSeetings();
        return settingsCache;
    }

    private void loadApplicationSeetings()
    {
        synchronized(lock)
        {
            if (settingsCache == null)
            {
                settingsCache = settingsRepository.findOne(1L);
            }
        }
    }
}

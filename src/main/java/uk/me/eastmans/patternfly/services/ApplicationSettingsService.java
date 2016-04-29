package uk.me.eastmans.patternfly.services;

import uk.me.eastmans.patternfly.domain.ApplicationSettings;
import uk.me.eastmans.patternfly.domain.Project;

/**
 * Created by meastman on 22/12/15.
 */
public interface ApplicationSettingsService {
    ApplicationSettings getSingleton();
    ApplicationSettings saveApplicationSettings(ApplicationSettings settings);
}

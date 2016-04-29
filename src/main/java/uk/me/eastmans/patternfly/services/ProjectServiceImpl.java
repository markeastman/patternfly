package uk.me.eastmans.patternfly.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uk.me.eastmans.patternfly.domain.ApplicationSettings;
import uk.me.eastmans.patternfly.domain.MigrationComponent;
import uk.me.eastmans.patternfly.domain.Project;
import uk.me.eastmans.patternfly.repositories.ProjectRepository;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meastman on 08/04/16.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private Logger log = Logger.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ApplicationSettingsService settingsService;

    @Override
    public List<Project> listAllProjects() {
        return projectRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Project getProjectById(Long id) {
        // Get the project but also make sure components list is loaded, do not know of a better way in JPA
        Project p = projectRepository.findOne(id);
        return p;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public String getRootFolderLocation(Project p)
    {
        ApplicationSettings settings = settingsService.getSingleton();
        return settings.getLocalFileLocation() + File.separator + p.getId();
    }

    @Override
    public void uploadFiles(Long projectId, MultipartFile[] files)
    {
        if (files != null)
        {
            Project p = projectRepository.findOne(projectId);

            for (MultipartFile file : files)
            {
                // Process the specific file
                uploadFile( p, file );
            }

            projectRepository.save(p);
        }
    }

    /**
     * We need to load the file to the project src area
     * @param file
     */
    private void uploadFile( Project p, MultipartFile file )
    {
        try {
            ApplicationSettings settings = settingsService.getSingleton();
            String root = getRootFolderLocation(p);
            File rootLocation = new File( root );
            if (!rootLocation.exists())
                rootLocation.mkdir();
            // Check to see if we have a src folder
            File src = new File( rootLocation, "src" );
            if (!src.exists())
                src.mkdir();
            // Now try to get the file name and see if it exists
            File uploadFile = new File( src, file.getOriginalFilename());
            if (!uploadFile.exists())
                uploadFile.createNewFile();
            file.transferTo(uploadFile);
            // For each file we could create a repository MigrationComponent reference for each one
            MigrationComponent c = new MigrationComponent(file.getOriginalFilename());
            p.addComponent(c);
        }
        catch (Exception e)
        {
            // We should notify or log it at least
            log.error( file, e);
        }
    }
}

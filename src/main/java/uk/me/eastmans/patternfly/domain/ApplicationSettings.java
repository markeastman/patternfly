package uk.me.eastmans.patternfly.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by meastman on 08/04/16.
 */
@Entity
@Table(name = "APPLICATION_SETTINGS")
public class ApplicationSettings
{
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 0, max = 512)
    private String localFileLocation;

    public ApplicationSettings() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalFileLocation() {
        return localFileLocation;
    }

    public void setLocalFileLocation(String localFileLocation) {
        this.localFileLocation = localFileLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        ApplicationSettings project = (ApplicationSettings) o;

        if (id == null || project.id == null)
            return false;
        return id.equals(project.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : -1;
    }

    public String toString() {
        return getLocalFileLocation();
    }

}

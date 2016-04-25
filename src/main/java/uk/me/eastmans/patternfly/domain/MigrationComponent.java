package uk.me.eastmans.patternfly.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by meastman on 12/04/16.
 */
@Entity
@Table(name = "COMPONENT")
public class MigrationComponent {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Project project;

    @ManyToOne
    private ComponentGroup componentGroup;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MigrationComponentStatus status = MigrationComponentStatus.NOT_ANALYZED;

    private Integer storyPoints;

    private String incidentCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ComponentGroup getComponentGroup() {
        return componentGroup;
    }

    public void setComponentGroup(ComponentGroup componentGroup) {
        this.componentGroup = componentGroup;
    }

    public MigrationComponent()
    {}

    public MigrationComponent(String name) {
        this.name = name;
    }

    public MigrationComponentStatus getStatus() {
        return status;
    }

    public void setStatus(MigrationComponentStatus status) {
        this.status = status;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public String getIncidentCount() {
        return incidentCount;
    }

    public void setIncidentCount(String incidentCount) {
        this.incidentCount = incidentCount;
    }

    public boolean isReportAvailable()
    {
        return status == MigrationComponentStatus.PROCESSED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        MigrationComponent component = (MigrationComponent) o;

        if (id == null || component.id == null)
            return false;
        return id.equals(component.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : -1;
    }

    public String toString() {
        return getName();
    }

}

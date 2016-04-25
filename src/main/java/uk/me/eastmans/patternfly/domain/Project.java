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
@Table(name = "PROJECT")
public class Project
{
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(unique = true)
    private String name;

    @Size(min = 0, max = 512)
    private String localFileLocation;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MigrationComponent> components = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ComponentGroup> componentGroups = new ArrayList<>();

    public Project() {}

    public Project(String name)
    {
        this.name = name;
    }

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

    public String getLocalFileLocation() {
        return localFileLocation;
    }

    public void setLocalFileLocation(String localFileLocation) {
        this.localFileLocation = localFileLocation;
    }

    public List<MigrationComponent> getComponents() {
        return components;
    }

    public void setComponents(List<MigrationComponent> components) {
        this.components = components;
    }

    public void addComponent(MigrationComponent c)
    {
        c.setProject(this);
        this.components.add( c );
    }

    public int getComponentCount()
    {
        return this.components.size();
    }

    public List<ComponentGroup> getComponentGroups() {
        return componentGroups;
    }

    public void setComponentGroups(List<ComponentGroup> componentGroups) {
        this.componentGroups = componentGroups;
    }

    public void addComponentGroup(ComponentGroup g)
    {
        g.setProject(this);
        this.componentGroups.add( g );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Project project = (Project) o;

        if (id == null || project.id == null)
            return false;
        return id.equals(project.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : -1;
    }

    public String toString() {
        return getName();
    }

}

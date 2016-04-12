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

    @OneToMany(cascade = CascadeType.ALL)
    private List<MigrationComponent> components = new ArrayList<>();

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

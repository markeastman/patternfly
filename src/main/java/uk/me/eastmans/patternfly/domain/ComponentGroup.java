package uk.me.eastmans.patternfly.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by meastman on 12/04/16.
 */
@Entity
@Table(name = "COMPONENT_GROUP")
public class ComponentGroup {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Project project;

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

    public ComponentGroup()
    {}

    public ComponentGroup(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        ComponentGroup component = (ComponentGroup) o;

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

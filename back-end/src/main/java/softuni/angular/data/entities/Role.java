package softuni.angular.data.entities;

import softuni.angular.data.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Project: backend
 * Created by: GKirilov
 * On: 10/15/2021
 */
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private String code;
    private String description;
    private List<User> users;

    @ManyToMany(mappedBy = "roles")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Basic
    @Column(name = "code", nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

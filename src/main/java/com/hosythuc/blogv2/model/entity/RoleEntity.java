package com.hosythuc.blogv2.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn( name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private List<PermissionEntity> permissions;
}

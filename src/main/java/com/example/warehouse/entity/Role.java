package com.example.warehouse.entity;

import com.example.warehouse.entity.enums.Permission;
import com.example.warehouse.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends AbsEntity {

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Permission> permissions;

    public Role(Integer id, String name, boolean active, Set<Permission> permissions) {
        super(id, name, active);
        this.permissions = permissions;
    }
}

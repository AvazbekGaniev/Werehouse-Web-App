package com.example.warehouse.entity;

import com.example.warehouse.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Warehouse  extends AbsEntity {

}

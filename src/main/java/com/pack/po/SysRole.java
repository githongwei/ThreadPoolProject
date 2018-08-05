package com.pack.po;

import javax.persistence.*;

/**
 * 角色实体对象
 */
@Entity
public class SysRole{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

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
}

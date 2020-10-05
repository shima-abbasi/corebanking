package corebanking.common.systemConfig.model;

import corebanking.common.model.Basic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_SYSTEM_CONFIG")
public class SystemConfig extends Basic {
    private String code;
    private String name;
    private String value;
    private SystemConfig parent;
    private Set<SystemConfig> children = new HashSet<>();


    public SystemConfig() {
    }

    @Column(name = "C_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "C_VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "C_CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PARENT")
    public SystemConfig getParent() {
        return parent;
    }

    public void setParent(SystemConfig parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    public Set<SystemConfig> getChildren() {
        return children;
    }

    public void setChildren(Set<SystemConfig> children) {
        this.children = children;
    }
}

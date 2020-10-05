package corebanking.common.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Basic implements Serializable {
    private Long id;
    private Boolean deleted = Boolean.FALSE;


    public Basic() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @SequenceGenerator(name = "myseq", sequenceName = "MY_SEQ")
    @Column(name = "C_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "C_DELETED", nullable = false)
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

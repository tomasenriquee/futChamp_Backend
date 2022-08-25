package futchamp.configuration;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

    /**
     * Fecha de creación del registro
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    /**
     * Fecha de ultima actualización del registro
     */
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated;

    public Auditable() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}

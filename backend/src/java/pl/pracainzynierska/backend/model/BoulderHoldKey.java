
/*
package pl.pracainzynierska.backend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BoulderHoldKey implements Serializable {

    @Column(name = "idHold")
    Long idHold;

    @Column(name = "idBoulder")
    Long idBoulder;

    public BoulderHoldKey(Long idHold, Long idBoulder) {
        this.idHold = idHold;
        this.idBoulder = idBoulder;
    }

    public BoulderHoldKey() {
    }

    public Long getIdHold() {
        return idHold;
    }

    public void setIdHold(Long idHold) {
        this.idHold = idHold;
    }

    public Long getIdBoulder() {
        return idBoulder;
    }

    public void setIdBoulder(Long idBoulder) {
        this.idBoulder = idBoulder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoulderHoldKey that = (BoulderHoldKey) o;
        return Objects.equals(idHold, that.idHold) && Objects.equals(idBoulder, that.idBoulder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHold, idBoulder);
    }
}
*/

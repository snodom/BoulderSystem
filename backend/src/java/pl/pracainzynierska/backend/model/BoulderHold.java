/*
package pl.pracainzynierska.backend.model;

import javax.persistence.*;

@Entity
public class BoulderHold{

    @EmbeddedId
    BoulderHoldKey id;

    @ManyToOne
    @MapsId("idBoulder")
    @JoinColumn(name = "idBoulder")
    Boulder boulder;

    @ManyToOne
    @MapsId("idHold")
    @JoinColumn(name = "idHold")
    Hold hold;

    public BoulderHoldKey getId() {
        return id;
    }

    public void setId(BoulderHoldKey id) {
        this.id = id;
    }

    public Boulder getBoulder() {
        return boulder;
    }

    public void setBoulder(Boulder boulder) {
        this.boulder = boulder;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        this.hold = hold;
    }

    public BoulderHold(BoulderHoldKey id, Boulder boulder, Hold hold) {
        this.id = id;
        this.boulder = boulder;
        this.hold = hold;
    }

    public BoulderHold() {
    }
}
*/
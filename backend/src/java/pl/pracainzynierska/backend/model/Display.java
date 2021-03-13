package pl.pracainzynierska.backend.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name="display")
@Entity
public class Display {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idDisplay;

    @Column
    @NotNull
    private Long idBoulder;


    public Long getIdDisplay() {
        return idDisplay;
    }

    public Long getIdBoulder() {
        return idBoulder;
    }

    public Display(Display display) {
        this.idDisplay=getIdDisplay();
        this.idBoulder=getIdBoulder();
    }

    public void setIdBoulder(Long idBoulder) {
        this.idBoulder = idBoulder;
    }

    public Display() {
    }
}

package pl.pracainzynierska.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="hold")
@Entity
public class Hold {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idHold;

    @Column
    @NotNull
    private Integer x;

    @Column
    @NotNull
    private Integer y;

    @ManyToMany(mappedBy = "holds", fetch = FetchType.LAZY)
    private Set<Boulder> boulders = new HashSet<>();


   // @OneToMany(mappedBy = "hold")
   // Set<BoulderHold> boulderHolds;


    public Hold(Hold hold) {
        this.idHold =getIdHold();
        this.x =getX();
        this.y =getY();
        this.boulders =getBoulders();
    }

    public Hold() {
    }

    public Long getIdHold() {
        return idHold;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Set<Boulder> getBoulders() {
        return boulders;
    }

    public void setBoulders(Set<Boulder> boulders) {
        this.boulders = boulders;
    }
}

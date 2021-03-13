package pl.pracainzynierska.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="boulder")
@Entity
public class Boulder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idBoulder;

    @Column
    @NotNull
    private String Name;

    @Column
    @NotNull
    private Integer Grade;

    @Column
    @NotNull
    private String Author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Boulder_Hold",
            joinColumns = @JoinColumn(name = "idBoulder"),
            inverseJoinColumns = @JoinColumn(name = "idHold")
    )
    Set<Hold> holds = new HashSet<>();


   /// @OneToMany(mappedBy = "boulder")
   // Set<BoulderHold> boulderHolds;


    public Boulder(Boulder boulder) {
        this.idBoulder = getIdBoulder();
        this.Name = getName();
        this.Grade = getGrade();
        this.Author = getAuthor();
        this.holds = getHolds();
    }

    public Boulder() {
    }

    public Long getIdBoulder() {
        return idBoulder;
    }

    public String getName() {
        return Name;
    }

    public Integer getGrade() {
        return Grade;
    }

    public String getAuthor() {
        return Author;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setGrade(Integer grade) {
        this.Grade = grade;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setHolds(Set<Hold> holds) {
        this.holds = holds;
    }

    public Set<Hold> getHolds() {
        return holds;
    }
}

package pl.mmkay.inventory.part;

import javax.persistence.*;

@Entity
public class PartCompatibility {
    public PartCompatibility() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "part1")
    private Part part1;
    @ManyToOne
    @JoinColumn(name = "part2")
    private Part part2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Part getPart1() {
        return part1;
    }

    public void setPart1(Part part1) {
        this.part1 = part1;
    }

    public Part getPart2() {
        return part2;
    }

    public void setPart2(Part part2) {
        this.part2 = part2;
    }
}

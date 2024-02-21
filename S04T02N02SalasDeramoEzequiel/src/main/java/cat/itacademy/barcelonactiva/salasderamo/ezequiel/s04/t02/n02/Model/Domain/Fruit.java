package cat.itacademy.barcelonactiva.salasderamo.ezequiel.s04.t02.n02.Model.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantityKg")
    private int quantityKg;

    public Fruit() {
    }

    public Fruit(String name, int quantityKg) {
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public Fruit(int id, String name, int quantityKg) {
        this.id = id;
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }
}

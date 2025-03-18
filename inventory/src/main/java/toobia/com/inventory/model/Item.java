package toobia.com.inventory.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int amount;

    public Item() {}

    public Item(Equipment equipment, Responsible responsible, Storage storage, int amount) {
        this.equipment = equipment;
        this.responsible = responsible;
        this.storage = storage;
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn(name = "equipment")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private Responsible responsible;

    @ManyToOne
    @JoinColumn(name = "storage")
    private Storage storage;

}

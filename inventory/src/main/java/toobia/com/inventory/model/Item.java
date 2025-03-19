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
        equipment.addItem(this);
        responsible.addItem(this);
        storage.addItem(this);
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public Storage getStorage() {
        return storage;
    }
}

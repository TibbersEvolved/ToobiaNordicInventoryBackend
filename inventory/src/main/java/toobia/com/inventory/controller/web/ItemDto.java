package toobia.com.inventory.controller.web;

import toobia.com.inventory.model.Item;

public record ItemDto(String equipment, String responsible, String storage, int amount) {

    public static ItemDto from(Item item) {
        return new ItemDto(
                item.getEquipment().getEquipmentName(),
                item.getResponsible().getName(),
                item.getStorage().getName(),
                item.getAmount()
        );
    }
}

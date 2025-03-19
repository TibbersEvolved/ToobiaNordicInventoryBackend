package toobia.com.inventory.controller.web;

import toobia.com.inventory.model.Item;

import java.util.UUID;

public record ItemDto(String equipment, String responsible, String storage, int amount, UUID id) {

    public static ItemDto from(Item item) {
        return new ItemDto(
                item.getEquipment().getEquipmentName(),
                item.getResponsible().getName(),
                item.getStorage().getName(),
                item.getAmount(),
                item.getId()
        );
    }
}

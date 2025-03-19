package toobia.com.inventory.controller.web;

import java.util.UUID;

public record ItemCreateDto(UUID storageId, String equipmentId, UUID responsibleId, Integer amount) {
}

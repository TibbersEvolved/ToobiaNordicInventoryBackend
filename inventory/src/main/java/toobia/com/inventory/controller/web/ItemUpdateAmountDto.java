package toobia.com.inventory.controller.web;

import java.util.UUID;

public record ItemUpdateAmountDto(UUID itemId, int amount) {
}

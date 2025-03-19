package toobia.com.inventory.controller;

import org.springframework.web.bind.annotation.*;
import toobia.com.inventory.controller.web.*;
import toobia.com.inventory.model.Item;
import toobia.com.inventory.service.ItemService;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDto createItem(@RequestBody ItemCreateDto itemCreateDto) {
        Item item = itemService.createItem(itemCreateDto);
        return ItemDto.from(item);
    }

    @GetMapping
    public ItemListDto getAllItems() {
        List<Item> items = itemService.findAll();
        return ItemListDto.from(items);
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable UUID id) {
        return ItemDto.from(itemService.findById(id));
    }
    

    @PutMapping
    public ItemDto updateItem(@RequestBody ItemUpdateDto itemUpdateDto) {
        Item item = itemService.updateItem(itemUpdateDto);
        return ItemDto.from(item);
    }

}

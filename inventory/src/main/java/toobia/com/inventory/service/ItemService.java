package toobia.com.inventory.service;

import org.springframework.stereotype.Service;
import toobia.com.inventory.controller.web.ItemCreateDto;
import toobia.com.inventory.controller.web.ItemUpdateDto;
import toobia.com.inventory.exceptions.InventoryResourceNotFound;
import toobia.com.inventory.model.Equipment;
import toobia.com.inventory.model.Item;
import toobia.com.inventory.model.Responsible;
import toobia.com.inventory.model.Storage;
import toobia.com.inventory.repository.EquipmentRepository;
import toobia.com.inventory.repository.ItemRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final EquipmentService equipmentService;
    private final ResponsibleService responsibleService;
    private final StorageService storageService;

    public ItemService(ItemRepository itemRepository, EquipmentService equipmentService,
                       ResponsibleService responsibleService, StorageService storageService) {
        this.itemRepository = itemRepository;
        this.equipmentService = equipmentService;
        this.responsibleService = responsibleService;
        this.storageService = storageService;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item setAmount(UUID id, Integer amount) {
        Item item = findById(id);
        item.setAmount(amount);
        return itemRepository.save(item);
    }

    public Item createItem(ItemCreateDto itemCreateDto) {
        Storage storage = storageService.getStorageById(itemCreateDto.storageId());
        Responsible responsible = responsibleService.findResponsible(itemCreateDto.responsibleId());
        Equipment equipment = equipmentService.getEquipment(itemCreateDto.equipmentId());
        Item item = itemRepository.save(new Item(equipment, responsible, storage, itemCreateDto.amount()));
        equipmentService.saveEquipment(equipment);
        storageService.saveStorage(storage);
        responsibleService.saveResponsible(responsible);
        return item;
    }

    public Item updateItem(ItemUpdateDto itemUpdateDto) {
        Item item = findById(itemUpdateDto.storageId());
        Storage storage = storageService.getStorageById(itemUpdateDto.storageId());
        Responsible responsible = responsibleService.findResponsible(itemUpdateDto.responsibleId());
        Equipment equipment = equipmentService.getEquipment(itemUpdateDto.equipmentId());
        storageService.saveStorage(item.setStorage(storage));
        equipmentService.saveEquipment(item.setEquipment(equipment));
        responsibleService.saveResponsible(item.setResponsible(responsible));
        storageService.saveStorage(storage);
        equipmentService.saveEquipment(equipment);
        responsibleService.saveResponsible(responsible);
        return itemRepository.save(item);
    }


    public Item findById(UUID id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            throw new InventoryResourceNotFound(id.toString() + " does not exist");
        }
        return item;
    }

    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }


}

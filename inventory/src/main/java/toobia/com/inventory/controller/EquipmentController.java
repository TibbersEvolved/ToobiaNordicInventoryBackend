package toobia.com.inventory.controller;

import org.springframework.web.bind.annotation.*;
import toobia.com.inventory.controller.web.EquipmentDto;
import toobia.com.inventory.controller.web.EquipmentListResponseDto;
import toobia.com.inventory.model.Equipment;
import toobia.com.inventory.service.EquipmentService;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/equipments")
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public EquipmentListResponseDto getAllEquipment() {
        return EquipmentListResponseDto.toEquipmentListResponseDto
                (equipmentService.getAllEquipment());
    }

    @GetMapping("/{id}")
    public EquipmentDto getEquipmentById(@PathVariable String id) {
        Equipment equipment = equipmentService.getEquipment(id);
        return new EquipmentDto(equipment.getEquipmentName(), equipment.getEquipmentId());
    }

    @PostMapping
    public EquipmentDto createEquipment(@RequestBody EquipmentDto equipmentDto) {
        equipmentService.addEquipment(equipmentDto.equipmentName(), equipmentDto.equipmentId());
        return equipmentDto;
    }

    @PutMapping
    public EquipmentDto updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        Equipment equipment = equipmentService.updateEquipment(equipmentDto.equipmentId(), equipmentDto.equipmentName());
        return new EquipmentDto(equipment.getEquipmentName(), equipment.getEquipmentId());
    }

    @DeleteMapping("/{equipmentId}")
    public void deleteEquipment(@PathVariable String equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
    }

}

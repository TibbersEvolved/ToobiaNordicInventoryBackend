package toobia.com.inventory.controller;

import org.springframework.web.bind.annotation.*;
import toobia.com.inventory.controller.web.EquipmentDto;
import toobia.com.inventory.controller.web.EquipmentListResponseDto;
import toobia.com.inventory.model.Equipment;
import toobia.com.inventory.service.EquipmentService;

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

    @PostMapping
    public EquipmentDto createEquipment(@RequestBody EquipmentDto equipmentDto) {
        equipmentService.addEquipment(equipmentDto.equipmentName(), equipmentDto.equipmentId());
        return equipmentDto;
    }

}

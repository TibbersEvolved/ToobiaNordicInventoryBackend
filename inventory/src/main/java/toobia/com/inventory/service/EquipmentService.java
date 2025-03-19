package toobia.com.inventory.service;

import org.springframework.stereotype.Service;
import toobia.com.inventory.model.Equipment;
import toobia.com.inventory.model.Item;
import toobia.com.inventory.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment addEquipment(String equipmentName, String equipmentId) {
        return equipmentRepository.save(new Equipment(equipmentName, equipmentId));
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipment(String equipmentId) {
        return equipmentRepository.findById(equipmentId).get();
    }

    public void saveEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

}

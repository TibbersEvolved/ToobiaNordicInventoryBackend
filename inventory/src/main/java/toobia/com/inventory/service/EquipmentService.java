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

    public void deleteEquipment(String equipmentId) {
        Equipment equipment = getEquipment(equipmentId);
        equipmentRepository.delete(equipment);
    }

    public Equipment getEquipment(String equipmentId) {
        List<Equipment> ls = equipmentRepository.findAll();
        Equipment equipment = null;
        for (Equipment t : ls) {
            if (equipmentId.equals(t.getEquipmentId())) {
                equipment = t;
            }
        }
        return equipment;
    }

    public void saveEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

}

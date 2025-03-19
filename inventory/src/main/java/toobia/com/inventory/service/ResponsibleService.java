package toobia.com.inventory.service;

import org.springframework.stereotype.Service;
import toobia.com.inventory.model.Responsible;
import toobia.com.inventory.repository.ResponsibleRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ResponsibleService {

    private ResponsibleRepository repository;

    public ResponsibleService(ResponsibleRepository repository) {
        this.repository = repository;
    }

    public Responsible createResponsible(String responsibleName) {
        Responsible responsible = new Responsible(responsibleName);
        repository.save(responsible);
        return responsible;
    }

    public Responsible findResponsible(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Responsible updateResponsibleName(UUID id, String name) {
        Responsible responsible = findResponsible(id);
        responsible.setName(name);
        return repository.save(responsible);
    }

    public List<Responsible> getAllResponsibles() {
        return repository.findAll();
    }

    public void saveResponsible(Responsible responsible) {
        repository.save(responsible);
    }

}

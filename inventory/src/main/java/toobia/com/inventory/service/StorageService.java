package toobia.com.inventory.service;

import org.springframework.stereotype.Service;
import toobia.com.inventory.model.Storage;
import toobia.com.inventory.repository.StorageRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StorageService {

    private StorageRepository repository;

    public StorageService(StorageRepository repository) {
        this.repository = repository;
    }

    public List<Storage> getStorages() {
        return repository.findAll();
    }

    public Storage getStorageById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Storage createStorage(String name) {
        return repository.save(new Storage(name));
    }


}

package toobia.com.inventory.service;

import org.springframework.stereotype.Service;
import toobia.com.inventory.model.Storage;
import toobia.com.inventory.repository.StorageRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StorageService {

    private final StorageRepository storageRepository;
    private StorageRepository repository;

    public StorageService(StorageRepository repository, StorageRepository storageRepository) {
        this.repository = repository;
        this.storageRepository = storageRepository;
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

    public void saveStorage(Storage storage) {
        storageRepository.save(storage);
    }


}

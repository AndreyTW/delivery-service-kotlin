package ru.andreyTw.delivery.service;

import org.springframework.stereotype.Service;
import ru.andreyTw.delivery.db.ClientTypeData;
import ru.andreyTw.delivery.repository.ClientTypeDataRepository;

import java.util.List;

@Service
public class ClientTypeDataService {

    private final ClientTypeDataRepository clientTypeDataRepository;

    public ClientTypeDataService(ClientTypeDataRepository clientTypeDataRepository) {
        this.clientTypeDataRepository = clientTypeDataRepository;
    }

    public void save(ClientTypeData clientTypeData) {
        clientTypeDataRepository.save(clientTypeData);
    }

    public List<ClientTypeData> getAll() {
        return clientTypeDataRepository.findAll();
    }
}
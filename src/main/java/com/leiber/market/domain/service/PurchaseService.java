package com.leiber.market.domain.service;

import com.leiber.market.domain.Purchase;
import com.leiber.market.domain.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getClientById(String clientId) {
        if (clientId == null || clientId.isEmpty() || clientId.trim().isEmpty()) {
            throw new IllegalArgumentException("The client id cannot be null");
        }
         return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        if (Objects.isNull(purchase)) {
            throw new IllegalArgumentException("The purchase cannot be null");
        }
        return purchaseRepository.save(purchase);
    }
}

package com.leiber.market.domain.repository;

import com.leiber.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(Integer clientId);
    Purchase save(Purchase purchase);
}

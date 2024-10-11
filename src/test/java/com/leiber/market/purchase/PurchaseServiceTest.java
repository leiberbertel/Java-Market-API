package com.leiber.market.purchase;

import com.leiber.market.domain.Purchase;
import com.leiber.market.domain.repository.PurchaseRepository;
import com.leiber.market.domain.service.PurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Class in charge of testing the methods of PurchaseService
 * Created on 10/10/2024 at 5:43:00 pm
 *
 * @author Leiber Bertel
 */
@ExtendWith(MockitoExtension.class)
class PurchaseServiceTest {
    @InjectMocks
    private PurchaseService purchaseService;
    @Mock
    private PurchaseRepository purchaseRepository;

    private List<Purchase> purchases;

    private Purchase purchase;

    private String clientId;

    private Purchase newPurchase;

    @BeforeEach
    void setup() {
        purchase = new Purchase();
        purchase.setPurchaseId(1);
        purchase.setState("Test");

        purchases = new ArrayList<>();
        purchases.add(purchase);

        clientId = "1";

        newPurchase = new Purchase();
        newPurchase.setPurchaseId(2);
        newPurchase.setState("Test 2");
    }

    @Test
    void testGetAll_NotNull() {
        when(purchaseRepository.getAll()).thenReturn(purchases);

        List<Purchase> result = purchaseService.getAll();

        assertNotNull(result);
    }

    @Test
    void testGetAll_ListLengthOne() {
        when(purchaseRepository.getAll()).thenReturn(purchases);

        List<Purchase> result = purchaseService.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void getClientById_Success() {
        when(purchaseRepository.getByClient(clientId)).thenReturn(Optional.ofNullable(purchases));

        Optional<List<Purchase>> result = purchaseService.getClientById(clientId);

        assertNotNull(result);
    }

    @Test
    void getClientById_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> purchaseService.getClientById(null));

        assertEquals("The client id cannot be null", exception.getMessage());
    }

    @Test
    void save_Success() {
        when(purchaseRepository.save(newPurchase)).thenReturn(purchase);

        Purchase result = purchaseService.save(newPurchase);

        assertNotNull(result);
    }
}

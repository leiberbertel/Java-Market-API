package com.leiber.market.web.controller;

import com.leiber.market.domain.Purchase;
import com.leiber.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    @ApiOperation("Get all purchases")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Purchase>> all() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    @ApiOperation("Search a purchase with a client id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Purchase not found")
    })
    public ResponseEntity<List<Purchase>> getPurchaseByClient(@ApiParam(value = "The purchase id", required = true, example = "4546221") @PathVariable("clientId") String clientId) {
        return purchaseService.getClientById(clientId).filter(Predicate.not(List::isEmpty))
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Create a new purchase")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.OK);
    }
}

package com.example.demo.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

	@Autowired
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	} 

    @PostMapping
	public void registerNewPurchase(@RequestBody PurchaseRequest purchaseRequest){
		purchaseService.addNewPurchase(purchaseRequest);
	}

}

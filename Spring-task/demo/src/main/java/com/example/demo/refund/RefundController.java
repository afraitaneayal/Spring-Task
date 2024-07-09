package com.example.demo.refund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/refund")
public class RefundController {

    private final RefundService refundService;

	@Autowired
	public RefundController(RefundService refundService) {
		this.refundService = refundService;
	} 

    @PostMapping
	public void registerNewRefund(@RequestBody RefundRequest refundRequest){
		refundService.addNewRefund(refundRequest);
	}
}

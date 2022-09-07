package com.toll;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController 
{
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private Environment env;
	
	@GetMapping("/Home")
	public String home() {
		return "home";
	}
	
	@PostMapping(value = "/submitPaymentDetail")
    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
            @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
            @RequestParam(name = "ORDER_ID") String orderId) throws Exception 
	{

        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
        System.out.println(paytmDetailPojo.getMerchantId());
        
        System.out.println(paytmDetailPojo.getDetails());
        
        TreeMap<String, String> parameters = new TreeMap<>();
        paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
        
        System.out.println("Tree Map content"+parameters);
        
        
        return modelAndView;
	}
}

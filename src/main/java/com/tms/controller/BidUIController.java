package com.tms.controller;

import com.tms.service.BidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BidUIController {

    private final BidService bidService;

    public BidUIController(BidService bidService) {
        this.bidService = bidService;
    }

   @GetMapping("/ui/bids")
    public String showBids(
        @RequestParam(required = false) Integer loadId,
        @RequestParam(required = false) Integer transporterId,
        @RequestParam(required = false) String status,
        Model model) {

    model.addAttribute("bids", bidService.getBids(loadId, transporterId, status));
    return "bids";
        }
}
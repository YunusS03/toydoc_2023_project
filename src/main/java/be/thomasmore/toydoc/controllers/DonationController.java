package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.Donation;
import be.thomasmore.toydoc.repositories.DonateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DonationController {

    private Logger logger = LoggerFactory.getLogger(DonationController.class);

    private DonateRepository donateRepository;

    private String localPlan;
    private Integer localAmount;
    private String localFirstName;
    private String localLastName;
    private String localEmail;
    private String localSecurityCardNumber;

//    @ModelAttribute("donation")
//    public Donation findParty(@PathVariable(required = false) Integer id) {
//        return new Donation();
//    }

    @GetMapping("/donation")
    public String donation(Model model){
        model.addAttribute("planForm",true);
        return "donation";
    }

    @GetMapping("donation/plan")
    public String donationPlanForm(Model model,@RequestParam(required=false)String plan,Integer amount,Integer ownAmount,String anonymous){
        localPlan = plan;

        if(ownAmount==null){
            localAmount = amount;
        }else{
            localAmount = ownAmount;
        }

        if(anonymous == null){
            model.addAttribute("openContactInfo",true);
            model.addAttribute("openCheckout",false);
        }
        else if(anonymous.equals("true")){
            model.addAttribute("openContactInfo",false);
            model.addAttribute("openCheckout",true);
        }
        return "donation";
    }

    @GetMapping("donation/info")
    public String donationInfoForm(Model model,@RequestParam(required=false)String title,String firstName,String lastName,String email,String phoneNumber){
        localFirstName = firstName;
        localLastName = lastName ;
        localEmail = email;
        model.addAttribute("openCheckout",true);
        return "donation";
    }
    @GetMapping("donation/checkout")
    public String donationCheckoutForm(Model model,@RequestParam(required=false)String cardHolder,String cardNumber,String expiry,String cvv){
        String securityCardNumber = "*******" + cardNumber.substring(12,15) ;
        localSecurityCardNumber = securityCardNumber;
        model.addAttribute("openSave",true);
        model.addAttribute("plan",localPlan);
        model.addAttribute("amount",localAmount);
        model.addAttribute("firstName",localFirstName);
        model.addAttribute("lastName",localLastName);
        model.addAttribute("email",localEmail);
        model.addAttribute("securityCardNumber",localSecurityCardNumber);
        return "donation";
    }

//    @GetMapping("donation/save")
//        public String donationSave(Model model){
//        return "donation";
//    }
//
//    @PostMapping("/donation/save")
//    public String newDonate(Model model,Donation donation) {
//
//        donateRepository.save(donation);
//        return "donation";
//    }
}
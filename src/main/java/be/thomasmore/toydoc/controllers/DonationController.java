package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Donation;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.DonationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class DonationController {

    private Logger logger = LoggerFactory.getLogger(DonationController.class);
    @Autowired

    private DonationRepository donationRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    private String localPlan;
    private Integer localAmount;

    private String localFirstName;
    private String localLastName;

    private String localTitle;
    private String localEmail;

    private String localPhoneNumber;

    private String localCardHolder;

    private String localExpiry;

    private String localCvv;
    private String localSecurityCardNumber;

    private Boolean isAnoniem = false;



    @GetMapping("/donation")
    public String donation(Model model, Principal principal){
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);
        model.addAttribute("planForm",true);
        return "donation";
    }

    @GetMapping("donation/plan")
    public String donationPlanForm(Model model, Principal principal,@RequestParam(required=false)String plan,Integer amount,Integer ownAmount,String anonymous){

        localPlan = plan;

        if(ownAmount==null){
            localAmount = amount;
        }else{
            localAmount = ownAmount;
        }

        if(anonymous == null){
            model.addAttribute("openContactInfo",true);
            model.addAttribute("openCheckout",false);
            isAnoniem = false;
        }

        else if(anonymous.equals("true")){
            model.addAttribute("openContactInfo",false);
            model.addAttribute("openCheckout",true);
            localFirstName = null;
            localLastName = null;
            isAnoniem = true;
        }

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        if(loginName != "NOBODY"){
            AppUser appuser = appUserRepository.findByUsername(principal.getName());
            localFirstName = appuser.getFirstName();
            localLastName = appuser.getLastName();
        }

        model.addAttribute("localFirstName",localFirstName);
        model.addAttribute("localLastName",localLastName);
        return "donation";
    }

    @GetMapping("donation/info")
    public String donationInfoForm(Model model, Principal principal,@RequestParam(required=false)String title,String firstName,String lastName,String email,String phoneNumber){

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        localTitle = title;
        localFirstName = firstName;
        localLastName = lastName ;
        localEmail = email;
        localPhoneNumber = phoneNumber;

        model.addAttribute("openCheckout",true);

        return "donation";
    }
    @GetMapping("donation/checkout")
    public String donationCheckoutForm(Model model, Principal principal,@RequestParam(required=false)String cardHolder,String cardNumber,String expiry,String cvv){
        localCardHolder = cardHolder;
        localExpiry = expiry;
        localCvv = cvv;

        String securityCardNumber = "*******" + cardNumber.substring(12,15) ;
        localSecurityCardNumber = securityCardNumber;

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        model.addAttribute("openSave",true);
        model.addAttribute("localPlan",localPlan);
        model.addAttribute("localAmount",localAmount);
        model.addAttribute("localFirstName",localFirstName);
        model.addAttribute("localLastName",localLastName);
        model.addAttribute("localEmail",localEmail);
        model.addAttribute("isAnoniem",isAnoniem);

        model.addAttribute("localSecurityCardNumber",localSecurityCardNumber);
        return "donation";
    }

    @ModelAttribute("donation")
    public Donation findDonation(@PathVariable(required = false) Integer id) {
        return new Donation();
    }

    @GetMapping("donation/save")
        public String donationSave(Model model){
        return "donation";
    }

    @PostMapping("donation/save")
    public String newDonate(Model model, Donation donation) {
        donation.setPlan(localPlan);
        donation.setAmount(localAmount);

        if(isAnoniem){
            donation.setTitle(null);
            donation.setFirstName(null);
            donation.setLastName(null);
            donation.setEmail(null);
            donation.setPhoneNumber(null);
            donation.setAnonymous(true);
        }else{
            donation.setTitle(localTitle);
            donation.setFirstName(localFirstName);
            donation.setLastName(localLastName);
            donation.setEmail(localEmail);
            donation.setPhoneNumber(localPhoneNumber);
            donation.setAnonymous(false);
        }


        donation.setCardHolder(localCardHolder);
        donation.setExpiry(localExpiry);
        donation.setCvv(localCvv);
        donation.setCardNumber(localSecurityCardNumber);
        donationRepository.save(donation);
        return "donation";
    }
}
package com.lbm.app.controller;

import com.lbm.app.model.Account;
import com.lbm.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/accounts")
public class AccountsController
{
    @Autowired
    @Qualifier(value="accService")
    AccountService accService;

    @RequestMapping(value="/", method= RequestMethod.POST)
    public ResponseEntity<String> createAccount(@RequestBody Account acc){
        accService.addAccount(acc);
        return new ResponseEntity<>("Account is Created",HttpStatus.OK);
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<>(accService.getAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value="/{accNo}",method= RequestMethod.GET)
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accNo){
        return new ResponseEntity<>(accService.getAccountByNumber(accNo),HttpStatus.OK);
    }

    @RequestMapping(value="/{accNo}",method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@PathVariable String accNo){
        accService.deleteAccount(accNo);
        return new ResponseEntity<>("Account is successfuly deleted",HttpStatus.OK);
    }
}

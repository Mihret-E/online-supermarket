package com.act.onlinesupermarket.controllers;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Purchase;
import com.act.onlinesupermarket.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/api/accounts")
    public Account createAccount(@RequestBody Account account){

       return accountService.registerAccount(account);
    }
    @GetMapping("/api/accounts")
    public Iterable<Account> getAllAccount(){

        return accountService.getAllAccounts();
    }

}

package com.act.onlinesupermarket.services;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account registerAccount (Account account){
        return accountRepository.save(account);

    }
    public Iterable<Account> getAllAccounts(){

        return accountRepository.findAll();
    }

}

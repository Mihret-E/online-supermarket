package com.act.onlinesupermarket.repositories;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}

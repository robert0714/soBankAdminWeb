package com.iisigroup.product.secure.service;

import com.iisigroup.product.secure.domain.AccountPo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 

public interface AccountService {
    List<AccountPo> findAll();
    AccountPo findById(Long id);
    AccountPo save(AccountPo AccountPo);
    Page<AccountPo> findAllByPage(Pageable pageable);
}

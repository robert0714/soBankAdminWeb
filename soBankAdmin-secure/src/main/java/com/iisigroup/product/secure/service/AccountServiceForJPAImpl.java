package com.iisigroup.product.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.iisigroup.product.secure.dao.AccountRepository;
import com.iisigroup.product.secure.domain.AccountPo;

@Repository
@Transactional
public class AccountServiceForJPAImpl implements AccountService {
    private AccountRepository repository;
	

    @Override
    @Transactional(readOnly=true)
    public List<AccountPo> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    @Transactional(readOnly=true)
    public AccountPo findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public AccountPo save(AccountPo AccountPo) {
        return repository.save(AccountPo);
    }

    @Autowired
    public void setAccountRepository(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly=true)
    public Page<AccountPo> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

package com.iisigroup.product.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.iisigroup.product.secure.dao.FuncRepository;
import com.iisigroup.product.secure.domain.FuncPo;

@Repository
@Transactional
public class FuncServiceForJPAImpl implements FuncService {
    private FuncRepository repository;
	

    @Override
    @Transactional(readOnly=true)
    public List<FuncPo> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    @Transactional(readOnly=true)
    public FuncPo findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public FuncPo save(FuncPo AccountPo) {
        return repository.save(AccountPo);
    }

    @Autowired
    public void setContactRepository(FuncRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly=true)
    public Page<FuncPo> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

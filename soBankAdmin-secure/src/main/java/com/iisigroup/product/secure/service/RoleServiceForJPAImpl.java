package com.iisigroup.product.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.iisigroup.product.secure.dao.RoleRepository;
import com.iisigroup.product.secure.domain.RolePo;

@Repository
@Transactional
public class RoleServiceForJPAImpl implements RoleService {
    private RoleRepository repository;
	

    @Override
    @Transactional(readOnly=true)
    public List<RolePo> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    @Transactional(readOnly=true)
    public RolePo findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public RolePo save(RolePo AccountPo) {
        return repository.save(AccountPo);
    }

    @Autowired
    public void setContactRepository(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly=true)
    public Page<RolePo> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

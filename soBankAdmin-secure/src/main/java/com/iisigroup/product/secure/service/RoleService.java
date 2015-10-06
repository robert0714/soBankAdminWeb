package com.iisigroup.product.secure.service;

import com.iisigroup.product.secure.domain.RolePo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RoleService {
    List<RolePo> findAll();
    RolePo findById(Long id);
    RolePo save(RolePo RolePo);
    Page<RolePo> findAllByPage(Pageable pageable);
}

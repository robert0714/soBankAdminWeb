package com.iisigroup.product.secure.service;

import com.iisigroup.product.secure.domain.FuncPo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 

public interface FuncService {
    List<FuncPo> findAll();
    FuncPo findById(Long id);
    FuncPo save(FuncPo FuncPo);
    Page<FuncPo> findAllByPage(Pageable pageable);
}

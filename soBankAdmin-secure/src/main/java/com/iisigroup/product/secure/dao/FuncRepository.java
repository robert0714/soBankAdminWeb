package com.iisigroup.product.secure.dao;

import com.iisigroup.product.secure.domain.FuncPo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FuncRepository extends PagingAndSortingRepository<FuncPo, Long> {
}

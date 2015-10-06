package com.iisigroup.product.secure.dao;

import com.iisigroup.product.secure.domain.AccountPo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<AccountPo, Long> {
}

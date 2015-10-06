package com.iisigroup.product.secure.dao;

import com.iisigroup.product.secure.domain.RolePo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<RolePo, Long> {
}

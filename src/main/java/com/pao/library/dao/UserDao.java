package com.pao.library.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pao.library.entity.Pengguna;

public interface UserDao extends PagingAndSortingRepository<Pengguna, String>{

}

package com.pao.library.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pao.library.entity.Peserta;


public interface PesertaDao extends PagingAndSortingRepository<Peserta, String> {

}

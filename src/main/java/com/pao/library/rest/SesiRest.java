package com.pao.library.rest;

import java.awt.print.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pao.library.dao.PesertaDao;
import com.pao.library.dao.SesiDao;
import com.pao.library.entity.Peserta;
import com.pao.library.entity.Sesi;

@RestController
public class SesiRest {

	@Autowired
	private SesiDao sesidao;
	
	@Autowired
	private PesertaDao pesertadao;
	
	@RequestMapping(value = "/sesi", method = RequestMethod.GET)
	public Iterable<Sesi> listAll(Pageable page){
		return sesidao.findAll();
	}
	
	@RequestMapping(value = "/peserta", method = RequestMethod.GET)
	public Iterable<Peserta> listAllPeserta(Pageable page){
		return pesertadao.findAll();
	}
	
	@RequestMapping(value="/peserta/{id}", method=RequestMethod.GET)
	public ResponseEntity<Peserta> findById(@PathVariable("id") String id){
		Peserta result = pesertadao.findOne(id);
		if(result==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/sesi", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody @Valid Sesi sesi){
		sesidao.save(sesi);
	}
	
	@RequestMapping(value="/peserta", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void savepeserta(@RequestBody @Valid Peserta p){
		
		pesertadao.save(p);
	}
	
	@RequestMapping(value="/sesi/{id}",method=RequestMethod.DELETE)
	public void deleteSesi(@PathVariable("id") String id){
		sesidao.delete(id);
	}
	
	@RequestMapping(value="/peserta/{id}", method=RequestMethod.DELETE)
	public void deletePeserta(@PathVariable("id") String id){
		pesertadao.delete(id);
	}
}

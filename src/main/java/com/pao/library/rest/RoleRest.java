package com.pao.library.rest;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pao.library.dao.RoleDao;
import com.pao.library.entity.Hakakses;

@RestController
public class RoleRest {
	
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping(value="role", method=RequestMethod.GET)
	public Iterable<Hakakses> listAll(Pageable page){
		return roleDao.findAll();
	}
	
	@RequestMapping(value="role/{id}", method=RequestMethod.GET)
	public ResponseEntity<Hakakses> getById(@PathParam("id")String id){
		Hakakses result = roleDao.findOne(id);
		if(result == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(result, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="role", method=RequestMethod.POST)
	public void save(@RequestBody @Valid Hakakses role){
		roleDao.save(role);
	}
	
	@RequestMapping(value="role/{id}", method=RequestMethod.PUT)
	public void update(@PathParam("id") String id, @RequestBody @Valid Hakakses role){
		role.setId(id);
		roleDao.save(role);
	}
	
	@RequestMapping(value="role/{id}", method=RequestMethod.DELETE)
	public void delete(@PathParam("id")String id){
		roleDao.delete(id);
	}
	
}

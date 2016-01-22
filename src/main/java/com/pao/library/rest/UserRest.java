package com.pao.library.rest;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pao.library.dao.UserDao;
import com.pao.library.entity.Hakakses;
import com.pao.library.entity.Pengguna;

@RestController
public class UserRest {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="user", method=RequestMethod.GET)
	public Iterable<Pengguna> listAllUser(Pageable page){
		return userDao.findAll(page);
	}
	
	@RequestMapping(value="user/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pengguna> getUserById(@PathParam("id") String id){
		Pengguna result = userDao.findOne(id);
		if(result == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="user/{id}", method=RequestMethod.DELETE)	
	public void delete(@PathVariable("id") String id){
		userDao.delete(id);
	}
	
	@RequestMapping(value="user", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody @Valid Pengguna user){
//		Role role = new Role();
//		role.setId("r001");
//		user.getRoleUser().add(role);
		userDao.save(user);
	}
	
	@RequestMapping(value="user/{id}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@PathParam("id")String id, @RequestBody @Valid Pengguna user){
		user.setId(id);
		userDao.save(user);
	}
	
}

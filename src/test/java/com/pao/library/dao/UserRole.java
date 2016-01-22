package com.pao.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pao.library.PaoApplication;
import com.pao.library.entity.Peserta;
import com.pao.library.entity.Hakakses;
import com.pao.library.entity.Sesi;
import com.pao.library.entity.Pengguna;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PaoApplication.class)
public class UserRole {

	@Autowired
	private UserDao userdao;

	@Autowired
	private SesiDao sesidao;

	// @Autowired
	// private DataSource ds;

	//@Test
	public void testInsertUserDao() {
		Hakakses role = new Hakakses();
		role.setId("r001");

		Hakakses r2 = new Hakakses();
		r2.setId("4e3b711d-b53f-4fe3-aebb-6d6406e34c6f");

		Pengguna user = new Pengguna();
		user.setUsername("khoiroh");
		user.setPassword("passwd");
		user.setEnabled(true);
		user.setFullName("khoroh khoir");
		user.setAddress("mojo");
		user.setEmail("khor@mail.com");
		user.setPhone("3092424234");
		user.getRoleUser().add(role);
		user.getRoleUser().add(r2);
		userdao.save(user);
		System.out.println("id userbaru: " + user.getId());

	}

	@Test
	public void testSaveSesi() throws Exception {
		Peserta p1 = new Peserta();
		p1.setId("aacdf134-7072-4343-b61e-3bb5585e8037");

		Peserta p2 = new Peserta();
		p2.setId("dd5a053e-a05e-48f6-8624-801be913a6e4");

		Sesi s = new Sesi();
		s.setName("java programming");
		s.getDaftarPeserta().add(p1);
		s.getDaftarPeserta().add(p2);
		sesidao.save(s);
	}
}

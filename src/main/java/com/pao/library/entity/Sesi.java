package com.pao.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Sesi {

	@Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	private String name;
	
//	@JsonIgnore
	@ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(
            name = "peserta_pelatihan",
            joinColumns = @JoinColumn(name = "id_sesi"),
            inverseJoinColumns = @JoinColumn(name = "id_peserta")
    )
    private List<Peserta> daftarPeserta = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Peserta> getDaftarPeserta() {
		return daftarPeserta;
	}

	public void setDaftarPeserta(List<Peserta> daftarPeserta) {
		this.daftarPeserta = daftarPeserta;
	}

	
}

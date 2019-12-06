package com.maybank.emaiApp.Models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tbl_demo_tm")
public class DemoSelfieModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "nikId", updatable = false, nullable = false)
	private UUID nikId;
	private String nik;
	private String nama;
	@Column(name = "foto", length=4000)
	private String foto;
	
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public UUID getId() {
		return nikId;
	}
	public void setId(UUID id) {
		this.nikId = id;
	}
	
	
}

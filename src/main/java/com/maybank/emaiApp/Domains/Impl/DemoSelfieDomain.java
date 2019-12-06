package com.maybank.emaiApp.Domains.Impl;

import java.util.UUID;

import com.maybank.emaiApp.Domains.BaseClassDomain;

public class DemoSelfieDomain extends BaseClassDomain {
	private String nik;
	private String nama;
	private String foto;
	private UUID nikId;
	
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

package com.cartoes.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "data_Transacao", nullable = false)
	private Date dataTransacao;

	@Column(name = "CNPJ", nullable = false, length = 14, unique = true)
	private String CNPJ;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "qdt_Parcelas", nullable = false)
	private int qdtParcelas;
	
	@Column(name = "juros", nullable = false)
	private Double juros;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Cartao cartao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	public String getCnpj() {
		return CNPJ;
	}

	public void setCnpj(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getQdtParcelas() {
		return qdtParcelas;
	}

	public void setqdtParcelas(int qdtParcelas) {
		this.qdtParcelas = qdtParcelas;
	}
	
	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void Cartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataTransacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		dataTransacao = new Date();
	}
	
	@Override
	public String toString() {
		return "Transacao[" + "id=" + id + "," + "dataTransacao" + dataTransacao + "," + "CNPJ=" + CNPJ + "," + "valor=" + valor + ","
				+ "qdtParcelas=" + qdtParcelas + "," + "juros=" + juros +  "]";
	}
}
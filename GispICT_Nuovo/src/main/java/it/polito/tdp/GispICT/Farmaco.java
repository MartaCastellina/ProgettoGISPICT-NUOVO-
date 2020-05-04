package it.polito.tdp.GispICT;

import java.util.Date;

public class Farmaco {
	private String Nome;
	private Date Scadenza;
    private int FID;
    private int Conservazione;
    private String Link;
    private int riordino;
    
	public Farmaco(int fID, String nome, int conservazione, String link, int riordino) {
		super();
		Nome = nome;
		FID = fID;
		Conservazione = conservazione;
		Link = link;
		this.riordino = riordino;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getScadenza() {
		return Scadenza;
	}
	public void setScadenza(Date scadenza) {
		Scadenza = scadenza;
	}
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	public int getConservazione() {
		return Conservazione;
	}
	public void setConservazione(int conservazione) {
		Conservazione = conservazione;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public int getRiordino() {
		return riordino;
	}
	public void setRiordino(int riordino) {
		this.riordino = riordino;
	}
	
}

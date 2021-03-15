package com.example.AKDProject;

import javax.persistence.*;

@Entity
@Table(name="podaci")
public class createDB {

	
	@Id
	@Column(name="godinaRodjenja")
	private  int godinaRodjenja;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	
	public createDB( String ime, int godinaRodjenja, String prezime) {
		this.ime=ime;
		this.godinaRodjenja=godinaRodjenja;
		this.prezime=prezime;
	 
}
	
	public String getIme(){
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime=ime;
   }
	
	
	
	 public int getGodinaRodjenja(){
			return this.godinaRodjenja;
		}
	
	 public void setgodinaRodjenja(int godinaRodjenja) {
			this.godinaRodjenja = godinaRodjenja;
			}
			
	
		
	public String getPrezime(){
		return this.prezime;
	}
			
     public void setPreziem(String prezime) {
				this.prezime=prezime;
			}
			
	



	@Override
	public String toString() {
		return "createDB [ime=" + ime + ", prezime=" + prezime + ", godinaRodjenja=" + godinaRodjenja + "]";
	}
	


	



}

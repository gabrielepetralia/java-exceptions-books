package org.java.exceptions.book;

public class Libro {
	private String titolo;
	private int numPagine;
	private String autore;
	private String editore;
	
	public Libro(String titolo, int numPagine, String autore, String editore) throws Exception  {
		setTitolo(titolo);
		setNumPagine(numPagine);
		setAutore(autore);
		setEditore(editore);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		
		if (titolo.isBlank())
			throw new Exception("Il titolo non può essere vuoto");
		
		this.titolo = titolo;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) throws Exception {
		if (numPagine <= 0)
			throw new Exception("Il numero di pagine deve essere superiore a 0");
		
		this.numPagine = numPagine;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) throws Exception {
		
		if (autore.isBlank())
			throw new Exception("L'autore non può essere vuoto");
		
		this.autore = autore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) throws Exception {
		
		if (editore.isBlank())
			throw new Exception("L'editore non può essere vuoto");
		
		this.editore = editore;
	}
	
	public String toString() {
		return "Titolo: " + getTitolo() + " | "  + "Numero Pagine: " + getNumPagine() + " | " + "Autore: " + getAutore() + " | " + "Editore: " + getEditore();
	}
}

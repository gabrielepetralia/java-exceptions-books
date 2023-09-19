package org.java.exceptions.book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private static final String FILE_PATH = "./java-books.txt";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Numero di libri da inserire: ");
		int n = Integer.valueOf(sc.nextLine());
		
		System.out.println("\n-------------------------------------");
		
		Libro[] libri = new Libro[n];
		
		for(int i=0; i<n; i++) {
		
			try {
				System.out.println("\nLibro " + (i+1) + "\n");
				
				System.out.print("Titolo: ");
				String titolo = sc.nextLine();
				
				System.out.print("Numero pagine: ");
				int numPagine = Integer.valueOf(sc.nextLine());
				
				System.out.print("Autore: ");
				String autore = sc.nextLine();
				
				System.out.print("Editore: ");
				String editore = sc.nextLine();
				
				libri[i] = new Libro(titolo, numPagine, autore, editore);
			} catch (Exception e) {
				System.err.println("\nDati libro non validi: " + e.getMessage());
				
				i--;
			}	
		}
		
		sc.close();
		
		if(n>0) System.out.println("\n-------------------------------------");
		
		// scrittura sul file
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(FILE_PATH, true);
		
			for (int i=0; i<n; i++) {
				myWriter.write(libri[i].toString() + "\n");
			}
			
		} catch (IOException e) {
			System.err.println("Errore nella scrittura del file: " + e.getMessage());
		} finally {
			
			try {
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// lettura dal file
		File booksFile = new File(FILE_PATH);
		Scanner reader = null;
		int countLine = 0;
		
		System.out.println("Lista libri\n");
		
		try {
			reader = new Scanner(booksFile);
			
			while (reader.hasNextLine()) {
				countLine++;
				System.out.print("Libro " + countLine +": ");
				
				String line = reader.nextLine();
				System.out.println(line);
			}
		} catch (Exception e) { 
			System.out.println("Errore nella lettura del file: " + e.getMessage());
		} finally {
			if (reader != null)
				reader.close();
		}
		
	}
}

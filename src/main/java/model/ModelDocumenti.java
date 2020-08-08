package model;

import java.io.InputStream;
import java.sql.Blob;

public class ModelDocumenti {
	private int id;
	private byte[] documento;
	private String nome;
	private Blob file;
	private InputStream file2;
	
	
	public InputStream getFile2() {
		return file2;
	}
	public void setFile2(InputStream file2) {
		this.file2 = file2;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getDocumento() {
		return documento;
	}
	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

package Prog_AEP;

import java.util.Date;

public class BilheteAereo {
	private Integer voo;
	private String origem;
	private String destino;
	private Date data;
	
	public BilheteAereo(Integer voo, String origem, String destino, Date data) {
		this.voo = voo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
	}
	
	public Integer getVoo() {
		return voo;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public Date getData() {
		return data;
	}
}

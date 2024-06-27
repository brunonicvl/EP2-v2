package usp.mac321.ep2;

import java.util.*;

public class TipoReceita implements TipoOperacao {
	String nomeDoTipo;
	boolean sub;
	TipoReceita tipoDerivado;
	List<TipoReceita> subcategorias = new ArrayList<TipoReceita>();
	boolean despesa = false;


	TipoReceita(String n){
		nomeDoTipo = n;
		sub = true;
	}
	
	TipoReceita(String n, List<TipoReceita> t){
		nomeDoTipo = n;
		subcategorias = t;
		sub = false;
	}
	
	TipoReceita(String n, boolean b){
		nomeDoTipo = n;
		sub = b;
	}
	
	public void setTipoDerivado(TipoReceita t) {
		tipoDerivado = t;
	}
	
	public void setSubcategorias(List<TipoReceita> t) {
		subcategorias = t;
	}
	
	@Override
	public String getNome() {
		return nomeDoTipo;
	}
	
	public String getSubcategoria() {
		String sc = "Categoria: " + this.getNome() + " Subcategorias: ";
		
		for (TipoReceita t: subcategorias) {
			sc += t.getNome() +  " ";
		}
		
		return sc;
	}
	@Override
	public String toString() {
		if(sub) {
			return tipoDerivado.toString() + ": " + nomeDoTipo;
		}
		
		return nomeDoTipo;
	}
	
	public boolean isSub() {
		return sub;
	}

	public boolean isDespesa() {
		return despesa;
	}

	public List<TipoReceita> getListaSubcategorias() {
		return subcategorias;
	}
}

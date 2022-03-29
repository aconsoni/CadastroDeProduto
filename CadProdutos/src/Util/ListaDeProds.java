package Util;

import java.util.ArrayList;
import java.util.List;

import ProdInfo.Produto;

	public class ListaDeProds {
	// CLASSE FEITA PARA QUE NA HORA DE CHAMAR A LISTA DE PRODUTOS, FIQUE DE UMA FORMA MAIS FÁCIL DE VISUALIZAÇÃO E CHAMADA
	
		private static List<Produto> listaDeProds = new ArrayList<Produto>();
	
		public static List<Produto> getInstance(){
			return listaDeProds;
	}

}

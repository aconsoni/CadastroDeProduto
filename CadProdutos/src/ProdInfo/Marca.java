package ProdInfo;

public class Marca {
	
		//INFORMACOES SOBRE A MARCA DO PRODUTO
		private String nome;
		private String preco;
	
		public Marca() {
		
		}
	
	
		public Marca (String[] atributos) {
			// PUXA AS INFORMAÇÕES DA CLASSE PRODUTOS, E COLOCA AS INFORMAÇÕES DO PRODUTO E AS INFORMAÇÕES DA MARCA DE FORMA ORGANIZADA	
			String[] rua = atributos[3].split("=");
		
			this.nome = rua[1].trim();
			this.preco = atributos[4].trim();
				
		}	
	
		//GET'S E SET'S DE CADA INFORMACAO
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getPreco() {
			return preco;
		}
		public void setPreco(String preco) {
			this.preco = preco;
		}
	
		//TO STRING (A FORMA COMO VAI APARECER NO CONSOLE)
		@Override
		public String toString() {
			return  nome + ", R$" + preco + ""; 
		
	} 
} 

package ProdInfo;

	public class Produto {
	
		//INFORMACOES SOBRE O PRODUTO 
		private String cat;
		private String nome;
		private Marca marca; //MARCA VAI SER PUXADO DA CLASSE MARCA
	
		public Produto(String dados) {
			// PUXA AS INFORMAÇÕES DA CLASSE PRODUTOS, E COLOCA AS INFORMAÇÕES DO PRODUTO E AS INFORMAÇÕES DA MARCA DE FORMA ORGANIZADA
		
			String[] atributos = dados.split(",");
	
			String[] cat = atributos[1].split("=");
			String[] nome = atributos[2].split("=");
		
			Marca marca = new Marca (atributos);
		
			this.cat = cat[1].trim();
			this.nome = nome[1].trim();
			this.marca = marca;		
		}
	
	
		public Produto() {
		}
		
		//GET'S E SET'S DE CADA INFORMACAO 
		public String getCat() {
			return cat;
		}
		
		public void setCat(String cat) {
			this.cat = cat;
		}
		
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public Marca getMarca() {
			return marca;
		}
	
		public void setMarca(Marca marca) {
			this.marca = marca;
		}
		
		//TO STRING (A FORMA COMO VAI APARECER NO CONSOLE)
		@Override
		public String toString() {
			return "Produto, " + "Categoria = " + cat + ", Nome= " + nome + ", Marca= " + marca + ""; 
	} 
} 

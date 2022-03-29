package View;

import java.io.BufferedReader;
import java.io.IOException;
import ProdInfo.Produto;
import Util.ListaDeProds;


	public class ViewCrudProd {

		public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		// MOSTRA AS INFORMAÇÕES VISUAIS DA CLASSE PRINCIPAL 
			System.out.println("1 - Cadastrar Produtos\n"
					+ "2 - Listar Produtos\n"
					+ "3 - Deletar Produtos\n"
					+ "4 - Editar Produtos\n"
					+ "5 - Sair");

			return Integer.parseInt(reader.readLine());	
	}
	
		public static String[] ViewMenuSalvarProd(BufferedReader reader) throws IOException {
		// MOSTRA AS INFORMAÇÕES VISUAIS DA CLASSE SALVAR
			String[] menuProduto = {"Categoria", "Nome","Marca: \n Nome",
																"Preço"};
			String[] dadosProduto = {"","","",""};
		
			for(int i=0; i < menuProduto.length; i++) {
				System.out.println(menuProduto[i]);
				dadosProduto[i] = reader.readLine();			
		}
			
			return dadosProduto;
	}
	
		public static int ViewMenuEditaOuDeletarProduto(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		
		// MOSTRA AS INFORMAÇÕES VISUAIS DA CLASSE EDITAR E DELETAR

			for (int i = 0; i < ListaDeProds.getInstance().size(); i++)
				System.out.println(i + " - " + ListaDeProds.getInstance().get(i));

			System.out.println();
			System.out.println("Dentre a lista acima, escolha o indice do produto que deseja "+ editar_deletar);
						
			return Integer.parseInt(reader.readLine());
	}

		public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException {
		// MOSTRA AS INFORMAÇÕES VISUAIS DA CLASSE EDITAR
		
			String[] dadosEditados = {"" ,""};
		
			System.out.println("Escolha o atributo que deseja alterar:");
			System.out.println("1 - Categoria\n"
					+ "2 - Nome\n"
					+ "3 - Marca\n"
					+ "4 - Preço\n");
		
			dadosEditados[0] = reader.readLine();
			System.out.println("Escreva o novo valor do atributo");
			dadosEditados[1] = reader.readLine();
		
			return dadosEditados;
	}
	
		public static void ViewListaDeProdutosEditadas() {
			// MOSTRA A LISTA JÁ EDITADA
		
			for (Produto p : ListaDeProds.getInstance()) {
				System.out.println("PRODUTO");
				System.out.println("Categoria = " + p.getCat());
				System.out.println("Nome = " + p.getNome());
				System.out.println("Marca = " + p.getMarca().getNome());
				System.out.println("Preço = " + p.getMarca().getPreco());
			
		}
		
			System.out.println();
		
	}
	
		public static void ViewMsgFinal(int op) {
		// MOSTRA A MENSAGEM FINAL DO PROGRAMA AO USUÁRIO
		
			String[] msgFinal = {"Produto salvo com sucesso!!",
								 "Produto editado com sucesso!!",
								 "Produto deletado com sucesso!!",
								 "Fim do Programa!!"};
		
			System.out.println(msgFinal[op]);
	}
}

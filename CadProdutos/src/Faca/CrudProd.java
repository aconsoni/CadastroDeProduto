package Faca;

import java.io.BufferedReader; //IMPORTADOS
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDados.ManiArqXml;
import BancoDados.ManipulaTxt;
import ProdInfo.Produto;
import Util.ListaDeProds;
import View.ViewCrudProd;
import ProdInfo.Marca;

	public class CrudProd {
	

		public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {
			// O MÉTODO SALVAR ARQUIVO, LÊ TODAS AS INFORMAÇÕES RECEBIDAS E SALVA NO ARQUIVO TXT DENTRO DO ARQUIVO TX, INFORMAÇÃO POR INFOMAÇÃO
		
			Produto prod = new Produto ();
			Marca marca = new Marca ();
			String[] dadosProduto = ViewCrudProd.ViewMenuSalvarProd(reader);
					
			prod.setCat(dadosProduto[0]);
			prod.setNome(dadosProduto[1]);
			marca.setNome(dadosProduto[2]);
			marca.setPreco(dadosProduto[3]);
			prod.setMarca(marca);
			
			ListaDeProds.getInstance().add(prod);
			
			ManipulaTxt.SalvarArquivoTxt();
			ManiArqXml.SalvarArquivoXML();
	}
	
			public static void ListarProdutoSalvos() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
			// O MÉTODO LISTAR PRODUTOS, LISTA TODAS AS INFORMAÇÕES RECEBIDAS E APRESENTA PARA O USUÁRIO NO CONSOLE
		   
					ListaDeProds.getInstance().clear();
					ManipulaTxt.LerArquivoTxt();
					ManiArqXml.LerArquivoXML();
					ViewCrudProd.ViewListaDeProdutosEditadas();
		   
	}
			public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
			// O MÉTODO DELETAR PRODUTOS, DELETA OS PRODUTOS CADASTRADOS, DEPOIS É LISTADO AO USUÁRIO, A LISTA SEM O PRODUTO DELETADO

				int indice = ViewCrudProd.ViewMenuEditaOuDeletarProduto("deletar", reader);

				ListaDeProds.getInstance().remove(indice);
				ManipulaTxt.SalvarArquivoTxt();
				ManiArqXml.SalvarArquivoXML();
	   }
			
			public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException {
			// O MÉTODO EDITAR PRODUTOS, EDITA AS INFORMAÇÕES QUE O USUÁRIO DESEJA EDITAR, DEPOIS É LISTADO AO USUÁRIO, A INFORMAÇÃO JÁ EDITADA
			
				String[] dadosEditados = {"" , ""};
				int indice = ViewCrudProd.ViewMenuEditaOuDeletarProduto("editar", reader);
			
				Produto prod = ListaDeProds.getInstance().get(indice);
			
				dadosEditados = ViewCrudProd.ViewOpcaoEdicao(reader);
				
				switch(Integer.parseInt(dadosEditados[0])) {
				case 1:
					prod.setCat(dadosEditados[1]);
					break;
					
				case 2:
					prod.setNome(dadosEditados[1]);
					break;
					
				case 3:
					prod.getMarca().setNome(dadosEditados[1]);
					break;
				
				case 4:
					prod.getMarca().setPreco(dadosEditados[1]);
					break;
					
				}
				
				ListaDeProds.getInstance().set(indice, prod);
				ManipulaTxt.SalvarArquivoTxt();
	
				}
		}
	

package Faca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import View.ViewCrudProd;

	public class MetMain {
		
			public static void main (String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {  
			// O MÉTODO MAIN, MOSTRA AS FUNÇÕES QUE O USUÁRIO PODE FAZER, O PRÓPRIO MENU
		
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
				int menu = 0;
				while (menu != 5) {
					menu = ViewCrudProd.ViewMenuPrincipal(reader);
					
					switch (menu) {
				case 1:
					CrudProd.SalvarProduto(reader);
					break;
				case 2:
					CrudProd.ListarProdutoSalvos();
					break;
				case 3:
					CrudProd.DeletarProduto(reader);
					break;
				case 4:
					CrudProd.EditarProduto(reader);
					break;
				case 5:
					ViewCrudProd.ViewMsgFinal(3);
					break;
				
				}
				
			}
		
		 }
 
	 }

   
	

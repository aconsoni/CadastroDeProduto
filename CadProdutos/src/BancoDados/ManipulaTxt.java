package BancoDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import ProdInfo.Produto;
import Util.ListaDeProds;

public class ManipulaTxt {

	private static String NomeDoArquivo = "CadDeProduto.Txt";

		public static void SalvarArquivoTxt() throws IOException {
		  // O M�TODO SALVAR ARQUIVO, L� TODAS AS INFORMA��ES RECEBIDAS E SALVA NO ARQUIVO TXT DENTRO DO ARQUIVO TXT, INFORMA��O POR INFOMA��O
		
			try (BufferedWriter buffer = new BufferedWriter(new FileWriter(NomeDoArquivo));
					PrintWriter pw = new PrintWriter(buffer)) {
				for (Produto p : ListaDeProds.getInstance())
					pw.println(p);
			} 
		}
	
		public static void LerArquivoTxt() throws IOException  {
			// O M�TODO LER ARQUIVO, L� TODAS AS INFORMA��ES RECEBIDAS E MOSTRA AO USU�RIO NO CONSOLE
		
			try (FileWriter arquivo = new FileWriter(NomeDoArquivo,true)){};
		
			String line;

			try (BufferedReader reader = new BufferedReader(new FileReader(NomeDoArquivo))) {

				while ((line = reader.readLine()) != null && !"".equals(line)) {
					Produto prod = new Produto(line);
					ListaDeProds.getInstance().add(prod);
				
			} 
		}
	} 
}
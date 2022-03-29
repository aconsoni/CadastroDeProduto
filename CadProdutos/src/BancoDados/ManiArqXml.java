package BancoDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XmlHandlerProds;
import ProdInfo.Produto;
import Util.ListaDeProds;

	public class ManiArqXml {
	
		private static String nomeDoArquivo = "CadDeProdutos.xml";

			public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
			// O MÉTODO SALVAR ARQUIVO, LÊ TODAS AS INFORMAÇÕES RECEBIDAS E SALVA NO ARQUIVO XML DENTRO DO ARQUIVO XML, INFORMAÇÃO POR INFOMAÇÃO

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.newDocument();
	
			Element prodsTag = doc.createElement("produtos");
				doc.appendChild(prodsTag);

			for(Produto p :ListaDeProds.getInstance()) {			
				Element prodTag = doc.createElement("produto");
					prodTag.setAttribute("id", "1");
					prodsTag.appendChild(prodTag);			
	
				Element catTag = doc.createElement("Categoria");
					catTag.setTextContent(p.getCat());
					prodTag.appendChild(catTag);	
	
				Element nomeTag = doc.createElement("Nome");
					nomeTag.setTextContent(String.valueOf(p.getNome()));
					prodTag.appendChild(nomeTag);	
	
				Element marcaTag = doc.createElement("Marca");
					prodTag.appendChild(marcaTag);
	
				Element ruaTag = doc.createElement("Nome");
					ruaTag.setTextContent(p.getMarca().getNome());
					marcaTag.appendChild(ruaTag);	
	
				Element preTag = doc.createElement("Preço");
					preTag.setTextContent(p.getMarca().getPreco());
					marcaTag.appendChild(preTag);
					
			
		}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans  = tf.newTransformer();
			
				trans.setOutputProperty( OutputKeys.INDENT,"yes");
				trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4" );
			
	
			DOMSource source = new DOMSource(doc);
	
				try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){			
					StreamResult result = new StreamResult(osw);	
						trans.transform(source, result);
			}
	
		}
	
			public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
				// O MÉTODO LER ARQUIVO, LÊ TODAS AS INFORMAÇÕES RECEBIDAS E MOSTRA AO USUÁRIO NO CONSOLE
		
					SAXParserFactory spf =  SAXParserFactory.newInstance();		
					SAXParser parser = spf.newSAXParser();
		
				try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
					InputSource source =  new InputSource(isr);
					XmlHandlerProds handler = new XmlHandlerProds();			
						parser.parse(source, handler);	
		}
		
	}


}

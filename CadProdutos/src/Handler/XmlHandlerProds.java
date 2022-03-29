package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ProdInfo.Marca;
import ProdInfo.Produto;


	public class XmlHandlerProds extends DefaultHandler{
	
		private StringBuilder texto;
		Produto produto;
		Marca marca;
	
		@Override
		public void startDocument() throws SAXException {
			// INICIA A PREPARAÇÃO DO DOCUMENTO
		}
	
		@Override
		public void endDocument() throws SAXException {
			// ENCERRA A PREPARAÇÃO DO DOCUMENTO
		}
	
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			// INICIA A INSERÇÃO DOS ELEMENTOS DENTRO DO ARQUIVO
			
			if(qName.equals("produto")) {			
				produto = new Produto();
				marca = new Marca();
			}else {
				texto = new StringBuilder();
			}
		}
	
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// ENCERRA A INSERÇÃO DOS ELEMENTOS DENTRO DO ARQUIVO
		
			if(qName.equals("Categoria")){
				produto.setCat(texto.toString());
			}else if(qName.equals("Nome")) {
				produto.setNome(texto.toString());
			}else if(qName.equals("Marca")) {
				marca.setNome(texto.toString());
			}else if(qName.equals("Preço")) {
				marca.setPreco(texto.toString());
			}

		}
		
	
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// VERIFICA OS CARACTERES
			texto.append(ch, start,length);		
		}
	
		@Override
		public void error(SAXParseException e) throws SAXException {
			// VERIFICA OS ERROS E REPASSA AO USUÁRIO
		
	}
	
	
	

}

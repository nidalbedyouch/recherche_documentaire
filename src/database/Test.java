package database;

import document.TokenDocument;
import document.TokenDocuments;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IndexDB indexDB=new IndexDB();
		
		TokenDocuments tokens=new TokenDocuments();
		tokens.addDocument("doc3");
		tokens.addDocumentPostion("doc4",125);
		
		indexDB.add("token4",tokens);
		for(TokenDocument doc : indexDB.getDocs("token4").getDocuments()){
			System.out.println(doc.getDocID()+"		"+doc.getFrequence());
		}

	}

}

package Index;

import java.util.Hashtable;

import database.IndexDB;
import document.TokenDocument;
import document.TokenDocuments;

public class Index {
	Hashtable<String,TokenDocuments> index;
	
	public Index(){
		IndexDB indexDB=new IndexDB();
		index=indexDB.getIndex();
	}
	
	public TokenDocuments getDocuments(String token){
		return index.get(token);
	}
	
	public TokenDocuments mergeAnd(TokenDocuments list1,TokenDocuments list2){
		TokenDocuments docs=new TokenDocuments();
		for(TokenDocument doc1 : list1.getDocuments()){
			for(TokenDocument doc2 : list2.getDocuments()){
				if(doc1.getDocID().equals(doc2.getDocID()))
					docs.addDoc(doc1);
			}
		}
		return docs;
	}
	
	public TokenDocuments mergeOR(TokenDocuments list1,TokenDocuments list2){
		list1.getDocuments().addAll(list2.getDocuments());
		return list1;
	}
	
	
	
}

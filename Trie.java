package algoritmos;
import java.util.*;


public class Trie {
	TrieNode root;
	int size;
	int wordc;
	
	public Trie(){
		root= new TrieNode(null);
	}
	
	class TrieNode{
		public static final int limit=3;
		TrieNode parent;
		String key;
		boolean empty;
		int wordc=0;
		TrieNode[] childs=new TrieNode[limit];
		public TrieNode(String _key){
			key=_key;
			empty=true;
		}
	}
	
	void add(String key )throws Exception{
		TrieNode cur=root, prv=root;
		//Stack<TrieNode>s=new Stack<TrieNode>();
		for(int i=0;i<key.length();i++){
			int pos=key.charAt(i)-'a';
			if(pos>=TrieNode.limit){
				throw new Exception();
			}
			prv=cur;
			if(cur.childs[pos]==null){
			  cur.childs[pos]= new TrieNode(null); 
			  cur.empty=false;
			}
			cur=cur.childs[pos];
			
			cur.parent=prv;
			//s.push(cur);
		}
		
		
		cur.key=key;
		cur.empty=true;
		size++;
	}
	
	String find(String key)throws Exception{
		TrieNode cur=root;
		for(int i=0;i<key.length();i++){
			int pos=key.charAt(i)-'a';
			if(pos>=TrieNode.limit) throw new Exception();
			if(cur==null)throw new Exception();
			cur=cur.childs[pos];
		}
		if (cur.key==null)throw new Exception();
		return cur.key;
	}
	String remove(String key)throws Exception{
		if(size==0)throw new Exception();
		TrieNode cur=root;
		int pos=0;
		
		//Stack<TrieNode> s=new Stack<TrieNode>();
		for(int i=0;i<key.length();i++){
			 pos=key.charAt(i)-'a';
			if(pos>=TrieNode.limit)throw new Exception();
			
			cur=cur.childs[pos];
			if(cur==null)throw new Exception();
			
		}
		String ret=cur.key;
		if(cur.empty==true){
			cur.parent=null;
			cur.childs[pos]=null;
			cur.key=null;
		}
		else
			cur.key=null;
		return ret;
		
		
		
		}
		
		
	
	
	
	public static void main(String[] args){
		Trie t=new Trie();
		try{
		t.add("aa");
		t.add("abc");
		t.add("bca");
		t.add("bcc");
		t.add("bcaa");
		
		t.remove("bcaa");
		System.out.println(t.find("abc"));
		System.out.println(t.find("aa"));
		System.out.println(t.find("bca"));
		System.out.println(t.find("bcc"));
		System.out.println(t.find("bcaa"));
		System.out.println(t.find("bcaaaaa"));
		//t.find("abc");
		//t.add("abc");
		//System.out.println(t.find("aa"));
		}catch(Exception e){}
	}

}

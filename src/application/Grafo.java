package application;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class Grafo {
	
	private UndirectedGraph<String, DefaultEdge> grafo ;         //il grafo è connesso?
	                                                            //quante componenti connesse ha?
                                                               //parole non raggiungibili da alcuna altra parola
	
	public void  buildGraph(){
		String a= "a";
		String b= "b";
		String c= "c";
		String d= "d";
		String e= "e";
		String f= "f";
		String g= "g";
		String h= "h";
		String i= "i";
		
		grafo= new SimpleGraph<String, DefaultEdge>(DefaultWeightedEdge.class);
		
		grafo.addVertex(a);
		grafo.addVertex(b);
		grafo.addVertex(c);
		grafo.addVertex(d);
		grafo.addVertex(e);
		grafo.addVertex(f);
		grafo.addVertex(g);
		grafo.addVertex(h);
		grafo.addVertex(i);
		
		for(String s1 : grafo.vertexSet()){
			for(String s2 : grafo.vertexSet()){
				if(!s1.equals(s2)){
					grafo.addEdge(s1,  s2);
					
				}
			}
		}
		System.out.println(grafo.toString());
	}
	
	
	
	public List<String> getVicini(String lettera){
		if(grafo.containsVertex(lettera)){
			List<String> vicini= Graphs.neighborListOf(grafo, lettera);
			System.out.println(vicini.toString());
			return vicini;
		}
		System.out.println("null");
		return null;
		
	}
	
	public List<String> getVisita(String lettera){
		BreadthFirstIterator<String, DefaultEdge> visita = new BreadthFirstIterator<String, DefaultEdge>(grafo, lettera);
		List<String> lettere = new LinkedList<String>();
		while(visita.hasNext()){
			String s = visita.next();
			lettere.add(s);
		}
		System.out.println(lettere);
		return lettere;
	}
	
	public int  getVisita1(){   //ke numero è ? cosa rappresenta?
		int contatore=0;
		for(String s1 : grafo.vertexSet()){
		BreadthFirstIterator<String, DefaultEdge> visita = new BreadthFirstIterator<String, DefaultEdge>(grafo, s1);
		while(visita.hasNext()){
			String s = visita.next();
			if(contatore!=0){
			  }
				contatore++;
			}
		}
		System.out.println(contatore);
		return contatore;
	}
	
	public List<String> paroleNonRaggiungibili(){     //ok
		List<String> nonRagg = new LinkedList<>();
		for(String s : grafo.vertexSet()){
			if(getNumConn(s)==0){
				nonRagg.add(s);
			}
		}
		System.out.println(nonRagg);
		return nonRagg;
	}
	
	private int getNumConn(String s) {  //ok
		int num=-1;
		 num = grafo.degreeOf(s);
		 System.out.println(num);
		 return num;
	}

	


	public static void main(String [] args){
		Grafo g = new Grafo();
		g.buildGraph();
//		g.getVicini("c");
//		g.getVisita("c");
		g.paroleNonRaggiungibili();
	}

}

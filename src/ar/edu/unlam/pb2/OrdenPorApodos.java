package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenPorApodos implements Comparator<Atracador>{

	@Override
	public int compare(Atracador o1, Atracador o2) {
		// TODO Auto-generated method stub
		return o1.getApodo().compareTo(o2.getApodo());
	}

	
}

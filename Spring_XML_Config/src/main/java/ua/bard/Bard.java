package ua.bard;

import ua.ballada.Ballada;

public class Bard {

	private Ballada ballada;
	
	private String name;
	
	public Bard() {
		System.out.println(name);
	}
	
	public void init() {
		System.out.println(name);
	}

	public void singing() {
		System.out.print(name+": ");
		ballada.song();
	}
	
	public void destroy() {
		System.out.println(name+": destroy");
	}

	public Ballada getBallada() {
		return ballada;
	}

	public void setBallada(Ballada ballada) {
		this.ballada = ballada;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

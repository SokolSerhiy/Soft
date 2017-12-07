package ua.ballada;

public class HeroBallada implements Ballada{
	
	
	public HeroBallada() {
		System.out.println("Ballada");
	}

	@Override
	public void song() {
		System.out.println("Hero ballada");
	}
}
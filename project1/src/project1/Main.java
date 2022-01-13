package project1;

public class Main {

	public static void main(String[] args) {
		Hola hola = new Hola();
		hola.setCasa("Casa");
		hola.setFinestres(5);
		Hola1 hola1 = new Hola1();
		hola1.setCasa("Casa");
		hola1.setFinestres(5);

		if (hola.equals(hola1))
			System.out.println("T'estimo.");
		else
			System.out.println("Et fots.");
	}

}
package Punto;

public class Punto2D implements Punto {

	protected Double coordX;
	protected Double coordY;

	public Punto2D() {

		this.coordX = 0.0;
		this.coordY = 0.0;
	}

	public Punto2D(Double x, Double y) {

		this.coordX = x;
		this.coordY = y;
	}

	public Double distancia(Object p) {

		Punto2D punto = (Punto2D) p;

		Punto2D resultado = new Punto2D();
		Double res;

		resultado.coordX = this.coordX - punto.coordX;
		resultado.coordY = this.coordY - punto.coordY;

		res = Math.sqrt(Math.pow(resultado.coordX, 2)
				+ Math.pow(resultado.coordY, 2));

		return res;
	}

	public Double modulo() {

		Double resultado;

		resultado = Math.sqrt(Math.pow(this.coordX, 2)
				+ Math.pow(this.coordY, 2));

		return resultado;
	}

	public String toString() {

		String retorno = new String("( " + this.coordX + " ; " + this.coordY
				+ " )");

		return retorno;
	}

	public boolean equals(Object p) {

		Punto2D punto = (Punto2D) p;

		if (this.coordX.equals(punto.coordX)
				&& this.coordY.equals(punto.coordY)) {

			return true;
		} else {

			return false;
		}
	}

	public void desplazamiento(Object p) {

		Punto2D punto = (Punto2D) p;

		this.coordX += punto.coordX;
		this.coordY += punto.coordY;

	}

	public Punto2D clone() {

		Punto2D resultado = new Punto2D(this.coordX, this.coordY);

		return resultado;
	}

	public static void main(String[] args) {

		Punto2D p1 = new Punto2D(3.0, 4.0);
		Punto2D p2 = new Punto2D(1.0, -4.0);

		p1.desplazamiento(p2);
		System.out.println(p1);

	}
}

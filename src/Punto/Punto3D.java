package Punto;
import static java.lang.System.out;

public class Punto3D extends Punto2D implements Punto {

	protected Double coordZ;

	public Punto3D() {

		super(0.0, 0.0);
		this.coordZ = 0.0;
	}

	public Punto3D(Double x, Double y, Double z) {

		super(x, y);
		this.coordZ = z;
	}

	@Override
	public Double distancia(Object p) {

		Punto3D punto = (Punto3D) p;

		Punto3D resultado = new Punto3D();
		Double res;

		resultado.coordX = this.coordX - punto.coordX;
		resultado.coordY = this.coordY - punto.coordY;
		resultado.coordZ = this.coordZ - punto.coordZ;

		res = Math.sqrt(Math.pow(this.coordX, 2) + Math.pow(this.coordY, 2)
				+ Math.pow(this.coordZ, 2));

		return res;
	}

	@Override
	public Double modulo() {

		Double resultado;

		resultado = Math.sqrt(Math.pow(this.coordX, 2)
				+ Math.pow(this.coordY, 2) + Math.pow(this.coordZ, 2));

		return resultado;
	}

	public String toString() {

		String retorno = new String("( " + this.coordX + " ; " + this.coordY
				+ " ; " + this.coordZ + " )");

		return retorno;
	}

	public boolean equals(Object p) {

		Punto3D punto = (Punto3D) p;

		if (this.coordX.equals(punto.coordX)
				&& this.coordY.equals(punto.coordY)
				&& this.coordZ.equals(punto.coordZ)) {

			return true;

		} else {

			return false;
		}
	}

	@Override
	public void desplazamiento(Object p) {

		Punto3D punto = (Punto3D) p;

		this.coordX += punto.coordX;
		this.coordY += punto.coordY;
		this.coordZ += punto.coordZ;

	}

	public Punto3D clone() {

		Punto3D resultado = new Punto3D(this.coordX, this.coordY, this.coordZ);

		return resultado;
	}

	public static void main(String[] args) {

		Punto puntoLoco;
		puntoLoco = new Punto2D(3.0,4.0);
		Punto3D pNuevo = new Punto3D(-1.0, -2.0, -3.0);
		
		out.println(puntoLoco);
		out.println(pNuevo);
		
		puntoLoco = pNuevo;
		
		out.println(puntoLoco);
	}
}

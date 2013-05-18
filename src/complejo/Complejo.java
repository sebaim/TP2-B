package complejo;

import java.util.Arrays;

public class Complejo implements Comparable<Complejo> {

	private Double real;
	private Double imaginario;

	public Complejo() {

		// real = 0.0;
		// imaginario = 0.0;
		this(0.0, 0.0); // llama al const parametrizado
	}

	public Complejo(Double r, Double i) {

		real = r;
		imaginario = i;
	}

	public Complejo sumar(Complejo c1) {

		Complejo resultado = new Complejo();

		resultado.real = c1.real + this.real;
		resultado.imaginario = c1.imaginario + this.imaginario;

		return resultado;
	}

	public Complejo sumar(Double d) {

		Complejo resultado = new Complejo();

		resultado.real = d + this.real;
		resultado.imaginario = this.imaginario;

		return resultado;
	}

	public Complejo sumar(Integer i) {

		Complejo resultado = new Complejo();

		resultado.real = i + this.real;
		resultado.imaginario = this.imaginario;

		return resultado;
	}

	public Complejo restar(Complejo c1) {

		Complejo resultado = new Complejo();

		resultado.real = this.real - c1.real;
		resultado.imaginario = this.imaginario - c1.imaginario;

		return resultado;
	}

	public Complejo restar(Integer i) {

		Complejo resultado = new Complejo();

		resultado.real = this.real - i;
		resultado.imaginario = this.imaginario;

		return resultado;
	}

	public Complejo restar(Double d) {

		Complejo resultado = new Complejo();

		resultado.real = this.real - d;
		resultado.imaginario = this.imaginario;

		return resultado;
	}

	public Complejo multiplicar(Complejo c1) {

		Complejo resultado = new Complejo();

		resultado.real = (c1.real * this.real - c1.imaginario * this.imaginario);
		resultado.imaginario = (c1.real * this.imaginario)
				+ (c1.imaginario * this.real);

		return resultado;
	}

	public Complejo multiplicar(Integer i) {

		Complejo resultado = new Complejo();

		resultado.real = (i * this.real);
		resultado.imaginario = (i * this.imaginario);

		return resultado;
	}

	public Complejo multiplicar(Double d) {

		Complejo resultado = new Complejo();

		resultado.real = (d * this.real);
		resultado.imaginario = (d * this.imaginario);

		return resultado;
	}

	public String toString() {

		String cadena = new String(this.real + " " + this.imaginario + "i");
		return cadena;
	}

	public boolean equals(Complejo c) {

		if (this.real.equals(c.real) && this.imaginario.equals(c.imaginario)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equals(Double d) {

		if (this.real.equals(d) && this.imaginario.equals(0.0))
			return true;
		else
			return false;
	}

	public boolean equals(Integer i) {

		if (this.real.equals(new Double(i)) && this.imaginario.equals(0.0))
			return true;
		else
			return false;
	}

	public Double modulo() {

		Double resultado;

		resultado = Math.sqrt(this.real * this.real + this.imaginario
				* this.imaginario);

		return resultado;
	}

	public Complejo clone() {

		Complejo aux = new Complejo(this.real, this.imaginario);

		return aux;
	}

	@Override
	public int compareTo(Complejo c) {

		if (this.modulo() > c.modulo()) {

			return 1;
		}
		if (this.modulo() < c.modulo()) {

			return -1;
		}

		return 0;

	}
	
	public static void main(String[] args) {

		Complejo[] vector= new Complejo[5];
		vector[0] = new Complejo(4.0, 1.0);
		vector[1] = new Complejo(1.0, 1.0);
		vector[2] = new Complejo(0.0, 1.0);
		vector[3] = new Complejo(10.0, -1.0);
		vector[4] = new Complejo(4.0, 1.0);
		
		Arrays.sort(vector);
		
		for(int i=0; i<vector.length; i++){
		
			System.out.println(vector[i] + " " + vector[i].modulo());
		}
		
	}

}

package vectorMath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import matrizMath.MatrizMath;

public class VectorMath {

	private Double[] vector;

	private VectorMath(int tam) {

		vector = new Double[tam];
	}

	public VectorMath(String cad) {

		String linea;

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			archivo = new File("src/vectorMath/" + cad);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			if ((linea = br.readLine()) != null) {

				vector = new Double[Integer.parseInt(linea)];

			} else {

				System.out
						.println("ERROR: Se tienen más datos de lo establecido.");
				this.vector = null;
				return;
			}

			for (int f = 0; f < this.vector.length; f++) {

				if ((linea = br.readLine()) != null) {

					vector[f] = Double.parseDouble(linea);

				} else {

					System.out
							.println("ERROR: Se tienen más datos de lo establecido.");
					this.vector = null;
					return;
				}
			}

			if ((linea = br.readLine()) != null) {

				System.out
						.println("ERROR: Se tienen más datos de lo establecido.");
				this.vector = null;
			}

		} catch (IOException e) {

			e.printStackTrace();
			this.vector = null;

		} finally {

			if (fr != null) {

				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Double[] getVector() {
		return vector;
	}

	public boolean equals(VectorMath v) {

		if (this.vector.length != v.getVector().length) {

			return false;
		}

		for (int i = 0; i < this.vector.length; i++) {

			if (!(this.vector[i].equals(v.vector[i]))) {

				return false;
			}
		}

		return true;
	}

	public VectorMath suma(VectorMath v) {

		if (this.vector.length != v.vector.length) {

			return null;
		}

		VectorMath resultado = new VectorMath(this.vector.length);

		for (int i = 0; i < this.vector.length; i++) {

			resultado.vector[i] = this.vector[i] + v.vector[i];
		}

		return resultado;
	}

	public VectorMath resta(VectorMath v) {

		if (this.vector.length != v.vector.length) {

			return null;
		}

		VectorMath resultado = new VectorMath(this.vector.length);

		for (int i = 0; i < this.vector.length; i++) {

			resultado.vector[i] = this.vector[i] - v.vector[i];
		}

		return resultado;
	}

	public VectorMath producto(Double d) {

		VectorMath resultado = new VectorMath(this.vector.length);

		for (int i = 0; i < this.vector.length; i++) {

			resultado.vector[i] = this.vector[i] * d;
		}

		return resultado;
	}

	public Double producto(VectorMath v) {

		if (this.vector.length != v.vector.length) {

			return null;
		}

		Double resultado = new Double(0);

		for (int i = 0; i < this.vector.length; i++) {

			resultado += this.vector[i] * v.vector[i];
		}

		return resultado;
	}

	public VectorMath producto(MatrizMath m) {

		if (this.vector.length != m.getColumnas()) {

			return null;
		}

		VectorMath resultado = new VectorMath(m.getFilas());

		for (int c = 0; c < resultado.vector.length; c++) {

			resultado.vector[c] = 0.0;

		}

		for (int f = 0; f < m.getFilas(); f++) {

			for (int c = 0; c < m.getColumnas(); c++) {

				resultado.vector[f] += m.getValor(f, c) * this.vector[c];

			}
		}

		return resultado;

	}

	public Double normaUno() {

		Double resultado = new Double(0);

		for (int i = 0; i < this.vector.length; i++) {

			resultado += this.vector[i];
		}

		return resultado;
	}

	public Double normaDos() {

		Double resultado = new Double(0);

		for (int i = 0; i < this.vector.length; i++) {

			resultado += Math.pow(this.vector[i], 2);
		}

		resultado = Math.sqrt(resultado);

		return resultado;
	}

	public Double normaInfinito() {

		Double resultado = new Double(0);

		for (int i = 0; i < this.vector.length; i++) {

			if (resultado < Math.abs(this.vector[i])) {

				resultado = Math.abs(this.vector[i]);

			}
		}

		return resultado;
	}

	public String toString() {

		StringBuffer cadena = new StringBuffer();

		if (this.vector == null) {

			return " ";
		}

		cadena.append("[ ");
		for (int i = 0; i < this.vector.length; i++) {

			cadena.append(this.vector[i] + " ");
		}
		cadena.append("]");

		return cadena.toString();
	}

	public static void main(String[] args) {

		VectorMath v1 = new VectorMath("vec1.in");
		VectorMath v2 = new VectorMath("vec2.in");
		MatrizMath m1 = new MatrizMath("matriz1.in");

		System.out.println(m1);
		System.out.println(v1);
		System.out.println(v1.producto(m1));

	}
}

package semana5.atvEmSala.exDegas.poligonosRuins.poligonos;

import java.util.Scanner;

public class Ponto {

	private float x, y, z;

	public Ponto(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

    public static Ponto solicitaPonto(Scanner sc) {
        return null;
    }

    public void mostra() {
    }

    public float distancia(Ponto p2) {
        return 0;
    }
}
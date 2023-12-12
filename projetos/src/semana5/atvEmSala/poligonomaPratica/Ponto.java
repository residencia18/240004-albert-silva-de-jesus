package semana5.atvEmSala.poligonomaPratica;

import java.util.Scanner;

public class Ponto {
    
    private float x;
    private float y;

    public Ponto() {
    }

    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float distancia(Ponto p) {
		return (float) Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	static Ponto solicitaPonto(Scanner teclado) {
		System.out.println("Digite as coordenadas do ponto: ");
		float x = teclado.nextFloat();
		float y = teclado.nextFloat();
		return new Ponto(x,y);
	}

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }
}

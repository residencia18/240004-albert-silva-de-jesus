package semana5.atvEmSala.poligono;

import java.util.ArrayList;

public class Poligono {

    ArrayList<Ponto> pontos;

    public Poligono() {
        this.pontos = new ArrayList<>();
    }

    public void inserePonto(float x, float y) {
        Ponto p = new Ponto(x, y);
        this.pontos.add(p);
    }

    public float perimeter() {

        float perimetro = 0;
        for (int i = 0; i < this.pontos.size() - 1; i++) {
            Ponto p1 = this.pontos.get(i);
            Ponto p2 = this.pontos.get(i + 1);
            perimetro += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        Ponto p1 = this.pontos.get(this.pontos.size() - 1);
        Ponto p2 = this.pontos.get(0);
        perimetro += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));

        return perimetro;
    }
}

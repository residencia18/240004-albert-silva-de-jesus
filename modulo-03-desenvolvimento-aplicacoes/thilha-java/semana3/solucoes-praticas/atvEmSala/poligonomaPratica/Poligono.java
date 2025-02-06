package semana5.atvEmSala.poligonomaPratica;

import java.util.ArrayList;

public class Poligono {

    ArrayList<Ponto> pontos;

    Poligono() {
        pontos = new ArrayList<Ponto>();
    }

    void inserePonto(Ponto p) {
        pontos.add(p);
    }

    public float perimetro() {
        float per = 0;
        Ponto p1, p2;

        for (int i = 0; i < pontos.size() - 1; i++) {
            p1 = pontos.get(i);
            p2 = pontos.get(i + 1);
            per += p1.distancia(p2);
        }
        return per;
    }
}

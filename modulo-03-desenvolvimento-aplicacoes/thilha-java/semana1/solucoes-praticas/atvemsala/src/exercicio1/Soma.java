package exercicio1;

public class Soma {

    int x, y;

    public Soma(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int adicao(int x, int y){

        return this.x + this.y;
    }
}

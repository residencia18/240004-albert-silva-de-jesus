package semana3.atvemsala.exercicio2;

public class MediaPonderada {
    
    float nota1, nota2 ,nota3;
    float peso1, peso2, peso3;
    
    public MediaPonderada(float nota1, float nota2, float nota3, float peso1, float peso2, float peso3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.peso1 = peso1;
        this.peso2 = peso2;
        this.peso3 = peso3;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getPeso1() {
        return peso1;
    }

    public void setPeso1(float peso1) {
        this.peso1 = peso1;
    }

    public float getPeso2() {
        return peso2;
    }

    public void setPeso2(float peso2) {
        this.peso2 = peso2;
    }

    public float getPeso3() {
        return peso3;
    }

    public void setPeso3(float peso3) {
        this.peso3 = peso3;
    }

    public float calcularMediaPonderada(float nota1, float nota2, float nota3, float peso1, float peso2, float peso3){
        
        float mediaPonderada = ((this.peso1 * this.nota1) + (this.peso2 * this.nota2) + (this.peso3 * this.nota3)) / (this.peso1 + this.peso2 + this.peso3);

        return mediaPonderada;
    }
}

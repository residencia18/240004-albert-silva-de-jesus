#region 

abstract class Conta{
    int numero;
    double saldo;


    public void setNumero(numero){
        if(numero > 0 ){
            this.numero = numero;
        }else{
            throw new Exception("Numero inválido");
        }
    }

    public double sacar(double valor);

}


try{
    Conta conta = new Conta();
}catch(Exception e){
    
}

class ContaCorrente : Conta{
    double limite;

    public ContaCorrente(double limite){
        this.limite = limite;
    }


}

class ContaPoupanca : Conta{

    public ContaCorrente(){
    }


}


#endregion
package repositories;

import entities.Falha;

public interface ReparoRepository {
    public static void listarReparos(){}
    public static void listarRaparosAbertos(){}
    public static void encerraReparo(){}
    public static void cadastrarReparo(Falha falha){}
}

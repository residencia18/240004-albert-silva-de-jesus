package repositories;

import entities.Falha;

public interface ReparoRepository {

    void listarReparos();

    void listarRaparosAbertos();

    void encerraReparo();

    void cadastrarReparo(Falha falha);
}

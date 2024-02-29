package avaliacao.repositories;

import avaliacao.entities.Falha;

public interface ReparoRepository {

    void listarReparos();

    void listarRaparosAbertos();

    void encerraReparo();

    void cadastrarReparo(Falha falha);
}

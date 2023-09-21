#ifndef OCORRENCIA_HPP
#define OCORRENCIA_HPP

#include "dataHora.hpp"
#include<iostream>
#include "verificacoesOcorrencia.hpp"

using namespace std;

typedef struct{
    string descricao;
    DataHora horario;
    string numeroApolice;
    bool ativa = false;

    void imprimeOcorrencia(){
        cout << "Descrição da ocorrencia : " << descricao << endl;
        cout << "Horario : " ;
        horario.data.mostraData();
        horario.hora.mostraHorario();
        cout << "Numero de Apolice : " << numeroApolice << endl;
    }

    bool inserirDescricao()
    {
        string descricaoInserida;
        

        cout << "\n\tInsira a descrição do ocorrido : ";
        getline(cin,descricaoInserida);

        descricao = descricaoInserida;
        return true;
    }

    bool inserirApolice()
    {
        string apoliceInserida;
        
        do{
            cout << "\n\tInsira a apolice de seguro : ";
            getline(cin,apoliceInserida);
        }while(verificaApolice(apoliceInserida));

        numeroApolice = apoliceInserida;
        return true;
    }

    

 


}Ocorrencia;

#endif

#include <iostream>
using namespace std;

struct minhaData
{
    int dia, mes, ano;
};

struct titulo_eleitor
{
    minhaData dt_nascimento;
    minhaData td_emiss;
    string nome;
    string num_inscr;
    string zona, secao;
    string municipio, uf;
};

void mostra_Data(minhaData minhadata);

void lerData(minhaData *novaData);

void lerEleitor(titulo_eleitor *eleitor);

void mostraTilulo(titulo_eleitor eleitor);

int anosCompletos(minhaData novaData);

int main()
{

    titulo_eleitor eleitor;

    lerEleitor(&eleitor);

    mostraTilulo(eleitor);

    mostra_Data(eleitor.dt_nascimento);

}

void lerEleitor(titulo_eleitor *eleitor){

    cout << endl;
    cout << "\n" << "---------------TITULO DE ELEITOR----------------\n";
    cout << "Informe o nome do elitor: ";
    cin >> eleitor->nome;

    cout << "Informe o número de inscrição: ";
    cin >> eleitor->num_inscr;

    cout << "Informe a zona: ";
    cin >> eleitor->zona;

    cout << "Informe a seção: ";
    cin >> eleitor->secao;

    cout << "Informe o múnicipio e a UF: ";
    cin >> eleitor->municipio >> eleitor->uf;

    cout << "\nInforme a data de nascimento: ";
    lerData(&eleitor->dt_nascimento);

    // cout << "Informe a data de emissão: ";
    // cin >> eleitor.minhaData.td_emiss;

}

void mostraTilulo(titulo_eleitor eleitor){
    cout << endl;
    cout << "\n" << "---------------TITULO DE ELEITOR----------------\n";
    cout << "Nome: " << eleitor.nome << "\n" 
    << eleitor.num_inscr << "\n" 
    << eleitor.num_inscr << "\n" 
    << eleitor.secao << "\n" 
    << eleitor.zona << "\n" 
    << eleitor.municipio 
    << eleitor.uf;
    mostra_Data(eleitor.dt_nascimento);
}

void lerData(minhaData *novaData)
{
    cin >> novaData->dia >> novaData->mes >> novaData->ano;
}

void mostra_Data(minhaData minhadata)
{
    cout << "\nData de nascimento: " << minhadata.dia << "/" << minhadata.mes << "/" << minhadata.ano << endl;
}

int anosCompletos(minhaData novaData){

    int x = 0;
    int anoAtual = 2023;
    int mesAtual = 9;
    int diaAtual = 11;

    if(novaData.mes < mesAtual){
        x--
    }else{
        if(novaData.mes == mesAtual && novaData.dia < diaAtual){

        }
    }
    return x;
}
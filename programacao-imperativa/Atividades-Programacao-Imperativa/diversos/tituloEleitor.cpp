#include <iostream>
#include <vector>

using namespace std;

struct minhaData
{
    int dia, mes, ano;
};

struct tituloEleitors
{
    string nome;
    minhaData dataNascimento;
    minhaData dataEmissao;
    string numeroInscricao;
    string zona, secao;
    string municipio, uf;
};

void mostraData(minhaData minhadata);

void lerData(minhaData &novaData);

void lerDadosEleitor(tituloEleitors *eleitor, vector<tituloEleitors> &eleitores);

void mostraInformacaoTilulos(tituloEleitors eleitor);

void listaDeEleitores(vector<tituloEleitors> eleitores);

int anosCompletos(minhaData novaData);

int main()
{

    tituloEleitors eleitor;

    vector<tituloEleitors> informacoesEleitores;

    lerDadosEleitor(&eleitor, informacoesEleitores);

    // mostraInformacaoTilulos(eleitor);

    listaDeEleitores(informacoesEleitores);
}

void lerDadosEleitor(tituloEleitors *eleitor, vector<tituloEleitors> &eleitores){
    
    int quantidadeEleitores = 0;
    // vector<tituloEleitors>::iterator it;
    // it = eleitores.begin();

    cout << "\nDeseja cadastrar quantos eleitores no sistema: ";
    cin >> quantidadeEleitores;
    system("cls");

    for(int i = 0; i < quantidadeEleitores; i++){

        cout << endl;
        cout << "\n===============TITULO DE ELEITOR===============\n\n";
        cout << i + 1 << "º ELEITOR\n";

        cout << "Informe o número de inscrição: ";
        cin >> eleitor->numeroInscricao;

        cout << "Informe o nome do eleitor: ";
        cin >> eleitor->nome;

        cout << "Informe a data de nascimento: ";
        lerData(eleitor->dataNascimento);

        cout << "Informe a zona: ";
        cin >> eleitor->zona;

        cout << "Informe a seção: ";
        cin >> eleitor->secao;

        cout << "Informe o múnicipio e a UF: ";
        cin >> eleitor->municipio >> eleitor->uf;

        cout << "Informe a data de emissão: ";
        lerData(eleitor->dataEmissao);

        eleitores.push_back(*eleitor);
        system("cls");
    } 
}

void mostraInformacaoTilulos(tituloEleitors eleitor){
    
    cout << endl;
    cout << "\n" << "================TITULO DE ELEITOR===============\n";

    cout<< "Número de Inscrição: " << eleitor.numeroInscricao << "\n" 
        << "Nome: " << eleitor.nome << "\n";
    cout<< "Data de Nascimento: "; mostraData(eleitor.dataNascimento); 
    cout<< "Data de emissão: "; mostraData(eleitor.dataEmissao);
    cout<< "Seção: " << eleitor.secao << "\n" 
        << "Zona: " << eleitor.zona << "\n" 
        << "Município: " << eleitor.municipio 
        << " - " << eleitor.uf << "\n\n";
    system("cls");
}

void listaDeEleitores(vector<tituloEleitors> eleitores){

    int i = 0;

    if (eleitores.empty())
    {
        cout << "\nA lista precisa ser inicializada!...\n";
        return;
    }

    cout << "\n===============Lista de Eleitores===============\n\n";

    for(auto it = eleitores.begin(); it != eleitores.end(); it++){
        
        cout << ++i << "º Titulo:\n";
        cout<< "Número de Inscrição: " << it->numeroInscricao << "\n" 
            << "Nome: " << it->nome << " Idade: " << anosCompletos(it->dataNascimento) << "\n";
        cout<< "Data de Nascimento: "; mostraData(it->dataNascimento); 
        cout<< "Data de emissão: "; mostraData(it->dataEmissao);
        cout<< "Seção: " << it->secao << "\n" 
            << "Zona: " << it->zona << "\n" 
            << "Município: " << it->municipio 
            << " - " << it->uf << "\n";
        cout << "================================================\n\n";
    }
}

void lerData(minhaData &novaData)
{
    cin >> novaData.dia 
        >> novaData.mes 
        >> novaData.ano;
}

void mostraData(minhaData minhadata)
{
    cout << minhadata.dia << "/" << minhadata.mes << "/" << minhadata.ano << endl;
}

int anosCompletos(minhaData novaData){

    int anoAtual = 2023;
    int mesAtual = 9;
    int diaAtual = 11;
    int x = anoAtual - novaData.ano;

    if(mesAtual < novaData.mes){
        x--;
    }else{
        if(novaData.mes == mesAtual && novaData.dia < diaAtual){
            x--;
        }
    }
    return x;
}
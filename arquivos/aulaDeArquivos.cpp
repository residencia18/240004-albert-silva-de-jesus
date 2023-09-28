#include <iostream>
#include <fstream>

using namespace std;

int main()
{

    // abrindo um arquivo para escrita
    ofstream arquivo_saida;

    arquivo_saida.open("exemplo.txt", ios_base::out);

    // Verifica se o arquivo foi aberto com sucesso
    if (arquivo_saida.is_open())
    {
        arquivo_saida << "Escrevendo no arquivo." << endl;
        arquivo_saida << 20 + 60 << endl;
        arquivo_saida.close();
    }
    else
    {

        cout << "Erro ao abrir o arquivo." << endl;
    }

    // Abrindo o arquivo para leitura
    ifstream arquivo_entrada;
    arquivo_entrada.open("exemplo.txt", ios_base::in);

    // Verifica se o arquivo foi aberto com sucesso
    if (arquivo_entrada.is_open())
    {
        string linha;

        while (arquivo_entrada.eof() == false)
        {
            getline(arquivo_entrada, linha);
            cout << linha << endl;
        }
        arquivo_entrada.close();
    }
    else
    {
        cout << "Erro ao abrir o arquivo." << endl;
    }
}
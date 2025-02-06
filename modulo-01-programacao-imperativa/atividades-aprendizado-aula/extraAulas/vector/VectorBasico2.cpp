#include <iostream>
#include <vector>

using namespace std;

int main()
{

    vector<int> num1, num2;
    int tam, i;

    // push_back() -> Adiciona um elemento no final do vetor
    num1.push_back(10); num1.push_back(20); num1.push_back(30); num1.push_back(40); num1.push_back(50);

    num2.push_back(60); num2.push_back(70); num2.push_back(80); num2.push_back(90); num2.push_back(100);

    // push_back() -> Adiciona um elemento no final do vetor
    num1.push_back(11);
    num2.push_back(07);

    // size() -> Retorna o tamanho do vetor
    tam = num1.size();
    cout << "Tamanho do vetor num1: " << tam << endl;

    // Imprimindo o vetor
    for (i = 0; i < tam; i++)
    {
        cout << num1[i] << " ";
    }
    cout << endl;

    // swap() -> Troca o conteúdo de um vetor por outro
    num1.swap(num2);

    cout << "Primeiro valor de num1: " << num1.front() << endl;
    cout << "Ultimo valor de num1: " << num1.back() << endl;
    cout << "Valor do meio........ " << num1.at(tam / 2) << endl;

    // insert() -> Insere um elemento em uma posição específica
    num1.insert(num1.begin(), 888);
    num1.insert(num1.begin() + 1, 888);
    num1.insert(num1.end(), 888);
    num1.insert(num1.end() - 1, 888);

    // erase() -> Apaga um elemento em uma posição específica
    num1.erase(num1.end() - 2);

    // clear() -> Limpa o vetor
    num1.clear();

    // empty() -> Retorna true se o vetor estiver vazio
    while (!num1.empty())
    {
        num1.pop_back();
    }

}
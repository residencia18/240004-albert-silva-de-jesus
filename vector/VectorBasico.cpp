#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){

    vector<int> num1;
    vector<int> num2;
    int tam, i;

    // push_back() -> Adiciona um elemento no final do vetor
    num1.push_back(10); num1.push_back(20); num1.push_back(30); num1.push_back(40); num1.push_back(50);

    num2.push_back(60); num2.push_back(70); num2.push_back(80); num2.push_back(90); num2.push_back(100);

    // size() -> Retorna o tamanho do vetor
    tam = num1.size();

    cout << "Tamanho do vetor num1: " << tam << endl;

    // empty() -> Retorna true se o vetor estiver vazio
    if(num1.empty()){
        cout << "Vetor vazio" << endl;
    }else{
        cout << "Vetor não vazio" << endl;
    }

    // clear() -> Limpa o vetor
    num1.clear();

    tam = num1.size();

    cout << "Tamanho do vetor num1: " << tam << endl;

    // insert() -> Insere um elemento em uma posição específica
    num1.insert(num1.begin(), 10); num1.insert(num1.begin() + 1, 20); num1.insert(num1.begin() + 2, 30);       num1.insert(num1.begin() + 3, 40); num1.insert(num1.begin() + 4, 50);

    // erase() -> Apaga um elemento em uma posição específica
    num1.erase(num1.begin() + 2);

    // pop_back() -> Apaga o último elemento do vetor
    num1.pop_back();

    // swap() -> Troca o conteúdo de um vetor por outro
    num1.swap(num2);

    // at() -> Retorna o elemento em uma posição específica
    cout << "Elemento na posição 2 do vetor num1: " << num1.at(2) << endl;

    // front() -> Retorna o primeiro elemento do vetor
    cout << "Primeiro elemento do vetor num1: " << num1.front() << endl;

    // back() -> Retorna o último elemento do vetor
    cout << "Último elemento do vetor num1: " << num1.back() << endl;

    // begin() -> Retorna um iterador para o primeiro elemento do vetor
    cout << "Primeiro elemento do vetor num1: " << *num1.begin() << endl;

    // end() -> Retorna um iterador para o último elemento do vetor
    cout << "Último elemento do vetor num1: " << *num1.end() << endl;

    // rbegin() -> Retorna um iterador reverso para o primeiro elemento do vetor
    cout << "Primeiro elemento do vetor num1: " << *num1.rbegin() << endl;

    // rend() -> Retorna um iterador reverso para o último elemento do vetor
    cout << "Último elemento do vetor num1: " << *num1.rend() - 1 << endl;

    // max_size() -> Retorna o número máximo de elementos que o vetor pode armazenar
    cout << "Número máximo de elementos que o vetor num1 pode armazenar: " << num1.max_size() << endl;

    // reserve() -> Aumenta a capacidade do vetor
    num1.reserve(20);

    // capacity() -> Retorna a capacidade do vetor
    cout << "Capacidade do vetor num1: " << num1.capacity() << endl;

    // resize() -> Redimensiona o vetor
    num1.resize(10);

    // shrink_to_fit() -> Reduz a capacidade do vetor para que ela seja igual ao tamanho do vetor
    num1.shrink_to_fit();

    // assign() -> Atribui novos valores ao vetor
    num1.assign(5, 10);

    // emplace() -> Insere um novo elemento em uma posição específica
    num1.emplace(num1.begin(), 10);

    // emplace_back() -> Insere um novo elemento no final do vetor
    num1.emplace_back(10);

}
#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Estrutura para representar um cliente
struct Cliente {
    string cpf;
    string dataNascimento;
    string cnh;
    string nome;
    // Outros campos relevantes podem ser adicionados aqui
};

// Função para incluir um cliente na coleção
void incluirCliente(vector<Cliente>& clientes) {
    Cliente novoCliente;
    cout << "Digite o CPF do cliente: ";
    cin >> novoCliente.cpf;
    cout << "Digite a Data de Nascimento do cliente: ";
    cin >> novoCliente.dataNascimento;
    cout << "Digite a CNH do cliente: ";
    cin >> novoCliente.cnh;
    cout << "Digite o Nome do cliente: ";
    cin.ignore(); // Limpa o buffer de entrada antes de ler a string com espaços
    getline(cin, novoCliente.nome);
    clientes.push_back(novoCliente);
    cout << "Cliente incluído com sucesso!" << endl;
}

// Função para excluir um cliente da coleção
void excluirCliente(vector<Cliente>& clientes) {
    string cpfParaExcluir;
    cout << "Digite o CPF do cliente que deseja excluir: ";
    cin >> cpfParaExcluir;

    for (auto it = clientes.begin(); it != clientes.end(); ++it) {
        if (it->cpf == cpfParaExcluir) {
            clientes.erase(it);
            cout << "Cliente excluído com sucesso!" << endl;
            return;
        }
    }

    cout << "Cliente não encontrado." << endl;
}

// Função para listar todos os clientes
void listarClientes(const vector<Cliente>& clientes) {
    if (clientes.empty()) {
        cout << "Nenhum cliente cadastrado." << endl;
    } else {
        cout << "Lista de Clientes:" << endl;
        for (const auto& cliente : clientes) {
            cout << "CPF: " << cliente.cpf << endl;
            cout << "Nome: " << cliente.nome << endl;
            cout << "Data de Nascimento: " << cliente.dataNascimento << endl;
            cout << "CNH: " << cliente.cnh << endl;
            cout << "-----------------------" << endl;
        }
    }
}

// Função para localizar um cliente por CPF
void localizarCliente(const vector<Cliente>& clientes) {
    string cpfParaLocalizar;
    cout << "Digite o CPF do cliente que deseja localizar: ";
    cin >> cpfParaLocalizar;

    for (const auto& cliente : clientes) {
        if (cliente.cpf == cpfParaLocalizar) {
            cout << "Cliente encontrado:" << endl;
            cout << "CPF: " << cliente.cpf << endl;
            cout << "Nome: " << cliente.nome << endl;
            cout << "Data de Nascimento: " << cliente.dataNascimento << endl;
            cout << "CNH: " << cliente.cnh << endl;
            return;
        }
    }

    cout << "Cliente não encontrado." << endl;
}

int main() {
    vector<Cliente> clientes;
    int opcao;

    do {
        cout << "Menu de Opções:" << endl;
        cout << "1. Incluir" << endl;
        cout << "2. Excluir" << endl;
        cout << "3. Alterar (apenas por CPF)" << endl;
        cout << "4. Listar" << endl;
        cout << "5. Localizar (por CPF)" << endl;
        cout << "0. Sair" << endl;
        cout << "Escolha uma opção: ";
        cin >> opcao;

        switch (opcao) {
            case 1:
                incluirCliente(clientes);
                break;
            case 2:
                excluirCliente(clientes);
                break;
            case 3:
                // Implementar a opção de alterar aqui
                break;
            case 4:
                listarClientes(clientes);
                break;
            case 5:
                localizarCliente(clientes);
                break;
            case 0:
                cout << "Saindo do programa." << endl;
                break;
            default:
                cout << "Opção inválida. Tente novamente." << endl;
        }
    } while (opcao != 0);

    return 0;
}

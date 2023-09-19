#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Estrutura para representar um veículo
struct Veiculo {
    string renavan;
    string placa;
    string dataHoraRetirada;
    string dataHoraEntrega;
    string lojaRetirada;
    // Outros campos relevantes podem ser adicionados aqui
};

// Função para incluir um veículo na coleção
void incluirVeiculo(vector<Veiculo>& veiculos) {
    Veiculo novoVeiculo;
    cout << "Digite o Renavan do veículo: ";
    cin >> novoVeiculo.renavan;
    cout << "Digite a Placa do veículo: ";
    cin >> novoVeiculo.placa;
    cout << "Digite a Data e Hora de Retirada (prevista) do veículo: ";
    cin >> novoVeiculo.dataHoraRetirada;
    cout << "Digite a Data e Hora de Entrega (prevista) do veículo: ";
    cin >> novoVeiculo.dataHoraEntrega;
    cout << "Digite a Loja de Retirada do veículo: ";
    cin.ignore(); // Limpa o buffer de entrada antes de ler a string com espaços
    getline(cin, novoVeiculo.lojaRetirada);
    veiculos.push_back(novoVeiculo);
    cout << "Veículo incluído com sucesso!" << endl;
}

// Função para excluir um veículo da coleção
void excluirVeiculo(vector<Veiculo>& veiculos) {
    string placaParaExcluir;
    cout << "Digite a Placa do veículo que deseja excluir: ";
    cin >> placaParaExcluir;

    for (auto it = veiculos.begin(); it != veiculos.end(); ++it) {
        if (it->placa == placaParaExcluir) {
            veiculos.erase(it);
            cout << "Veículo excluído com sucesso!" << endl;
            return;
        }
    }

    cout << "Veículo não encontrado." << endl;
}

// Função para listar todos os veículos
void listarVeiculos(const vector<Veiculo>& veiculos) {
    if (veiculos.empty()) {
        cout << "Nenhum veículo cadastrado." << endl;
    } else {
        cout << "Lista de Veículos:" << endl;
        for (const auto& veiculo : veiculos) {
            cout << "Renavan: " << veiculo.renavan << endl;
            cout << "Placa: " << veiculo.placa << endl;
            cout << "Data e Hora de Retirada (prevista): " << veiculo.dataHoraRetirada << endl;
            cout << "Data e Hora de Entrega (prevista): " << veiculo.dataHoraEntrega << endl;
            cout << "Loja de Retirada: " << veiculo.lojaRetirada << endl;
            cout << "-----------------------" << endl;
        }
    }
}

// Função para localizar um veículo por Placa
void localizarVeiculo(const vector<Veiculo>& veiculos) {
    string placaParaLocalizar;
    cout << "Digite a Placa do veículo que deseja localizar: ";
    cin >> placaParaLocalizar;

    for (const auto& veiculo : veiculos) {
        if (veiculo.placa == placaParaLocalizar) {
            cout << "Veículo encontrado:" << endl;
            cout << "Renavan: " << veiculo.renavan << endl;
            cout << "Placa: " << veiculo.placa << endl;
            cout << "Data e Hora de Retirada (prevista): " << veiculo.dataHoraRetirada << endl;
            cout << "Data e Hora de Entrega (prevista): " << veiculo.dataHoraEntrega << endl;
            cout << "Loja de Retirada: " << veiculo.lojaRetirada << endl;
            return;
        }
    }

    cout << "Veículo não encontrado." << endl;
}

int main() {
    vector<Veiculo> veiculos;
    int opcao;

    do {
        cout << "Menu de Opções:" << endl;
        cout << "1. Incluir" << endl;
        cout << "2. Excluir" << endl;
        cout << "3. Alterar (apenas por Placa)" << endl;
        cout << "4. Listar" << endl;
        cout << "5. Localizar (por Placa)" << endl;
        cout << "0. Sair" << endl;
        cout << "Escolha uma opção: ";
        cin >> opcao;

        switch (opcao) {
            case 1:
                incluirVeiculo(veiculos);
                break;
            case 2:
                excluirVeiculo(veiculos);
                break;
            case 3:
                // Implementar a opção de alterar aqui
                break;
            case 4:
                listarVeiculos(veiculos);
                break;
            case 5:
                localizarVeiculo(veiculos);
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

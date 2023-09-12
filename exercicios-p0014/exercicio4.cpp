/*Parte em Grupos (até 5 pessoas por grupo):
Exercício 4: Organização de Código
• Em grupo, escolham uma funcionalidade simples para um programa (por exemplo, uma calculadora de operações matemáticas).
• Dividam o programa em diferentes funções, atribuindo a cada membro do grupo a responsabilidade por uma função específica.
• Juntem as funções criadas por cada membro e criem um programa completo que utilize todas elas.
• Usem os recursos do Git para dividir e juntar os códigos.*/

#include <iostream>
using namespace std;

int menu();

void calculadora(double &x, double &y);

void calcula(double &x, double &y);

int main()
{
    double x = 0, y = 0;

    calculadora(x, y);
}

int menu()
{
    int opcao = 0;

    do
    {
        cout << "\n======CALCULADORA=====\n";
        cout << "[1] - SOMA\n[2] - SUBSTRAÇÃO\n[3] - MULTIPLICAÇÃO\n[4] - DIVISÃO\n[5] - SAIR\n";
        cout << "ENTRADA ->  ";
        cin >> opcao;
    } while (opcao < 0 || opcao > 5);

    return opcao;
}

void calculadora(double &x, double &y)
{
    int opcao = 0;
    do
    {
        switch (menu())
        {
        case 1:

            system("cls");
            cout << "Informe o minuendo: ";
            cin >> x;

            cout << "Informe o subtraendo: ";
            cin >> y;

            cout << "Soma = " << x + y << endl;
            cout << endl;

            break;

        case 2:

            system("cls");
            cout << "Informe o minuendo: ";
            cin >> x;

            cout << "Informe o subtraendo: ";
            cin >> y;

            cout << "Diferença = " << x - y << endl;

            break;

        case 3:

            system("cls");
            cout << "Informe o multiplicando: ";
            cin >> x;

            cout << "Informe o multiplicador: ";
            cin >> y;

            cout << "Produto = " << endl;

            break;
        case 4:

            system("cls");
            cout << "Informe o dividendo: ";
            cin >> x;

            cout << "Informe o divisor: ";
            cin >> y;

            cout << "Quociente = " << x / y << endl;
            cout << endl;

            break;

        case 5:

            opcao = 8;

        default:

            system("cls");
            cout << "\nObrigado por utilizar a nossa calculadora!...\n\n";

            break;
        }
    } while (opcao != 8);
}

void calcula(double &x, double &y)
{
}
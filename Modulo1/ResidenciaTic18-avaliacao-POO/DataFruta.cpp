#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Data
{
	int dia, mes, ano;

public:
	/*
	O metodo abaixo retornar -1 se d1 anterior a d2
	Retornar 0 se d1 = d2
	Retornar +1 se d1 posterior a d2
	*/
	static int compara(Data d1, Data d2)
	{
		return 0;
	}

	Data(int _dia, int _mes, int _ano)
	{
		dia = _dia;
		mes = _mes;
		ano = _ano;
	}
	string toString()
	{
		string ret = "";
		ret.append(to_string(dia));
		ret.append("/");
		ret.append(to_string(mes));
		ret.append("/");
		ret.append(to_string(ano));
		return ret;
	}
};

class Lista
{
public:
	virtual void listarEmOrdem() = 0;
	virtual void listarEmQuantidade(int quant) = 0;
	virtual void entradaDeDados() = 0;
	virtual void mostraMediana() = 0;
	virtual void mostraMenor() = 0;
	virtual void mostraMaior() = 0;
};

class ListaNomes : public Lista
{
	vector<string> lista;

public:
	/*
	O metodo abaixo pergunta ao usuarios quantos
	elementos vo existir na lista e depois
	solicita a digitar o de cada um deles
	*/
	void entradaDeDados()
	{
		lista.push_back("Teste");
	}

	void mostraMediana()
	{
		cout << "Aqui vai mostrar a mediana da lista de strings" << endl;
	}

	void mostraMenor()
	{
		cout << "Aqui vai mostrar o primeiro nome alfabeticamente" << endl;
	}
	void mostraMaior()
	{
		cout << "aqui vai mostrar o ultimo nome alfabeticamente" << endl;
	}
};

class ListaDatas : public Lista
{
	vector<Data> lista;

public:
	/*
	O metodo abaixo pergunta ao usuarios quantos
	elementos, existir na lista e depois
	solicita a digitar de cada um deles
	*/
	void entradaDeDados()
	{
	}

	void mostraMediana()
	{
		cout << "Aqui vai mostrar a mediana da lista de datas" << endl;
	}

	void mostraMenor()
	{
		cout << "Aqui vai mostrar a primeira data cronologicamente" << endl;
	}
	void mostraMaior()
	{
		cout << "aqui vai mostrar a ultima data cronologicamente" << endl;
	}
};

class ListaSalarios : public Lista
{
private:
	vector<float> lista;

	static bool compara(float a, float b)
	{
		return a < b;
	}

public:
	vector<float> *getLista()
	{
		return &(lista);
	}

	/*
	O metodo abaixo pergunta ao usuarios quantos
	elementos, existir na lista e depois
	solicita a digitar de cada um deles
	*/
	void entradaDeDados() override
	{
		int n = 0;
		float salario = 0;

		do
		{
			cout << "\n\tInforme a quantidade de elementos do vetor: ";
			cin >> n;
			cin.get();

			if (n <= 0)
			{
				cout << "\n\tOps, quantidade de elementos do vetor incorreto!...";
				cout << "\n\tPressione qualquer tecla para continuar...";
				cin.get();
			}

		} while (n <= 0);

		for (int i = 0; i < n; i++)
		{
			do
			{
				cout << "\n\tInforme o " << i + 1 << "º salário: ";
				cin >> salario;
				cin.get();

				if (salario <= 0)
				{
					cout << "\n\tOps, salário invalido!...";
					cout << "\n\tPressione qualquer tecla para continuar...";
					cin.get();
				}
			} while (salario <= 0);

			getLista()->push_back(salario);
		}
	}

	void mostraMediana() override
	{
		vector<float> aux;
		aux = *getLista();
		sort(aux.begin(), aux.end(), compara);
		float mediana;

		if (aux.size() % 2 == 0)
		{
			float posMedianaEsquerda, posMedianaDireita;
			float medianaEsquerda, medianaDireita;
			posMedianaEsquerda = aux.size() / 2;
			posMedianaDireita = aux.size() / 2 + 1;

			medianaEsquerda = aux.at(posMedianaEsquerda - 1);
			medianaDireita = aux.at(posMedianaDireita - 1);
			mediana = (medianaDireita + medianaEsquerda) / 2;
		}
		else
		{
			float pos = aux.size() / 2;
			mediana = aux.at(pos);
		}
		cout << "\n\tAqui vai mostrar a mediana da lista de salários" << endl;
		cout << "\n\tMediana: " << mediana << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void mostraMenor() override
	{
		vector<float> auxMenor;
		auxMenor = *getLista();
		sort(auxMenor.begin(), auxMenor.end(), compara);
		float menor;

		menor = auxMenor.front();

		cout << "\n\tAqui vai mostrar o menor dos salarios" << endl;
		cout << "\n\tMenor: " << menor << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void mostraMaior() override
	{
		vector<float> auxMaior;
		auxMaior = *getLista();
		sort(auxMaior.begin(), auxMaior.end(), compara);
		float maior;

		maior = auxMaior.back();
		cout << "\n\tAqui vai mostrar o maior dos salários" << endl;
		cout << "\n\tMaior: " << maior << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void listarEmOrdem() override
	{
		vector<float> salarioOrdenado;
		salarioOrdenado = *getLista();
		sort(salarioOrdenado.begin(), salarioOrdenado.end(), compara);

		for (auto it = salarioOrdenado.begin(); it != salarioOrdenado.end(); it++)
		{
			cout << "\n\t" << *it;
		}
	}

	void listarEmQuantidade(int quant) override
	{
		int i = 0;
		for (auto it = getLista()->begin(); i < quant && it != getLista()->end(); it++)
		{
			cout << "\n\t" << *it;
			i++;
		}
	}
};

class ListaIdades : public Lista
{

private:
	vector<int> lista;

	static bool compara(int a, int b)
	{
		return a < b;
	}

public:
	vector<int> *getLista()
	{
		return &(lista);
	}

	/*
O metodo abaixo pergunta ao usuarios quantos
elementos existi na lista e depois
solicita a digitar de cada um deles
*/
	void entradaDeDados() override
	{
		int n = 0;
		int idade = 0;

		do
		{
			cout << "\n\tInforme a quantidade de elementos do vetor: ";
			cin >> n;
			cin.get();

			if (n <= 0)
			{
				cout << "\n\tOps, quantidade de elementos do vetor incorreto!...";
				cout << "\n\tPressione qualquer tecla para continuar...";
				cin.get();
			}

		} while (n <= 0);

		for (int i = 0; i < n; i++)
		{
			do
			{
				cout << "\n\tInforme a " << i + 1 << "º idade: ";
				cin >> idade;
				cin.get();

				if (idade <= 0)
				{
					cout << "\n\tOps, idade invalida!...";
					cout << "\n\tPressione qualquer tecla para continuar...";
					cin.get();
				}

			} while (idade <= 0);

			getLista()->push_back(idade);
		}
	}

	void mostraMediana() override
	{
		vector<int> aux;
		aux = *getLista();
		sort(aux.begin(), aux.end(), compara);
		int mediana;

		if (aux.size() % 2 == 0)
		{
			int posMedianaEsquerda, posMedianaDireita;
			int medianaEsquerda, medianaDireita;
			posMedianaEsquerda = aux.size() / 2;
			posMedianaDireita = aux.size() / 2 + 1;

			medianaEsquerda = aux.at(posMedianaEsquerda - 1);
			medianaDireita = aux.at(posMedianaDireita - 1);
			mediana = (medianaDireita + medianaEsquerda) / 2;
		}
		else
		{
			int pos = aux.size() / 2;
			mediana = aux.at(pos);
		}
		cout << "\n\tAqui vai mostrar a mediana da lista de idades" << endl;
		cout << "\n\tMediana: " << mediana << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void mostraMenor() override
	{
		vector<int> auxMenor;
		auxMenor = *getLista();
		sort(auxMenor.begin(), auxMenor.end(), compara);
		int menor;

		menor = auxMenor.front();

		cout << "\n\tAqui vai mostrar a menor das idades" << endl;
		cout << "\n\tMenor: " << menor << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void mostraMaior() override
	{
		vector<int> auxMaior;
		auxMaior = *getLista();
		sort(auxMaior.begin(), auxMaior.end(), compara);
		int maior;

		maior = auxMaior.back();
		cout << "\n\tAqui vai mostrar a maior das idades" << endl;
		cout << "\n\tMaior: " << maior << endl;
		cout << "\n\tPressione qualquer tecla para continuar...";
		cin.get();
	}

	void listarEmOrdem() override
	{
		vector<int> ordenado;
		ordenado = *getLista();
		sort(ordenado.begin(), ordenado.end(), compara);

		for (auto it = ordenado.begin(); it != ordenado.end(); it++)
		{
			cout << "\n\t" << *it;
		}
	}

	void listarEmQuantidade(int quant) override
	{
		int i = 0;
		for (auto it = getLista()->begin(); i < quant && it != getLista()->end(); it++)
		{
			cout << "\n\t" << *it;
			i++;
		}
	}
};

int main()
{
	vector<Lista *> listaDeListas;
	int quant = 2;

	ListaSalarios listaSalarios;
	listaSalarios.entradaDeDados();
	listaDeListas.push_back(&listaSalarios);

	ListaIdades listaIdades;
	listaIdades.entradaDeDados();
	listaDeListas.push_back(&listaIdades);

	for (Lista *l : listaDeListas)
	{
		l->mostraMediana();
		l->mostraMenor();
		l->mostraMaior();
		l->listarEmOrdem();
		l->listarEmQuantidade(quant);
	}
}
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Data {
    int dia, mes, ano;

public:
    Data(int _dia, int _mes, int _ano) : dia(_dia), mes(_mes), ano(_ano) {}

	static int compara(Data d1, Data d2) {
		if (d1.getAno() != d2.getAno() ) {
			return d1.getAno() < d2.getAno() ;
		}
		if (d1.getMes() != d2.getMes()) {
			return d1.getMes() < d2.getMes();
		}
		return d1.getDia() < d2.getDia();
	}

	int getDia(){
		return this->dia;
	}

	int getMes(){
		return this->mes;
	}

	int getAno(){
		return this->ano;
	}

    static bool ehAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    static bool ehDataValida(int dia, int mes, int ano) {
        if (ano >= 1900 && ano <= 9999) {
            if (mes >= 1 && mes <= 12) {
                int diasNoMes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (mes == 2 && ehAnoBissexto(ano)) {
                    diasNoMes[2] = 29;
                }
                return (dia >= 1 && dia <= diasNoMes[mes]);
            }
        }
    return false;
    }

    string toString() const {
        return to_string(dia) + "/" + to_string(mes) + "/" + to_string(ano);
    }
};

class Lista {
public:
    virtual void entradaDeDados() = 0;
    virtual void mostraMediana() = 0;
    virtual void mostraMenor() = 0;
    virtual void mostraMaior() = 0;
	virtual void listarEmOrdem()= 0;
	virtual void listarEmQuantidade(int n)= 0;

};

class ListaNomes : public Lista {
    vector<string> lista;

private:

    static bool ehNomeValido(const string& nome) {
        for (char c : nome) {
            if (!isalpha(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
    static bool compararStrings(const string& a, const string& b) {
        string aSemEspacos;
        string bSemEspacos;

        for (char ch : a) {
            if (!isspace(ch)) {
                aSemEspacos += tolower(ch);
            }
        }

        for (char ch : b) {
            if (!isspace(ch)) {
                bSemEspacos += tolower(ch);
            }
        }

        return aSemEspacos < bSemEspacos;
    }

public:

	vector<string>* getLista(){
		return &(this->lista);
	}

    void entradaDeDados() override {
        cout << "----LISTA DE NOMES----" << endl;
        int qtd;
        do{
            cout << "Informe o numero de elementos da lista: ";
            cin >> qtd;
            cin.ignore(); 
            if(qtd<1){
                cout << "Quantidade de elementos da lista deve ser de pelo menos 1" << endl;
            }
        }while(qtd<1);
        string nome;
        for (int i = 0; i < qtd; i++) {
            do{
                cout << "Digite o " << i + 1 << " nome: ";
                getline(cin, nome);
                if(!ehNomeValido(nome)){
                    cout << "Nome inválido" << endl;
                }
                }while(!ehNomeValido(nome));
            getLista()->push_back(nome);
        }
    }

    void mostraMediana() override {
        vector<string> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), compararStrings);
        string nomeMediana = listaParaOrdenar.at(listaParaOrdenar.size() / 2);
        cout << "A mediana é: " << nomeMediana << endl;
    }

    void mostraMenor() override {
        vector<string> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), compararStrings);
        string primeiroNome = listaParaOrdenar.front();
        cout << "Primeiro nome é: " << primeiroNome << endl;
    }

    void mostraMaior() override {
        vector<string> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), compararStrings);
        string ultimoNome = listaParaOrdenar.back();
        cout << "Ultimo nome é: " << ultimoNome << endl;
    }

	void listarEmOrdem() override{
        vector<string> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), compararStrings);
		for(auto it=listaParaOrdenar.begin() ; it!=listaParaOrdenar.end() ; it++){
			cout << *it << endl;
		}
	}

	void listarEmQuantidade(int n) override{
		int i = 0;
		for(auto it=getLista()->begin() ; i < n && it!=getLista()->end() ; it++){
			cout << *it << endl;
			i++;
		}
	}

};

class ListaDatas : public Lista {
    vector<Data> lista;

public:

	vector<Data>* getLista(){
		return &(this->lista);
	}

    void entradaDeDados() override {
        cout << "----LISTA DE DATAS----" << endl;
        int qtd;
        do{
            cout << "Informe o numero de elementos da lista: ";
            cin >> qtd;
            cin.get(); 
            if(qtd<1){
                cout << "Quantidade de elementos da lista deve ser de pelo menos 1" << endl;
            }
        }while(qtd<1);
        int dia, mes, ano;
        for (int i = 0; i < qtd; i++) {
            do{
                cout << "----" << i + 1 << " Data----" << endl;
                cout << "Digite o dia: ";
                cin >> dia;
                cin.get(); 
                cout << "Digite o mes: ";
                cin >> mes;
                cin.get(); 
                cout << "Digite o ano: ";
                cin >> ano;
                cin.get(); 
                if(!Data::ehDataValida(dia,mes,ano)){
                    cout << "Data inválida" << endl;
                }
            }while(!Data::ehDataValida(dia,mes,ano));
            Data data(dia, mes, ano);
            lista.push_back(data);
        }
    }

    void mostraMediana() override {
        vector<Data> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), Data::compara);
        Data dataMediana = listaParaOrdenar.at(listaParaOrdenar.size()/2 );
        cout << "A Data mediana é: " << dataMediana.toString() << endl;
    }

    void mostraMenor() override {
        vector<Data> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), Data::compara);
        cout << "A menor data é: " << (*listaParaOrdenar.begin()).toString() << endl;
    }

    void mostraMaior() override {
        vector<Data> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), Data::compara);
        cout << "A Maior data é: " << (listaParaOrdenar.back()).toString() << endl;
    }

	void listarEmOrdem() override{
        vector<Data> listaParaOrdenar = *getLista();
        sort(listaParaOrdenar.begin(), listaParaOrdenar.end(), Data::compara);
		for(auto it=listaParaOrdenar.begin() ; it!=listaParaOrdenar.end() ; it++){
			cout << it->toString() << endl;
		}
	}

	void listarEmQuantidade(int n) override{
		int i = 0;
		for(auto it=getLista()->begin() ; i < n && it!=getLista()->end() ; it++){
			cout << it->toString() << endl;
			i++;
		}
	}

};

int main() {
    vector<Lista*> listaDeListas;

    ListaNomes listaNomes;
    listaNomes.entradaDeDados();
    listaDeListas.push_back(&listaNomes);

    ListaDatas listaDatas;
    listaDatas.entradaDeDados();
    listaDeListas.push_back(&listaDatas);

    for (Lista* l : listaDeListas) {
        l->mostraMediana();
        l->mostraMenor();
        l->mostraMaior();
		l->listarEmQuantidade(2);
    }

    return 0;
}

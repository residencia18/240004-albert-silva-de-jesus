#include <iostream>
#include <string.h>
#include <vector>
#include <fstream>

using namespace std;

void limpaTela()
{
    for (int i = 0; i < 200; i++)
        cout << endl;
};

class Data
{
    int dia, mes, ano;

public:

    string geraString()
    {
        string dataStr = to_string(dia);
        dataStr.append("/");
        dataStr.append(to_string(mes));
        dataStr.append("/");
        dataStr.append(to_string(ano));
        return dataStr;
    }

    void setDia(int _dia)
    {
        dia = _dia;
    }

    void setMes(int _mes)
    {
        mes = _mes;
    }

    void setAno(int _ano)
    {
        ano = _ano;
    }

};

class paciente
{
    string nome;
    Data dt_morte;

public:

    static paciente leDados()
    {
        string nome;
        paciente novoPaciente;
        int dia, mes, ano;

        cout << "==========Dados de um novo paciente==========" << endl;
        cout << "Digite o nome: " << endl;
        getline(cin, nome);
        novoPaciente.setNome(nome);

        cout << "Digite a data: " << endl;
        cin >> dia >> mes >> ano;
        cin.get();

        Data dtMorte;
        dtMorte.setDia(dia);
        dtMorte.setMes(mes);
        dtMorte.setAno(ano);
        novoPaciente.setDtMorte(dtMorte);

        return novoPaciente;
    }

    void listaDados()
    {
        cout << "-------Dados de Paciente-----" << endl;
        cout << "Paciente: " << getNome() << endl;
        cout << "Falecido em " << getdtMorte().geraString();
        cout << "---------------------------------" << endl;
    }

    void setNome(string _nome)
    {
        nome = _nome;
    }

    string getNome()
    {
        return nome;
    }

    void setDtMorte(Data _dataMorte)
    {
        dt_morte = _dataMorte;
    }

    Data getdtMorte()
    {
        return dt_morte;
    }
};

class mausoleu
{
    static int contador;
    int id;
    string localizacao;
    vector<paciente> pacientes;

private:

    static int getContador()
    {
        return contador;
    }

    static void incContador()
    {
        contador++;
    }

    mausoleu()
    {
        id = mausoleu::getContador();
        mausoleu::incContador();
    }

    static mausoleu leNovo()
    {
        mausoleu novoMausoleu;
        cout << "Digite a localicacao do novo mausoleu: ";
        string loc;
        getline(cin, loc);

        novoMausoleu.setLocalizacao(loc);
        return novoMausoleu;
    }

    void listaDados()
    {
        cout << endl;
        cout << "-----------Dados do mausoleu----------" << endl;
        cout << "Numero do mausoleu: " << getId() << endl;
        cout << "Localização: " << getLocalizacao() << endl;
        cout << "Lista de pacientes deste mausoleu: " << endl;
        for (paciente p : pacientes)
        {
            p.listaDados();
        }
        cout << "-----Fim da lista de mausoleus!-----" << endl;
    }

    void setLocalizacao(string _localizacao)
    {
        localizacao = _localizacao;
    }

    string getLocalizacao()
    {
        return localizacao;
    }

    int getId()
    {
        return id;
    }

    void setId(int _id)
    {
        id = _id;
    }

    void recepciona(paciente _paciente)
    {
        pacientes.push_back(_paciente);
    }

    void listaPacientes()
    {
        for (paciente p : pacientes)
        {
            cout << p.getNome() << endl;
        }
    }
};

vector<mausoleu> mausoleus;

class persistencia
{
public:

    static void salvaMausoleu(mausoleu novo)
    {
        ofstream outMausoleus;
        outMausoleus.open("mausoleus.txt", ios_base::app);
        if (outMausoleus.is_open())
        {
            outMausoleus << novo.getId() << endl;
            outMausoleus << novo.getLocalizacao() << endl;
            outMausoleus.close();
        }
    }

    static void salvaPacienteNoMausoleu(int id, paciente novo)
    {
        ofstream outMausoleus;
        outMausoleus.open("pacientes.txt", ios_base::app);
        if (outMausoleus.is_open())
        {
            outMausoleus << id << endl;
            outMausoleus << novo.getNome() << endl;
            outMausoleus << novo.getdtMorte().geraString() << endl;
            outMausoleus.close();
        }
    }

    static void recuperaMausoleus()
    {
        ifstream inMausoleus;
        inMausoleus.open("mausoleus.txt", ios_base::in);
        if (inMausoleus.is_open())
        {
            int id;
            string idstr, loc;
            while (inMausoleus.eof() == false)
            {
                getline(inMausoleus, idstr);
                getline(inMausoleus, loc);
                if (idstr.length() > 0)
                {
                    id = stoi(idstr);
                    mausoleu novoMausoleu;
                    novoMausoleu.setId(id);
                    novoMausoleu.setLocalizacao(loc);
                    mausoleus.push_back(novoMausoleu);
                }
            }
            inMausoleus.close();
        }
    }
};

int mausoleu::contador = 1;

int main()
{
    limpaTela();
    persistencia::recuperaMausoleus();
    int op;

    do
    {
        cout << "Opcoes" << endl;
        cout << "1. Incluir Mausoleu" << endl;
        cout << "2. Listar Mausoleus" << endl;
        cout << "3. Recepcionar paciente" << endl;
        cout << "0. Sair" << endl;
        cout << "Digite opcao: ";
        cin >> op;
        cin.get();

        if (op == 1)
        {
            limpaTela();
            cout << "------Cadastro de Mausoleu-------" << endl;
            mausoleu novo = mausoleu::leNovo();
            mausoleus.push_back(novo);
            persistencia::salvaMausoleu(novo);
            cout << "----Mausoleu criado!-----" << endl
                 << endl;
        };

        if (op == 2)
        {
            limpaTela();
            cout << "----Lista de Mausoleus---" << endl;
            for (mausoleu m : mausoleus)
            {
                m.listaDados();
            }
            cout << "--------FIM DA LISTA-----" << endl << endl;
        };
        if (op == 3)
        {
            int _id;
            mausoleu ocupa;
            paciente novoPac;
            novoPac = paciente::leDados();
            cout << "----Paciente criado!-----" << endl;
            cout << "Digite ID do mausoleu: ";
            cin >> _id;
            cin.get();

            for (auto it = mausoleus.begin(); it != mausoleus.end(); it++)
            {
                if (it->getId() == _id) // encontrei o mausoleu certo
                    it->recepciona(novoPac);
                    persistencia::salvaPacienteNoMausoleu(_id, novoPac);
                    break;
                    
            }

        };

    } while (op != 0);
}
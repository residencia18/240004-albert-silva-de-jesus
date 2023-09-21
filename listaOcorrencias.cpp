#include "listaOcorrencias.hpp"
#include "verificacoesOcorrencia.hpp"

void insereOcorrencia(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao){
    Ocorrencia ocorrencia;
    ocorrencia.inserirDescricao();
    string cpfOcorrencia;
    string placaOcorrencia;
    Locacao temp; // utilizada para extrair dados da locacao
    bool locacaoEncontrada;

    do{
        cout << "Entre com a cpf valida de cliente para registro da ocorrencia : ";
        getline(cin,cpfOcorrencia);
    }while(!verificaCPF(cpfOcorrencia));

    do{
        cout << "Entre com a placa valida do carro para registro da ocorrencia : ";
        getline(cin,placaOcorrencia);
    }while(verificaPlaca(placaOcorrencia));

    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){
        if(it->cliente.cpf==cpfOcorrencia && it->veiculo.placa==placaOcorrencia){
            if(it->ocorrencia.ativa){
                cout << "Já possui uma ocorrencia cadastraada nessa locação" << endl;
                return;
            }
            locacaoEncontrada = true;
            temp = *it;
        }
    }

    if(!locacaoEncontrada){
        cout << "Locacão não encontrada, não foi possivel inserir ocorrência "<< endl;
        pause();
        return;
    }

    if(!insereDataRetirada(temp , ocorrencia)){
        cout << "Não foi possivel registrar nova data de ocorrência" << endl;
    }

    ocorrencia.inserirApolice();
    ocorrencia.ativa = true;
    
    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){
        if(it->cliente.cpf==cpfOcorrencia && it->veiculo.placa==placaOcorrencia){
            it->ocorrencia = ocorrencia;
        }
    }

}

void excluiOcorrencia(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao){
    string cpfOcorrencia;
    string placaOcorrencia;
    
    do{
        cout << "Entre com a cpf valida de cliente para registro da ocorrencia : ";
        getline(cin,cpfOcorrencia);
    }while(!verificaCPF(cpfOcorrencia));

    do{
        cout << "Entre com a placa valida do carro para registro da ocorrencia : ";
        getline(cin,placaOcorrencia);
    }while(verificaPlaca(placaOcorrencia));

    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){
        if(it->cliente.cpf==cpfOcorrencia && it->veiculo.placa==placaOcorrencia){
            if(it->ocorrencia.ativa==true){
                it->ocorrencia.ativa = false;
                cout << "Ocorrencia excluida com sucesso " << endl;
                return;
            }
        }
    }
    cout << "Locação não encontrada" << endl;
    return;

}

void alteraOcorrencia(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao){
    limpaTela();
    string placaParaAlteracao;
    string cpfOcorrencia;
    string placaOcorrencia;
    Data data;
    bool locacaoEncontrada = false;

    cout << "\n\t===============ALTERAR OCORRÊNCIA============\n";
    do{
        cout << "Entre com a cpf valida de cliente para registro da ocorrencia : ";
        getline(cin,cpfOcorrencia);
    }while(!verificaCPF(cpfOcorrencia));

    do{
        cout << "Entre com a placa valida do carro para registro da ocorrencia : ";
        getline(cin,placaOcorrencia);
    }while(verificaPlaca(placaOcorrencia));

    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){
        if(it->cliente.cpf==cpfOcorrencia && it->veiculo.placa==placaOcorrencia){
            locacaoEncontrada = true;

            cout << "\n\t===============OCORRÊNCIA ENCONTRADA============\n";
            it->ocorrencia.imprimeOcorrencia();
            pause();

            int escolha;
            do
            { 
                data.mostraDataAtual();
                cout << "\t========MENU ALTERAR OCORRÊNCIA=========\n";
                cout << "\n\t[1] - ALTERAR DESCRIÇÃO:";
                cout << "\n\t[2] - ALTERAR DATA:";
                cout << "\n\t[3] - ALTERAR APOLICE:";
                cout << "\n\t[0] - SAIR";
                cout << "\n\tENTRADA ->  ";
                cin >> escolha;
                limpaBuffer();

                switch (escolha)
                {
                case 1:
                    if (it->ocorrencia.inserirDescricao())
                    {
                        limpaTela();
                        cout << "\n\t===============DESCRIÇÃO ALTERADO============\n";
                        it->ocorrencia.imprimeOcorrencia();
                        pause();
                        break;
                    }
                    else
                    {
                        cout << "\n\tAlteração de descrição cancelada" << endl;
                        pause();
                        break;
                    }
                case 2:
                    if (insereDataRetirada(*it,it->ocorrencia))
                    {
                        limpaTela();
                        cout << "\n\t===============PLACA ALTERADA============\n";
                        it->ocorrencia.imprimeOcorrencia();
                        pause();
                        break;
                    }
                    else
                    {
                        cout << "\n\tAlteração data De Retirada cancelada" << endl;
                        pause();
                        break;
                    }
                case 3:
                    if (it->ocorrencia.inserirApolice())
                    {
                        limpaTela();
                        cout << "\n\t===============APOLICE DE SEGURO ALTERADA============\n";
                        it->ocorrencia.imprimeOcorrencia();
                        pause();
                        break;
                    }
                    else
                    {
                        cout << "\n\tAlteração de apolice de seguro cancelada" << endl;
                        pause();
                        break;
                    }
                case 0:

                    pause();
                    break;

                default:
                    break;
                }
                
            } while (escolha != 0);
        }
    }
}

bool insereDataRetirada(Locacao temp , Ocorrencia &ocorrencia){

    DataHora possivelHorarioOcorrencia;
    string data;
    string hora;
    bool dataHoraValida;

    do
    {
        bool dataValida;
        do
        {
            cout << "\n\tInsira a data da ocorrencia (dd/mm/aaaa) : ";
            getline(cin, data);
            dataValida = (possivelHorarioOcorrencia.data.preencheData(data));

        } while (!dataValida);

        bool horaValida;

        do
        {
            cout << "\n\tInsira o horario da ocorrencia (hh:mm:ss) : ";
            getline(cin, hora);

            horaValida = possivelHorarioOcorrencia.hora.preencheHorario(hora);

        } while (!horaValida);

        if(segundaMaiorQuePrimeira(temp.retirada,possivelHorarioOcorrencia) && segundaMaiorQuePrimeira(possivelHorarioOcorrencia,temp.entrega)){
            dataHoraValida = true;
        }else{
            dataHoraValida = false;
        }


        if (!dataHoraValida)
        {
            pause();
            if (!verificaProsseguimento())
            {
                return false;
            }
            limpaTela();
        }

    } while (!dataHoraValida);
    ocorrencia.horario = possivelHorarioOcorrencia;

    return true;
}

void listarOcorrenciaPorCliente(vector<Locacao> &listaLocacao){
    string cpfOcorrencia;

    cout << "\n\t===============LISTA OCORRÊNCIA POR CLIENTE============\n";
    do{
        cout << "Entre com a cpf valida de um cliente para buscar ocorrencias : ";
        getline(cin,cpfOcorrencia);
    }while(!verificaCPF(cpfOcorrencia));

    
    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){

        if((it->cliente.cpf==cpfOcorrencia && it->ocorrencia.ativa==true)){
            cout << "----------------------------------" << endl;
            cout << "Cliente : " << endl;
            it->cliente.mostraCliente();
            cout << "Veiculo : " << endl;
            it->veiculo.mostraVeiculo();
            cout << "Ocorrência : " << endl;
            it->ocorrencia.imprimeOcorrencia();
            cout << endl << endl ;
        }
        cout << "----------------------------------" << endl;
    }
}

void listarOcorrenciaPorVeiculo(vector<Locacao> &listaLocacao){
    string placaOcorrencia;

    cout << "\n\t===============LISTA OCORRÊNCIA POR VEICULO============\n";
    do{
        cout << "Entre com a placa valida do veiculo para buscar ocorrencias : ";
        getline(cin,placaOcorrencia);
    }while(!verificaPlaca(placaOcorrencia));

    
    for(auto it=listaLocacao.begin() ; it!=listaLocacao.end() ; it++){

        if((it->veiculo.placa==placaOcorrencia && it->ocorrencia.ativa==true)){
            cout << "----------------------------------" << endl;
            cout << "Cliente : " << endl;
            it->cliente.mostraCliente();
            cout << "Veiculo : " << endl;
            it->veiculo.mostraVeiculo();
            cout << "Ocorrência : " << endl;
            it->ocorrencia.imprimeOcorrencia();
            cout << endl << endl ;
        }
        cout << "----------------------------------" << endl;
    }
}

int segundaMaiorQuePrimeira(DataHora umaData , DataHora outraData){
    if(umaData.data.ano > outraData.data.ano){
            return false;
        }else if(umaData.data.ano==outraData.data.ano){
            if(umaData.data.mes < outraData.data.mes){
                return false;
            }else if(umaData.data.mes== outraData.data.mes){
                if(umaData.data.dia < outraData.data.dia){
                    return false;
                }else if(umaData.data.dia == outraData.data.dia){
                    if(umaData.hora.hora < outraData.hora.hora){
                        return false;
                    }else if(umaData.hora.hora == outraData.hora.hora){
                        if(umaData.hora.minuto < outraData.hora.minuto){
                            return false;
                        }else if(umaData.hora.minuto == outraData.hora.minuto){
                            if(umaData.hora.segundo < outraData.hora.segundo){
                                return false;
                            }
                        }    
                    }
                }
            }
        }
    return true;
}
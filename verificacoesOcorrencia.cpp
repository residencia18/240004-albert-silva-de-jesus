#include "verificacoesOcorrencia.hpp"
#include<regex>

bool verificaApolice(string apolice){

    if (regex_match(apolice, regex("^[0-9]+$")))
    {
        return true;
    }
    return false;
}




using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AvaliacaoDotNet
{
    public class ListaAdvogado
    {
        public List<Advogado> advogados { get; set; }

        public ListaAdvogado()
        {
            advogados = new List<Advogado>();
        }

        public void AdicionarCliente(Advogado advogado)
        {
            advogados.Add(advogado);
        }

        public List<Advogado> GetAdvogados()
        {
            return advogados;
        }
    }
}
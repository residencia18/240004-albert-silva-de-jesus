package com.companhia.aerea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.repositories.AeroportoRepository;
import com.companhia.aerea.web.dto.AeroportoResponseDto;
import com.companhia.aerea.web.dto.form.AeroportoForm;

@Service
@Transactional(readOnly = false)
public class AeroportoServiceImpl implements AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Aeroporto salvar(Aeroporto aeroporto) {
        return aeroportoRepository.save(aeroporto);
    }

    // @Override
    // @Transactional(readOnly = true)
    // public List<Aeroporto> buscarTodos(String nome, String icao) {
    // return aeroportoRepository.findAll();
    // }

    @Override
    public List<AeroportoResponseDto> buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNome'");
    }

    @Override
    public Aeroporto buscarPorId(Long id) {
        return aeroportoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Inválido para condutor:" + id));
    }

    @Override
    public Aeroporto insert(Long id, AeroportoForm aeroportoForm) {
        Aeroporto aeroporto = buscarPorId(id);
        aeroporto.setNome(aeroportoForm.getNome());
        aeroporto.setIcao(aeroportoForm.getIcao());
        AeroportoResponseDto aeroportoResponseDto = new AeroportoResponseDto(aeroporto);
        return aeroporto;
    }

    @Override
    public AeroportoResponseDto update(Long id, AeroportoForm aeroportoForm) {
        return new AeroportoResponseDto(insert(id, aeroportoForm));
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Boolean isExisteId(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'isExisteId'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aeroporto> buscarTodos(String nome, String icao) {

        List<Aeroporto> aeroportos;

        if (nome != null && !nome.isEmpty() && icao != null && !icao.isEmpty()) {
            aeroportos = aeroportoRepository.findByNomeAndIcao(nome, icao);

        } else if (nome != null && !nome.isEmpty()) {
            aeroportos = aeroportoRepository.findByNome(nome);

        } else if (icao != null && !icao.isEmpty()) {
            aeroportos = aeroportoRepository.findByIcao(icao);

        } else {
            aeroportos = aeroportoRepository.findAll();
        }

        return aeroportos;
    }
}

package com.companhia.aerea.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.services.AeroportoService;
import com.companhia.aerea.web.dto.AeroportoResponseDto;
import com.companhia.aerea.web.dto.form.AeroportoForm;
import com.companhia.aerea.web.dto.mapper.AeroportoMapper;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @PostMapping("/create")
    public ResponseEntity<AeroportoResponseDto> create(@RequestBody AeroportoForm createDto) {
        Aeroporto obj = aeroportoService.salvar(AeroportoMapper.toAeroporto(createDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(AeroportoMapper.toDto(obj));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<AeroportoResponseDto>> listarAeroportos(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String icao) {
        return ResponseEntity.ok(AeroportoMapper.toListDto(aeroportoService.buscarTodos(nome, icao)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AeroportoResponseDto> update(@PathVariable Long id, @RequestBody AeroportoForm createDto) {
        // try {
        //     aeroportoService.salvar(aeroportoService.insert(id, createDto));
        //     return ResponseEntity.ok(aeroportoService.update(id, createDto));

        // } catch (Exception e) {
        //     return ResponseEntity.notFound().build();
        // }
        aeroportoService.salvar(aeroportoService.insert(id, createDto));
            return ResponseEntity.ok(aeroportoService.update(id, createDto));

    }

}
package com.companhia.aerea.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.services.PilotoService;
import com.companhia.aerea.web.dto.PilotoDto;
import com.companhia.aerea.web.form.PilotoForm;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @PostMapping("/create")
    public ResponseEntity<PilotoDto> insert(@RequestBody PilotoForm pilotoForm, UriComponentsBuilder uriBuilder) {
        Piloto piloto = pilotoForm.toUsuario();
        piloto = pilotoService.salvar(piloto);
        PilotoDto pilotoDto = new PilotoDto(piloto);
        // uriBuilder.path("/pilotos/create/{id}");
        // URI uri = uriBuilder.buildAndExpand(piloto.getId()).toUri();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(piloto.getId()).toUri();
        return ResponseEntity.created(uri).body(pilotoDto);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<PilotoDto>> listarPilotos() {
        return ResponseEntity.ok().body(pilotoService.buscarTodos());
    }

    @GetMapping("/listar-nome/")
    public ResponseEntity<List<PilotoDto>> listarPorNome(@RequestParam(required = false) String nome) {

        if (pilotoService.buscarPorNome(nome).isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok().body(pilotoService.buscarPorNome(nome));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PilotoDto> update(@PathVariable Long id, @RequestBody PilotoForm pilotoForm) {
        try {
            pilotoService.salvar(pilotoService.insert(id, pilotoForm));
            return ResponseEntity.ok(pilotoService.update(id, pilotoForm));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PilotoDto> excluir(@PathVariable("id") Long id) {
        if (pilotoService.isExisteId(id)) {

            try {
                pilotoService.delete(id);
                return ResponseEntity.ok().build();

            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<PilotoResponseDto> getById(@PathVariable Long id) {

    // // Usuario user = usuarioService.buscarPorId(id);
    // // return ResponseEntity.ok(UsuarioMapper.toDto(user));

    // try {
    // Piloto piloto = pilotoService.buscarPorId(id);
    // return ResponseEntity.ok(UsuarioMapper.toDto(user));

    // } catch (Exception e) {
    // return ResponseEntity.notFound().build();
    // }
    // }

}
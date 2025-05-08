package com.teckmack.gestor_okrs.service;

import com.teckmack.gestor_okrs.model.Iniciativa;
import com.teckmack.gestor_okrs.repository.IniciativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository iniciativaRepository;

    public List<Iniciativa> listarTodos() {
        return iniciativaRepository.findAll();
    }

    public Optional<Iniciativa> buscarPorId(Long id) {
        return iniciativaRepository.findById(id);
    }

    public Iniciativa salvar(Iniciativa iniciativa) {
        return iniciativaRepository.save(iniciativa);
    }

    public void deletar(Long id) {
        iniciativaRepository.deleteById(id);
    }
}

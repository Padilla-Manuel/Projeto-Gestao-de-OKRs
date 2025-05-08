package com.teckmack.gestor_okrs.service;

import com.teckmack.gestor_okrs.model.Objetivo;
import com.teckmack.gestor_okrs.model.ResultadoChave;
import com.teckmack.gestor_okrs.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public List<Objetivo> listarTodos() {
        return objetivoRepository.findAll();
    }

    public Optional<Objetivo> buscarPorId(Long id) {
        return objetivoRepository.findById(id);
    }

    public Objetivo salvar(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public void deletar(Long id) {
        objetivoRepository.deleteById(id);
    }
    public double calcularPorcentagemConclusao(Long objetivoId) {
    Optional<Objetivo> objetivoOpt = objetivoRepository.findById(objetivoId);
    if (objetivoOpt.isPresent()) {
        Objetivo objetivo = objetivoOpt.get();
        List<ResultadoChave> resultadosChave = objetivo.getResultadosChave();
        
        double somaPorcentagem = 0;
        for (ResultadoChave resultadoChave : resultadosChave) {
            somaPorcentagem += resultadoChave.getPorcentagemConclusao();
        }
        
        if (resultadosChave.isEmpty()) {
            return 0;
        }
        
        return somaPorcentagem / resultadosChave.size();
    }
    return 0;
}

}

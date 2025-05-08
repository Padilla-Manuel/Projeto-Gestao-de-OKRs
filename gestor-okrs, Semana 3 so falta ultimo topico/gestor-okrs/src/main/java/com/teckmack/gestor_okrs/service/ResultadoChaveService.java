package com.teckmack.gestor_okrs.service;

import com.teckmack.gestor_okrs.model.Iniciativa;
import com.teckmack.gestor_okrs.model.ResultadoChave;
import com.teckmack.gestor_okrs.repository.ResultadoChaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoChaveService {

    @Autowired
    private ResultadoChaveRepository resultadoChaveRepository;

    public List<ResultadoChave> listarTodos() {
        return resultadoChaveRepository.findAll();
    }

    public Optional<ResultadoChave> buscarPorId(Long id) {
        return resultadoChaveRepository.findById(id);
    }

    public ResultadoChave salvar(ResultadoChave resultadoChave) {
        return resultadoChaveRepository.save(resultadoChave);
    }

    public void deletar(Long id) {
        resultadoChaveRepository.deleteById(id);
    }
    public double calcularPorcentagemConclusao(Long resultadoChaveId) {
    Optional<ResultadoChave> resultadoChaveOpt = resultadoChaveRepository.findById(resultadoChaveId);
    if (resultadoChaveOpt.isPresent()) {
        ResultadoChave resultadoChave = resultadoChaveOpt.get();
        List<Iniciativa> iniciativas = resultadoChave.getIniciativas();
        
        double somaPorcentagem = 0;
        for (Iniciativa iniciativa : iniciativas) {
            somaPorcentagem += iniciativa.getPorcentagemConclusao();
        }
        
        if (iniciativas.isEmpty()) {
            return 0;
        }
        
        return somaPorcentagem / iniciativas.size();
    }
    return 0;
}

}

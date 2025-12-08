package com.rafaela.tarefas.service;

import com.rafaela.tarefas.model.Tarefa;
import com.rafaela.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return (Tarefa) tarefaRepository.save(tarefa);
    }

    public List<Tarefa> buscarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {

        return tarefaRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setNome(novaTarefa.getNome());
                    tarefaExistente.setDataEntrega(novaTarefa.getDataEntrega());
                    tarefaExistente.setResponsavel(novaTarefa.getResponsavel());
                    return tarefaRepository.save(tarefaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
}

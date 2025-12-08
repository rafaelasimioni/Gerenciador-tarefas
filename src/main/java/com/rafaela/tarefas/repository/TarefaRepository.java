package com.rafaela.tarefas.repository;
import com.rafaela.tarefas.model.Tarefa;
import jakarta.persistence.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // Métodos CRUD automáticos
}
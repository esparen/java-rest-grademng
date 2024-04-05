package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaEntity> getAllDisciplinas(){
        log.info("Listando todas as disciplinas");
        return disciplinaRepository.findAll();
    }

    public DisciplinaEntity getDisciplinaById(Long id) throws Exception {
        Optional<DisciplinaEntity> disciplinaEntity = disciplinaRepository.findById(id);
        return disciplinaEntity.orElseThrow(
                ()-> new Exception(
                        "Disciplina com id: " + id + " não encotrada!"
                )
        );
    }

    public DisciplinaEntity createDisciplina(DisciplinaEntity disciplinaEntity){
        log.info("Criando disciplina");
        return disciplinaRepository.save(disciplinaEntity);
    }

    public DisciplinaEntity updateDisciplina(Long id, DisciplinaEntity disciplinaUpdated) throws Exception {
        DisciplinaEntity disciplinaEntity = getDisciplinaById(id);

        if (disciplinaEntity != null){
            disciplinaEntity.setNome(disciplinaUpdated.getNome());
        }

        return disciplinaRepository.save(disciplinaEntity);
    }

    public void deleteDisciplina(Long id) throws Exception {
        disciplinaRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Disciplina com id" + id + "não encontrada"
                )
        );
        disciplinaRepository.deleteById(id);
    }
}

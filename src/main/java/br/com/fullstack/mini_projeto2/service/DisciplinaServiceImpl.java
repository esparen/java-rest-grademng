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
public class DisciplinaServiceImpl implements DisciplinaService{

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaEntity> getAllDisciplinas(){
        log.info("Listando todas as disciplinas");
        List<DisciplinaEntity> disciplina = disciplinaRepository.findAll();
        log.info("Buscando todas as disciplinas -> {} Encontradas", disciplina.size());
        return disciplinaRepository.findAll();
    }

    public DisciplinaEntity getDisciplinaById(Long id) throws Exception {
        log.info("Buscando livro por id ({})", id);
        Optional<DisciplinaEntity> disciplinaEntity = disciplinaRepository.findById(id);
        return disciplinaEntity.orElseThrow(()-> new Exception("Disciplina com id: " + id + " não encotrada!"));
    }

    public DisciplinaEntity createDisciplina(DisciplinaEntity disciplinaEntity){
        log.info("Criando disciplina");
        return disciplinaRepository.save(disciplinaEntity);
    }

    public DisciplinaEntity updateDisciplina(Long id, DisciplinaEntity disciplinaUpdated) throws Exception {
        DisciplinaEntity disciplinaEntity = getDisciplinaById(id);
        log.info("Alterando disciplina com id ({}) -> Salvar: {}", id, disciplinaUpdated.getNome());
        if (disciplinaEntity != null){
            disciplinaEntity.setNome(disciplinaUpdated.getNome());
        }
        log.debug("Alterando disciplina -> Registro Salvo");
        return disciplinaRepository.save(disciplinaEntity);
    }

    //TODO: método DELETE deve retornar um Response entity ou HTTP status
    public void deleteDisciplina(Long id) throws Exception {
        disciplinaRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Disciplina com id" + id + "não encontrada"
                )
        );
        log.info("Excluindo disciplina com id ({}) -> Excluída com sucesso", id);
        disciplinaRepository.deleteById(id);
    }
}

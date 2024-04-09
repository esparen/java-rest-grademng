package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.ProfessorEntity;
import br.com.fullstack.mini_projeto2.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorEntity> getAllProfessores() {
        return professorRepository.findAll();
    }

    public ProfessorEntity getProfessorById(Long id) throws Exception {
        return professorRepository.findById(id)
                .orElseThrow(() -> new Exception("Professor com id " + id + " não encontrado."));
    }

    public ProfessorEntity createProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity updateProfessor(long id, ProfessorEntity professorUpdated) throws Exception {
        ProfessorEntity professorEntity = getProfessorById(id);
        professorEntity.setNome(professorUpdated.getNome());
        return professorRepository.save(professorEntity);
    }

    public void deleteProfessor(long id) throws Exception {
        professorRepository.deleteById(id);
    }
}
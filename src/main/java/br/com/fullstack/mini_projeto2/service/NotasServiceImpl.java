package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import br.com.fullstack.mini_projeto2.repository.DisciplinaRepository;
import br.com.fullstack.mini_projeto2.repository.NotasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotasServiceImpl implements NotasService {
    private final NotasRepository notasRepository;
    private final DisciplinaRepository disciplinaRepository;

    public List<NotasEntity> getNotasByDisciplinaMatriculaId(Long matriculaId) throws Exception {
        List<NotasEntity> notasMatricula = notasRepository.findByDisciplinaMatriculaId(matriculaId);
        return notasMatricula;
    }

    public NotasEntity addNota(@NonNull DisciplinaMatriculaEntity matricula, @NonNull Double nota, @NonNull Double coeficiente) throws Exception {
        DisciplinaEntity targetDisciplina = disciplinaRepository.findById(matricula.getId())
                .orElseThrow( () -> new Exception("Erro ao buscar informações da disciplina ["+ matricula.getDisciplina().getId()+"]" ) );
        NotasEntity newNota = new NotasEntity();
        newNota.setNota(nota);
        newNota.setCoeficiente(coeficiente);
        newNota.setProfessorEntity(targetDisciplina.getProfessorEntity());
        return newNota;
    }

    private DisciplinaMatriculaEntity updateMediaGeral(@NonNull DisciplinaMatriculaEntity matricula) throws Exception{
        return null;
    }
}

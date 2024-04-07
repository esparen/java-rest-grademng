package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import br.com.fullstack.mini_projeto2.repository.NotasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotasServiceImpl implements NotasService {
    private final NotasRepository notasRepository;

    public List<NotasEntity> getNotasByDisciplinaMatriculaId(Long matriculaId) throws Exception {
        List<NotasEntity> notasMatricula = notasRepository.findByDisciplinaMatriculaId(matriculaId);
        return notasMatricula;
    }
}

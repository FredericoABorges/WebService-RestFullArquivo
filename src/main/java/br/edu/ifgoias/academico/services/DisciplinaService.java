package br.edu.ifgoias.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Disciplina findById(Integer id) {
        Optional<Disciplina> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Disciplina insert(Disciplina obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Disciplina update(Integer id, Disciplina obj) {
        Disciplina entity = repository.findById(id).orElseThrow();
        entity.setNomedisciplina(obj.getNomedisciplina());
        return repository.save(entity);
    }
}

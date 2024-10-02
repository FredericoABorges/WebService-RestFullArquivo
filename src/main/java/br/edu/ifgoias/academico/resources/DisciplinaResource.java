package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.services.DisciplinaService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        List<Disciplina> disciplinas = service.findAll();
        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
        Disciplina disciplina = service.findById(id);
        return ResponseEntity.ok().body(disciplina);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina) {
        disciplina = service.insert(disciplina);
        return ResponseEntity.ok().body(disciplina);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        disciplina = service.update(id, disciplina);
        return ResponseEntity.ok().body(disciplina);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

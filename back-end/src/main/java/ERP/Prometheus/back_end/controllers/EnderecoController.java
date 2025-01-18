package ERP.Prometheus.back_end.controllers;

import ERP.Prometheus.back_end.models.Endereco;
import ERP.Prometheus.back_end.repositories.EnderecoRepository;
import ERP.Prometheus.back_end.services.EnderecoService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping
    public ResponseEntity<List<Endereco>> getAll () {
        List<Endereco> enderecos = this.enderecoService.getAll();
        return ResponseEntity.ok().body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getOneById(@PathVariable Integer id) {
        Endereco endereco = this.enderecoService.getOneById(id);
        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody Endereco endereco) {
        this.enderecoService.create(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody Endereco endereco, @PathVariable Integer id) {
        endereco.setId(id);
        this.enderecoService.update(endereco);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        this.enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

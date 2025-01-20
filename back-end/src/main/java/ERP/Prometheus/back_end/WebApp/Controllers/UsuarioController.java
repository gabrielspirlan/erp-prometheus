package ERP.Prometheus.back_end.WebApp.Controllers;

import ERP.Prometheus.back_end.Application.Services.Usuario.UsuarioServiceInterface;
import ERP.Prometheus.back_end.Domain.Contracts.Result.Response.UsuarioResponseGetOneById;
import ERP.Prometheus.back_end.Domain.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioServiceInterface usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.usuarioService.getAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseGetOneById> findById(@PathVariable Integer id) {
        UsuarioResponseGetOneById usuario = this.usuarioService.getOneById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<Void> create ( @RequestBody  Usuario usuario) {
        this.usuarioService.create(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setId(id);
        this.usuarioService.update(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        this.usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

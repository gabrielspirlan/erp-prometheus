package ERP.Prometheus.back_end.WebApp.Controllers;

import ERP.Prometheus.back_end.Application.Services.Usuario.UsuarioServiceInterface;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Request.UsuarioRequestCreate;
import ERP.Prometheus.back_end.Domain.Contracts.Usuario.Response.UsuarioResponseGet;
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
    public ResponseEntity<List<UsuarioResponseGet>> findAll() {
        List<UsuarioResponseGet> usuarios = this.usuarioService.getAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseGet> findById(@PathVariable Integer id) {
        UsuarioResponseGet usuario = this.usuarioService.getOneById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<Void> create ( @RequestBody UsuarioRequestCreate request) {
        this.usuarioService.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getUsuario().getId()).toUri();
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

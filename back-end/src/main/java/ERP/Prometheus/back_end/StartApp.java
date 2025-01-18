package ERP.Prometheus.back_end;

import ERP.Prometheus.back_end.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UsuarioRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Servidor Rodando");
    }
}

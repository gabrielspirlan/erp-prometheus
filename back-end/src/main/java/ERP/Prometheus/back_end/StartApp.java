package ERP.Prometheus.back_end;

import ERP.Prometheus.back_end.Infrastructure.PostgreSQL.Repositories.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Servidor Rodando - Porta: 8080");
    }
}

package org.noeotero.bocatas;

import org.noeotero.bocatas.model.Grupo;
import org.noeotero.bocatas.repository.GrupoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final GrupoRepository grupoRepository;

    public DataLoader(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear grupos de ejemplo si no existen
        crearGrupoSiNoExiste("1º ESO A");
        crearGrupoSiNoExiste("1º ESO B");
        crearGrupoSiNoExiste("2º ESO A");
        crearGrupoSiNoExiste("2º ESO B");
        crearGrupoSiNoExiste("3º ESO A");
        crearGrupoSiNoExiste("4º ESO A");
        crearGrupoSiNoExiste("1º BACH A");
        crearGrupoSiNoExiste("2º BACH A");
    }

    private void crearGrupoSiNoExiste(String nombreGrupo) {
        if (!grupoRepository.existsByNombre(nombreGrupo)) {
            Grupo grupo = new Grupo(nombreGrupo);
            grupoRepository.save(grupo);
            System.out.println("Grupo creado: " + nombreGrupo);
        }
    }
}
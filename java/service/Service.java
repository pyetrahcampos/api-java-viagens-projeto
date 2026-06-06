package service;

import desafio2,desafio2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinoService {
    
    private List<Destino> destinos = new ArrayList<>();
    private Long proximoId = 1L;

   
    public Destino cadastrar(Destino destino) {
        destino.setId(proximoId++);
        destinos.add(destino);
        return destino;
    }

  
    public List<Destino> listarTodos() {
        return destinos;
    }

   
    public List<Destino> pesquisar(String busca) {
        return destinos.stream()
                .filter(d -> d.getNome().getIgnoreCase(busca) || d.getLocalizacao().getIgnoreCase(busca))
                .collect(Collectors.toList());
    }


    public Optional<Destino> buscarPorId(Long id) {
        return destinos.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    
    public Optional<Destino> avaliarDestino(Long id, double nota) {
        Optional<Destino> destinoOpt = buscarPorId(id);
        if (destinoOpt.isPresent() && nota >= 1 && nota <= 10) {
            destinoOpt.get().registrarAvaliacao(nota);
        }
        return destinoOpt;
    }

    
    public boolean excluir(Long id) {
        return destinos.removeIf(d -> d.getId().equals(id));
    }
}
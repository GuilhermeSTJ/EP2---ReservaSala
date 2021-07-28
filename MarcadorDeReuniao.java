import java.time.*;
import java.util.Collection;
import java.util.*;

public class MarcadorDeReuniao {
    List<Participante> listaParticipantes = new LinkedList<>();
    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes){
        for(int i = 0; i < listaDeParticipantes.size(); i++){

           
        }
    }

    public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
        Participante novoParticipante = new Participante();
        novoParticipante.setNome(participante);
        novoParticipante.setHorarioInicio(inicio);
        novoParticipante.setHorarioFim(fim);

        listaParticipantes.add(novoParticipante);

    }

    public void mostraSobreposicao(){
        
    }

}
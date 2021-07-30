import java.time.*;
import java.util.Collection;
import java.util.*;

public class MarcadorDeReuniao {
    List<Participante> listaParticipantes = new LinkedList<>();
    Map<LocalDateTime, LocalDateTime> sobreposicoes = new HashMap<>();
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

    /* public LocalDateTime comparador(LocalDateTime Ini1, LocalDateTime Ini2, LocalDateTime Fim1, LocalDateTime Fim2){
        LocalDateTime sobreposto = Ini1;
        if(Ini1.isBefore(Ini2)) 
        return sobreposto;

        
        if(Ini1.isBefore(Fim2) || Ini2.isAfter(Fim1)){
            
        }
        
    } 

    public LocalDateTime comparadorFim(LocalDateTime Fim1, LocalDateTime Fim2){
        
        return;
    }*/

    public void mostraSobreposicao(){
        LocalDateTime iniciocomp;
        LocalDateTime fimcomp;
        for (int i = 0; i < listaParticipantes.size(); i++ ){ //laço para determinar o valor a ser comparado
            iniciocomp = listaParticipantes.get(i).getHorariosInicio(); // alocando o valor de inicio
            fimcomp = listaParticipantes.get(i).getHorariosFim(); // alocando o valor de fim
            for (int j = 0; j < listaParticipantes.size(); j++){ // Valores que serão usados para comparar
                //If responsavel por ver se há intersecção entre os horarios se não houver então passamos para o proximo
                if(iniciocomp.isBefore(listaParticipantes.get(j).getHorariosFim()) || listaParticipantes.get(j).getHorariosInicio().isAfter(fimcomp)){
                    continue;
                } 
                //If comparando se os horários são do mesmo participante
                if( i == j){
                    continue;
                }             
                if(iniciocomp.isBefore(listaParticipantes.get(j).getHorariosInicio())){ // verifica qual Valor inicial engloba os dois casos
                    iniciocomp = listaParticipantes.get(j).getHorariosInicio();
                }
                if(fimcomp.isAfter(listaParticipantes.get(j).getHorariosFim())){// verifica qual Valor final engloba os dois casos
                    fimcomp = listaParticipantes.get(j).getHorariosFim();
                }
            }
            System.out.println("Inicio:" + iniciocomp + "fim:" + fimcomp);
            //sobreposicoes.put(iniciocomp, fimcomp); // adicionamos os valores no hashmap

        }
    System.out.println("values sobreposicoes " + sobreposicoes);
    //System.out.println();
    }

}
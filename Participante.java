import java.time.LocalDateTime;

public class Participante{ 
    private String nome;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;


    public void setHorarioInicio(LocalDateTime inicio){
        this.horarioInicio = inicio;
    }
    
    public void setHorarioFim(LocalDateTime fim){
        this.horarioFim = fim;
    }

    public LocalDateTime getHorariosInicio(){
        return horarioInicio;
    }

    public LocalDateTime getHorariosFim(){
        return horarioFim;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
import java.time.LocalDateTime;

public class Reserva extends Sala{   


    public Reserva(LocalDateTime inicio, LocalDateTime fim){
        Sala reservaSala = new Sala();
        this.inicio = inicio;
        this.fim = fim;
    }
    public Sala sala(){
        Sala reservaSala = new Sala();

        return reservaSala;

    }

    public LocalDateTime inicio(){
        return inicio;

    }

    public LocalDateTime fim(){
        return fim;
    }
}
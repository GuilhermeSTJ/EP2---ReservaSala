import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {
    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){

    }

    public void removeSalaChamada(String nomeDaSala){

    }

    public List<Sala> listaDeSalas(){
        List<Sala> lista = new ArrayList<>();

        return lista;
    }

    public void adicionaSala(Sala novaSala){

    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal){
        Reserva reserva = new Reserva();

        return reserva;
    }

    public void cancelaReserva(Reserva cancelada){

    }

    public Collection<Reserva> reservasParaSala(String nomeSala){
        Collection<Reserva> reservas = new ArrayList<>();

        return reservas;
    }

    public void imprimeReservasDaSala(String nomeSala){

    }
}

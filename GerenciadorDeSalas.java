import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {
    List<Sala> listaSalas = new ArrayList<>();
    Collection<Reserva> listaReservas = new ArrayList<>();

    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){
        Sala novaSala = new Sala(nome,capacidadeMaxima,descricao);
        adicionaSala(novaSala);

    }

    public void removeSalaChamada(String nomeDaSala){
        for(int i = 0; i < listaSalas.size(); i++){
            if(listaSalas.get(i).getNome() == nomeDaSala){
                listaSalas.remove(i);
            }
        }
    }

    public List<Sala> listaDeSalas(){
        
        return listaSalas;
    }

    public void imprimeLista(){
        for(int i = 0; i < listaSalas.size(); i++){
            System.out.println(listaSalas.get(i).getNome() +" "+ listaSalas.get(i).getCapacidade() + " "+ listaSalas.get(i).getDescricao());
        }

    }

    public void adicionaSala(Sala novaSala){
        listaSalas.add(novaSala);

    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal){
        Reserva reserva = new Reservateste();

        listaReservas.add(reserva);
        return reserva;
    }

    public void cancelaReserva(Reserva cancelada){

    }

    public Collection<Reserva> reservasParaSala(String nomeSala){
        
        return listaReservas;
    }

    public void imprimeReservasDaSala(String nomeSala){

    }
}
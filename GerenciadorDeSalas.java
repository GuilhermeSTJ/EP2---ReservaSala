import java.io.IOException;
import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {
    List<Sala> listaSalas = new LinkedList<>();
    List<Reserva> listaReservas = new LinkedList<>();

    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){
        Sala novaSala = new Sala(nome, capacidadeMaxima, descricao);
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

    public void impriReserva(){
            System.out.println(listaReservas);        
    }

    public void adicionaSala(Sala novaSala){
        listaSalas.add(novaSala);

    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws IOException{
        try{
            int cont = 0;
            for(int i = 0; i < listaSalas.size(); i++){
                if(listaSalas.get(i).getNome() == nomeDaSala) cont += 1;
            }
            if(cont == 1) throw new IOException();
        } catch(IOException e){
            System.out.println("Erro ao tentar reservar a sala");
        }

        
        Reserva reserva = new Reserva(nomeDaSala);
        reserva.setInicio(dataInicial);
        reserva.setInicio(dataFinal);

        listaReservas.add(reserva);
        return reserva;
    }

    public void cancelaReserva(Reserva cancelada){
        listaReservas.remove(cancelada);
    }

    public Collection<Reserva> reservasParaSala(String nomeSala){
        Collection<Reserva> reservasParaSala = new LinkedList<>();

        for(int i = 0; i < listaReservas.size(); i++){
            if(listaReservas.get(i).getNome() == nomeSala) reservasParaSala.add(listaReservas.get(i));
        }
        
        return reservasParaSala;
    }

    public void imprimeReservasDaSala(String nomeSala){
        
        for(int i = 0; i < listaReservas.size(); i++){
            if(listaReservas.get(i).getNome() == nomeSala) System.out.println(listaReservas.get(i));
        }
    }
}
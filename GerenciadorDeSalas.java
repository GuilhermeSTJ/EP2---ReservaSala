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

    // Metodo que retorna True quando a reserva é invalida
    public boolean verificaReservaSala(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal){
        /*
        Verificar se:
        Inexistente : Na listaSalas não existe uma sala com o nomeDaSala
        Existente mas imcopativel em horario: Existe na listaSalas, mas o horario marcado ja pertence a outro
        --Quando o horario ja esta marcado? -> quando a inicio ou fim da reunião estão dentro do intervalo
        de outra reunião
        I = inicio e F= fim I'> I > F' e ou I'> F > F' -
        I' = inicio de uma reunião marcada  // F' = inicio de uma reunião marcada
        I'1, I'2,..., I'n sendo n= numero de reuniões marcada // F'1, F'2,..., F'n sendo n= numero de reuniões marcada
        7 < I < 9 -> Estar errado  
        */ 
        int comp = 0;
        for(int i = 0; i < listaSalas.size(); i++){ // Verificação se a sala existe
            if(listaSalas.get(i).getNome() == nomeDaSala) comp = 1; // se existir comp = 1
        }
        if(comp == 0) return true; // se comp=0 sala não existe portanto return false

        Reserva reserva = new Reserva();

        LocalDateTime horainicial; 
        LocalDateTime horafinal; 

        for(int i = 0; i < listaReservas.size(); i++){ 
            if(listaReservas.get(i).getNome() == nomeDaSala) reserva = listaReservas.get(i);
            horainicial = reserva.getInicio();
            horafinal = reserva.getFim();
            if((horafinal.isBefore(dataFinal) && horafinal.isAfter(dataInicial)) || (horainicial.isBefore(dataFinal) && horainicial.isAfter(dataInicial))){
                return true;
            }
        }

        return false;
    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws Exception{
        Reserva reserva = new Reserva();
        try{
            if(verificaReservaSala(nomeDaSala, dataInicial, dataFinal)) throw new Exception();
            reserva.setNome(nomeDaSala);
            reserva.setInicio(dataInicial);
            reserva.setInicio(dataFinal);

            listaReservas.add(reserva);
                
        } catch(Exception e){
            System.out.println("Erro ao tentar reservar a sala");
        }

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
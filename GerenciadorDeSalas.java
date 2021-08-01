import java.time.*;
import java.util.*;

public class GerenciadorDeSalas {
    private List<Sala> listaSalas = new LinkedList<>();
    private List<Reserva> listaReservas = new LinkedList<>();
    Scanner teclado = new Scanner(System.in);

    public void adicionaSalaChamada(String nome, int capacidadeMaxima, String descricao){
        Sala novaSala = new Sala(nome, capacidadeMaxima, descricao);
        listaSalas.add(novaSala);
    }

    public void adicionaSala(Sala novaSala){
        System.out.println("Diga o nome da nova sala e em seguida a descricao");
        String nome = teclado.nextLine();
        String descricao = teclado.nextLine();
        System.out.println("Qual sera a capacidade dessa sala?");
        int capaci = teclado.nextInt();
        teclado.nextLine();
        novaSala.setCapacidade(capaci);
        novaSala.setDescricao(descricao);
        novaSala.setNome(nome);
        System.out.println("A sala nova tem nome:" + nome + " capacidade:" + capaci + " descricao:" + descricao);
        listaSalas.add(novaSala);

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
            System.out.println("\n"+ i+ "- " + listaSalas.get(i).getNome() +" "+ listaSalas.get(i).getCapacidade() + " "+ listaSalas.get(i).getDescricao());
        }

    }

    public void impriReserva(){
            System.out.println(listaReservas);        
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

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime dataInicial, LocalDateTime dataFinal) throws ErroSalaException{
        Reserva reserva = new Reserva();
       try{
            if(verificaReservaSala(nomeDaSala, dataInicial, dataFinal)) throw new ErroSalaException();
            else{    
                reserva.setNome(nomeDaSala);
                reserva.setInicio(dataInicial);
                reserva.setInicio(dataFinal);

                listaReservas.add(reserva);
            }                
        } catch(ErroSalaException e){
            throw e;
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
        int j = 0;
        for(int i = 0; i < listaReservas.size(); i++){
            if(listaReservas.get(i).getNome() == nomeSala){
                System.out.println(listaReservas.get(i)); 
                j++;
            } 
        }
        if (j == 0) System.out.println("Sala atualmente sem reservas ou nome digitado errado.");
    }

    public List<Reserva> retornaReservas(){
        return listaReservas;
    }
}
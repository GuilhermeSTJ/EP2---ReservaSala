import java.time.*;
import java.time.format.DateTimeFormatter;

public class testa {
    public static void main(String[] args) {
        GerenciadorDeSalas teste = new GerenciadorDeSalas();
  
        Reserva reserva = teste.reservaSalaChamada("testo", LocalDateTime.now(), LocalDateTime.now());
        Reserva reserva1 = teste.reservaSalaChamada("testudo", LocalDateTime.now(), LocalDateTime.now());
        Reserva reserva2 = teste.reservaSalaChamada("testo1", LocalDateTime.now(), LocalDateTime.now());
        Reserva reserva3 = teste.reservaSalaChamada("testo1", LocalDateTime.now(), LocalDateTime.now());
        Reserva reserva4 = teste.reservaSalaChamada("testo1", LocalDateTime.now(), LocalDateTime.now());
        Reserva reserva5 = teste.reservaSalaChamada("test027", LocalDateTime.now(), LocalDateTime.now());
        teste.impriReserva();
        /* teste.cancelaReserva(reserva2);
        teste.cancelaReserva(reserva3);
        teste.cancelaReserva(reserva4);
        teste.cancelaReserva(reserva); */
        teste.impriReserva();
        teste.imprimeReservasDaSala("testo1");

        //System.out.print(teste.reservasParaSala("testo1"));

    }
 
}  
       /*teste.adicionaSalaChamada("teste",2,"sala show de bola"); 
        teste.adicionaSalaChamada("teste2",1,"sala quase show de bola"); 
        teste.removeSalaChamada("teste2");
        teste.adicionaSalaChamada("teste3",0,"sala nada show de bola"); 
        //teste.imprimeLista();*/
           /* 2021-07-17T18:25:45.763828500
        A-M-D
        2021-07-19T18:27:41.098044300

    */
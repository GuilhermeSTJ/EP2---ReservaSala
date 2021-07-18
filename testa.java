import java.time.*;
import java.time.format.DateTimeFormatter;

public class testa {
    public static void main(String[] args) {
        GerenciadorDeSalas teste = new GerenciadorDeSalas();
        teste.adicionaSalaChamada("teste",2,"sala show de bola"); 
        teste.adicionaSalaChamada("teste2",1,"sala quase show de bola"); 
        teste.removeSalaChamada("teste2");
        teste.adicionaSalaChamada("teste3",0,"sala nada show de bola"); 
        teste.imprimeLista();
    }
    /* 2021-07-17T18:25:45.763828500
        A-M-D
        2021-07-19T18:27:41.098044300

    */
}   
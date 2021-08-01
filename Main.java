import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ErroSalaException{
        Collection<String> listaParticipantes = new LinkedList<>();
        Scanner scanner = new Scanner(new FileReader("ListaDeParticipantes.txt")).useDelimiter("\\n");
        MarcadorDeReuniao mDeReuniao = new MarcadorDeReuniao();
        GerenciadorDeSalas gDeSalas = new GerenciadorDeSalas();

        while(scanner.hasNext()) { // laço responsavel pela leitura da lista de participantes
            String[] linha = scanner.next().split(" & ");
            listaParticipantes.add(linha[0]);           
            
        }

        gDeSalas.adicionaSalaChamada("Teste 1", 30, "Descricao teste 1");
        gDeSalas.adicionaSalaChamada("Teste 2", 30, "Descricao teste 2");
        gDeSalas.adicionaSalaChamada("Teste 3", 30, "Descricao teste 3");
        gDeSalas.adicionaSalaChamada("Teste 4", 30, "Descricao teste 4");
        gDeSalas.adicionaSalaChamada("Teste 5", 30, "Descricao teste 5");
        gDeSalas.imprimeLista();
        try{
            mDeReuniao.marcarReuniaoEntre(LocalDate.now(),LocalDate.now(), listaParticipantes);
        } catch(ErroSalaException e){
            System.out.println(e.getMessage());
        }
        scanner.close();

    }
}
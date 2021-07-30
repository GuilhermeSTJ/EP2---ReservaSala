import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Collection<String> listaParticipantes = new LinkedList<>();
        Scanner scanner = new Scanner(new FileReader("ListaDeParticipantes.txt")).useDelimiter("\\n");
        MarcadorDeReuniao mDeReuniao = new MarcadorDeReuniao();
        while(scanner.hasNext()) { // laço responsavel pela leitura da lista de participantes
            String[] linha = scanner.next().split(" & ");
            listaParticipantes.add(linha[0]);
            
            mDeReuniao.indicaDisponibilidadeDe(linha[0], LocalDateTime.parse(linha[1]), LocalDateTime.parse(linha[2]));
            
            
        }
        mDeReuniao.mostraSobreposicao();

    }
}
 


/* LocalDateTime agora = LocalDateTime.now();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y h:m:s");

String agoraFormatado = agora.format(formatter);

System.out.println("LocalDateTime formatado: " + agoraFormatado); */
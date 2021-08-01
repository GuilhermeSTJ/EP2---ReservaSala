import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class MarcadorDeReuniao {
    private List<Participante> listaParticipantes = new LinkedList<>();
    private Map<String, String> sobreposicoes = new HashMap<>();
    private List<String> horarioReserva = new LinkedList<>();
    Scanner scan = new Scanner(System.in); 
    Scanner teclado1 = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in); 
    Scanner scan3 = new Scanner(System.in);
    Scanner scan4 = new Scanner(System.in);
    
    public void marcarReuniaoEntre(LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) throws ErroSalaException{
        /*
        1 - Fazer um for para a listaDeParticipantes e para cada participante enviar indicanDisponibilidadeDe
        2 - A partir da disponibilidade então temos que marcarSobreposicao 
        3 - A partir da sobreposição escolher o horarios reservar Sala
        */

        String [] nomes = listaDeParticipantes.toArray(new String[0]); 
        Scanner teclado = new Scanner(System.in); 
        GerenciadorDeSalas gSalas = new GerenciadorDeSalas();


        int x = 0;
        while (x != 9){
            System.out.println("\n\nO que voce deseja fazer?");
            System.out.println("1- Me mostre o intervalo de tempo disponivel.");
            System.out.println("2- Indicar a disponibilidade dos participantes.");
            System.out.println("3- Mostrar sobreposicoes e escolher horario novo para reserva.");
            System.out.println("4- Imprimir a lista de salas");
            System.out.println("5- Mostrar Reservas ja efetuadas em uma sala");
            System.out.println("6- Efetuar reserva de sala");
            System.out.println("7- Efetuar Cancelamento da reserva");
            System.out.println("8- Desejo gerar uma sala nova ");
            System.out.println("9- Desejo sair");
            x = teclado.nextInt();
            
            switch(x){
                case 1: {
                    System.out.println("\nO intervalo de tempo disponivel é de: " + dataInicial + " até "+ dataFinal); 
                    break;         
                }
                case 2: {
                    System.out.println("\nPor favor siga o padrão de horario dd/MM/aaaa HH:mm ");   
                    for(int i = 0; i < listaDeParticipantes.size(); i++){

                        System.out.println("\nOla participante: " + nomes[i] + " Qual seu horario disponivel inicial?");
                        String Inicial = scan.nextLine();
                        System.out.println("\nE qual seu horario disponivel final?");
                        String Final = scan.nextLine();
                        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");      
                        
                        LocalDateTime timeInicial = LocalDateTime.parse(Inicial, inputFormat);
                        LocalDateTime timeFinal = LocalDateTime.parse(Final, inputFormat);
            
                        indicaDisponibilidadeDe(nomes[i], timeInicial,timeFinal);
                    }
                    break;
                }
                case 3:{
                    sobreposicoes.clear();
                    mostraSobreposicao();
                    break;
                }
                case 4:{
                    System.out.print("\nTemos as seguintes salas:\n");
                    gSalas.imprimeLista();
                    break;
                }
                case 5:{
                    System.out.print("\nQual sala voce deseja ver as reservas?");
                    String reserva = scan2.nextLine();
                    gSalas.imprimeReservasDaSala(reserva);
                    break;
                }
                case 6:{
                    List<Sala> listaSalas = gSalas.listaDeSalas();
                    if(listaSalas.isEmpty()){
                        System.out.print("\nErro! não há reserva ou não há sala:");
                        break;  
                    } 
                    System.out.print("\nQual voce quer reservar, por favor insira o Primeiro digito:");
                    gSalas.imprimeLista();
                    int digito = scan3.nextInt();
                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime reservaInicial = LocalDateTime.parse(horarioReserva.get(0),inputFormat);
                    LocalDateTime reservaFinal = LocalDateTime.parse(horarioReserva.get(1),inputFormat);
                    try{
                        gSalas.reservaSalaChamada(listaSalas.get(digito).getNome(),reservaInicial, reservaFinal);
                    } catch(ErroSalaException e){
                        throw e;
                    }
                    break;
                }
                case 7:{
                    System.out.print("\nQual reserva voce deseja cancelar?");
                    String cancelar = scan4.nextLine();
                    List<Reserva> listaReservas = gSalas.retornaReservas();
                    int comp = 0;
                    for(int i = 0; i < listaReservas.size(); i++){
                        if(listaReservas.get(i).getNome() == cancelar){
                            gSalas.cancelaReserva(listaReservas.get(i));
                            comp++;
                            System.out.print("Reserva Cancelada");
                        }
                    }
                    if(comp != 0) System.out.println("Erro!");
                    break;
                }
                case 8:{
                    Sala novaSala = new Sala();
                    gSalas.adicionaSala(novaSala);
                }

                default:
                break;
            }
        }
        teclado.close();
        
    }

    //O participante indica sua disponibilidade passando uma data de inicio e fim
    public void indicaDisponibilidadeDe(String participante, LocalDateTime inicio, LocalDateTime fim){
        Participante novoParticipante = new Participante();
        novoParticipante.setNome(participante);
        novoParticipante.setHorarioInicio(inicio);
        novoParticipante.setHorarioFim(fim);

        listaParticipantes.add(novoParticipante);

    }

    public void mostraSobreposicao(){
        LocalDateTime iniciocomp;
        LocalDateTime fimcomp;
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (int i = 0; i < listaParticipantes.size(); i++ ){ //laço para determinar o valor a ser comparado
            iniciocomp = listaParticipantes.get(i).getHorariosInicio(); // alocando o valor de inicio
            fimcomp = listaParticipantes.get(i).getHorariosFim(); // alocando o valor de fim
            for (int j = 0; j < listaParticipantes.size(); j++){ // Valores que serão usados para comparar
                //If responsavel por ver se há intersecção entre os horarios se não houver então passamos para o proximo
                if(iniciocomp.isAfter(listaParticipantes.get(j).getHorariosFim()) || listaParticipantes.get(j).getHorariosInicio().isAfter(fimcomp)){
                    continue;
                } 
                //If comparando se os horários são do mesmo participante
                if( i == j){
                    continue;
                }             
                if(iniciocomp.isBefore(listaParticipantes.get(j).getHorariosInicio())){ // verifica qual Valor inicial engloba os dois casos
                    iniciocomp = listaParticipantes.get(j).getHorariosInicio();
                    
                }
                if(fimcomp.isAfter(listaParticipantes.get(j).getHorariosFim())){// verifica qual Valor final engloba os dois casos
                    fimcomp = listaParticipantes.get(j).getHorariosFim();
                }
            }
            if(iniciocomp.isEqual(fimcomp)) continue;  
        
            sobreposicoes.put(iniciocomp.format(inputFormat), fimcomp.format(inputFormat)); // adicionamos os valores no hashmap
        }
        //Verifica se o hashmap de sobreposicoes esta vazio
        if(!sobreposicoes.isEmpty()){
            System.out.println("Os horarios disponiveis sao: ");           
            int i = 1;
            //Da um print 
            for (Map.Entry<String, String> entry: sobreposicoes.entrySet()){
                String inicio = entry.getKey();
                String fim = entry.getValue();
            
                System.out.println(i +"- data inicial " + inicio +" e data final "+ fim);
                i++;
            }
            //Usuario escolhe o horario a ser reservado
            System.out.println("Entre os horarios disponiveis qual você escolhe?");
            System.out.println("Digite somente o numero");
            int valor = teclado1.nextInt();
            int k=1;
            for (Map.Entry<String, String> entry: sobreposicoes.entrySet()){
                if (valor != k){
                    k++;
                    continue;                
                }
                String inicio = entry.getKey();
                String fim = entry.getValue();
    
                //adicionando o horario escolhido pelo usuario na lista horarioReserva
                horarioReserva.add(inicio);
                horarioReserva.add(fim);
            }
        } else{
            System.out.println("Nao ha horarios sobrepostos.");
            
        }
    }
}
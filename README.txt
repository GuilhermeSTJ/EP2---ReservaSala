Alunos:
-Nome: Guilherme Sebastião Teodoro Junior Nusp=11953911
-Nome: Izabel C. Barranco Nusp=119847711

***********************************************************************************************************************************
Como compilar:
javac *.java
java Main(Classe principal)

***********************************************************************************************************************************
Atenções ao rodar o codigo:
Na classe MarcadorDeReuniao no metodo marcarReuniaoEntre esta presente um "menu"(interface console) onde podemos fazer
chamadas a todos metodos de MarcadorDeReuniao e alguns de GerenciadorDeSalas(Necessarios).
Sendo assim é muito importante fazer a chamada a esse metodo.
É necessario rodar o case "2" no menu antes do "3" visto que as sobreposicoes so ocorrem se for indicado as disponibilidades 

***********************************************************************************************************************************
Observações:
Para criar sala podemos tanto chamar o metodo adicionaSalaChamada pelo main ou pelo "menu" chamar o metodo
adicionaSala onde se pode gerar via console uma nova sala e suas informações.
Foram criados alguns metodos adicionais no GerenciadorDeSalas sendo a maioria responsavel por imprimir valores
de listas e um metodo booleano "verificaReservaSala" responsavel por verificar se a reserva pode ou não ser
 feita.
IndicaDisponibilidade só é capaz de marcar um horario por participante
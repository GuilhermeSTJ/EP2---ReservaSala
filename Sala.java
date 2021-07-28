public class Sala {
    private String nome;
    private String local;
    private String observacoes;
    private String descricao;
    private int capacidade;
    
    public Sala(){
    }
    
    public Sala(String nome){
        this.nome = nome;
    }
    public Sala(String nome, int capacidade ,String descricao){
        this.nome = nome;
        this.capacidade = capacidade;
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    

    
}

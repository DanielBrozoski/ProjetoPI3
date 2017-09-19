package br.edu.ifsc.projeto.model;

class Cidade {
    private int cida_codi;
    private String cida_nome;
    private Estado esta_codi;

    public Cidade(int cida_codi, String cida_nome, Estado esta_codi) {
        this.cida_codi = cida_codi;
        this.cida_nome = cida_nome;
        this.esta_codi = esta_codi;
    }

    public int getCida_codi() {
        return cida_codi;
    }

    public void setCida_codi(int cida_codi) {
        this.cida_codi = cida_codi;
    }

    public String getCida_nome() {
        return cida_nome;
    }

    public void setCida_nome(String cida_nome) {
        this.cida_nome = cida_nome;
    }

    public Estado getEsta_codi() {
        return esta_codi;
    }

    public void setEsta_codi(Estado esta_codi) {
        this.esta_codi = esta_codi;
    }
    
    
}

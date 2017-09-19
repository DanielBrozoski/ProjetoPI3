package br.edu.ifsc.projeto.model;

class Estado {
    private int esta_codi;
    private String esta_nome, esta_uf;

    public Estado(int esta_codi, String esta_nome, String esta_uf) {
        this.esta_codi = esta_codi;
        this.esta_nome = esta_nome;
        this.esta_uf = esta_uf;
    }

    public int getEsta_codi() {
        return esta_codi;
    }

    public void setEsta_codi(int esta_codi) {
        this.esta_codi = esta_codi;
    }

    public String getEsta_nome() {
        return esta_nome;
    }

    public void setEsta_nome(String esta_nome) {
        this.esta_nome = esta_nome;
    }

    public String getEsta_uf() {
        return esta_uf;
    }

    public void setEsta_uf(String esta_uf) {
        this.esta_uf = esta_uf;
    }
    
    
}

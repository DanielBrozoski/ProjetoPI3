package br.edu.ifsc.projeto.model;

/**
 *
 * @author Iva
 */
public class Contato {
    private String cont_emai, cont_tele, cont_celu;

    public Contato(String cont_emai, String cont_tele, String cont_celu) {
        this.cont_emai = cont_emai;
        this.cont_tele = cont_tele;
        this.cont_celu = cont_celu;
    }

    public String getCont_emai() {
        return cont_emai;
    }

    public void setCont_emai(String cont_emai) {
        this.cont_emai = cont_emai;
    }

    public String getCont_tele() {
        return cont_tele;
    }

    public void setCont_tele(String cont_tele) {
        this.cont_tele = cont_tele;
    }

    public String getCont_celu() {
        return cont_celu;
    }

    public void setCont_celu(String cont_celu) {
        this.cont_celu = cont_celu;
    }
    
    
}

package br.com.vainaweb.projetofinal.error;

public class DetectaErro {
    private boolean noProblem;
    private String mensagem;

    public DetectaErro(boolean noProblem, String mensagem) {
        this.noProblem = noProblem;
        this.mensagem = mensagem;
    }

    public boolean getNoProblem() {
        return noProblem;
    }

    public String getMensagem() {
        return mensagem;
    }
}

package main.sgt;

import java.util.ArrayList;
import java.util.List;

public class Aula {

    /**
     * O numero da aula
     */
    private int numero;
    /**
     * A lista dos alunos que estiveram presentes nesta aula
     */
    private List<String> presencas;
    /**
     * O numero do turno a que a aula pertence
     */
    private int turno;
    /**
     * O identificador da UC a que a aula pertence
     */
    private String uc;

    private boolean ePratico;

    /**
     * Construtor de aula
     * @param uc A UC do turno
     * @param turno O numero do turno da aula
     * @param ePratico Se a aula e pratica
     */
    public Aula(int numero, String uc, int turno, boolean ePratico) {
        this.uc = uc;
        this.turno = turno;
        this.numero = numero;
        this.ePratico = ePratico;
        this.presencas = new ArrayList<>();
    }

    public Aula(int numero, String uc, int turno, boolean ePratico, List<String> presencas) {
        this.numero = numero;
        this.uc = uc;
        this.turno = turno;
        this.ePratico = ePratico;
        this.presencas = presencas;
    }

    /**
     * Retorna o numero da Aula
     * @return O numero da Aula
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Marca presenca a um aluno
     * @param aluno Identificador do aluno
     */
    void marcarPresenca(String aluno) {
        if(!this.presencas.contains(aluno)){
            this.presencas.add(aluno);
        }
    }

    /**
     * Retorna o numero do turno a que a aula pertence
     * @return O numero do turno a que a aula pertence
     */
    public int getTurno() {
        return this.turno;
    }

    /**
     * Retorna o identificador da UC a que a aula pertence
     * @return O identificador da UC a que a aula pertence
     */
    public String getUc() {
        return this.uc;
    }

    public boolean ePratico() {
        return this.ePratico;
    }

    public List<String> getPresencas() {
        return new ArrayList<>(presencas);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Aula a = (Aula) o;
        return super.equals(o)
                && this.numero == a.getNumero()
                && this.turno == a.getTurno()
                && this.uc.equals(a.getUc())
                && this.ePratico == a.ePratico()
                && this.presencas.equals(a.getPresencas());
    }

    @Override
    public String toString() {
        return  "Aula: \t"
                +"Numero: "+this.numero+"\t"
                +"Turno: "+this.turno+"\t"
                +"UC: "+this.uc+"\t"
                +"E Pratica: "+ this.ePratico +"\t"
                +"Presencas: "+this.presencas.toString();
    }
}
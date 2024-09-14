package org.example;

public class MaquinaTuring {

    private final Fita fita;

    public MaquinaTuring(String palavra){
        this.fita = new Fita(palavra, 0);
    }

    public Boolean process(){
        System.out.println("--- Processamento nos estados: ---");
        return q1(this.fita);
    }

    private boolean q1(Fita fita){
        System.out.println("q1: " + fita.palavra);
        if (fita.palavra.isEmpty()){
            return q2();
        }
        if(fita.ponteiro < fita.palavra.length()){
            if (fita.palavra.charAt(fita.ponteiro) == 'a') {
                fita.palavra =
                        fita.palavra.substring(0, fita.ponteiro) + 'A' + fita.palavra.substring(fita.ponteiro + 1);
                fita.ponteiro++;
                return q3(fita);
            } else if (fita.palavra.charAt(fita.ponteiro) == 'B') {
                fita.palavra =
                        fita.palavra.substring(0, fita.ponteiro) + 'B' + fita.palavra.substring(fita.ponteiro + 1);
                fita.ponteiro++;
                return q5(fita);
            }
        }
        return false;
    }

    private boolean q5(Fita fita) {
        System.out.println("q5: " + fita.palavra);
        if (fita.ponteiro >= fita.palavra.length()){
            return q2();
        } else if (fita.palavra.charAt(fita.ponteiro) == 'B') {
            fita.ponteiro++;
            return q5(fita);
        }
        return false;
    }

    private boolean q2() {
        System.out.println("q2: " + fita.palavra);
        return true;
    }

    private boolean q3(Fita fita) {
        System.out.println("q3: " + fita.palavra);
        if(fita.ponteiro < fita.palavra.length()){
            if (fita.palavra.charAt(fita.ponteiro) == 'a' || fita.palavra.charAt(fita.ponteiro) == 'B') {
                fita.ponteiro++;
                return q3(fita);
            } else if (fita.palavra.charAt(fita.ponteiro) == 'b') {
                fita.palavra =
                        fita.palavra.substring(0, fita.ponteiro) + 'B' + fita.palavra.substring(fita.ponteiro + 1);
                fita.ponteiro--;
                return q4(fita);
            }
        }
        return false;
    }

    private boolean q4(Fita fita) {
        System.out.println("q4: " + fita.palavra);
        if(fita.ponteiro < fita.palavra.length()){
            if (fita.palavra.charAt(fita.ponteiro) == 'B' || fita.palavra.charAt(fita.ponteiro) == 'a') {
                fita.ponteiro--;
                return q4(fita);
            } else if (fita.palavra.charAt(fita.ponteiro) == 'A') {
                fita.ponteiro++;
                return q1(fita);
            }
        }
        return false;
    }
}

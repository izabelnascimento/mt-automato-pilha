package org.example;

import java.util.Stack;

public class AutomatoPilha {

    private final Fita fita;
    private final Stack<Character> pilha;

    public AutomatoPilha(String palavra){
        this.fita = new Fita(palavra, 0);
        this.pilha = new Stack<>();
    }

    public Boolean process(){
        System.out.println("--- Processamento nos estados: ---");
        return q0(this.fita, this.pilha);
    }

    private boolean q0(Fita fita, Stack<Character> pilha){
        System.out.println("q0: " + pilha);
        if (fita.ponteiro < fita.palavra.length() && fita.palavra.charAt(fita.ponteiro) == 'a'){
            fita.ponteiro++;
            pilha.push('x');
            return q0(fita, pilha);
        }
        return q1(fita, pilha);
    }

    private boolean q1(Fita fita, Stack<Character> pilha){
        System.out.println("q1: " + pilha);
        if (fita.palavra.length() == fita.ponteiro && pilha.empty()){
            return q2();
        } else if (fita.ponteiro < fita.palavra.length() && fita.palavra.charAt(fita.ponteiro) == 'b') {
            fita.ponteiro++;
            if (!pilha.empty() && pilha.pop() == 'x'){
                return q1(fita, pilha);
            } else return false;
        }
        return false;
    }

    private boolean q2() {
        System.out.println("q2: " + pilha);
        return true;
    }
}

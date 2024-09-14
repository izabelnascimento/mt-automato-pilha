package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

//        EXECUTAR EM TELA
        SwingUtilities.invokeLater(() -> {
            FrameInterface frameInterface = new FrameInterface();
            frameInterface.setVisible(true);
        });

//        EXECUTAR NO TERMINAL
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\nLinguagem: {a^n a^n / n >= 0}");
//        System.out.println("Selecione um Formalismo Reconhecedor");
//        System.out.println("1- Autômato com Pilha; 2- Máquina de Turing");
//        int op = scanner.nextInt();
//
//        if (op == 1) {
//            while (true) {
//                System.out.println("\n------ AUTÔMATO COM PILHA -------");
//                System.out.println("( - representa vazio)");
//                System.out.println("Digite a palavra: ");
//                String palavra = scanner.next();
//
//                if (palavra.equals("-")) palavra = "";
//
//                AutomatoPilha automatoPilha = new AutomatoPilha(palavra);
//                Boolean accepeted = automatoPilha.process();
//                System.out.println("Palavra '" + palavra + "' aceita?");
//                System.out.println(accepeted);
//            }
//        } else if (op ==2) {
//            while (true) {
//                System.out.println("\n------- MÁQUINA DE TURING -------");
//                System.out.println("( - representa vazio)");
//                System.out.println("Digite a palavra: ");
//                String palavra = scanner.next();
//
//                if (palavra.equals("-")) palavra = "";
//
//                MaquinaTuring maquinaTuring = new MaquinaTuring(palavra);
//                Boolean accepeted = maquinaTuring.process();
//                System.out.println("Palavra '" + palavra + "' aceita?");
//                System.out.println(accepeted);
//            }
//        }
    }
}

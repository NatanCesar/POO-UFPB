package fibonacci;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a quantidade de termos que deseja gerar na sequência de Fibonacci: ");
        int quantidadeTermos = input.nextInt();

        // Cria o array para armazenar os termos da sequência
        int[] fibonacci = new int[quantidadeTermos];

        // Inicializa os primeiros termos da sequência
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // Gera os próximos termos da sequência
        for (int i = 2; i < quantidadeTermos; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }



        // Exibe a sequência de Fibonacci gerada
        System.out.println("Sequência de Fibonacci gerada com For: ");
        for (int i = 0; i < quantidadeTermos; i++) {
            System.out.print(fibonacci[i] + " ");
        }


        System.out.println("\nSequência de Fibonacci gerada com While: ");
        int cont = 0;
        while (cont < quantidadeTermos){
            System.out.print(fibonacci[cont] + " ");
            cont++;
        }


        System.out.println("\nSequência de Fibonacci de forma Recursiva: ");
        int r = 0;
        while (r < quantidadeTermos){
            System.out.print(" " + calcularFibonacci(r));
            r++;
        }



        input.close();
    }


    // Modo Recursivo //
    public static int calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}

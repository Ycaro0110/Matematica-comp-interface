package com.example.interfacetrabalho;

import org.mariuszgromada.math.mxparser.*;

public class Posicao_falsa {

    public double erro;
    public int iteracoes = 0;

    // Método que implementa a Posição Falsa
    public double posicaoFalsa(String funcStr, double a, double b, double erroTolerado) {

        // Inicializando as variáveis a e b
        Argument x = new Argument("x");

        // Expressão para a função
        Expression func = new Expression(funcStr, x);

        // Verifica se f(a) e f(b) têm sinais opostos
        x.setArgumentValue(a);
        double fa = func.calculate();
        x.setArgumentValue(b);
        double fb = func.calculate();

        if (fa * fb >= 0) {
            System.out.println("f(a) e f(b) devem ter sinais opostos.");
            return 0;
        }

        double xr = a;  // Aproximação inicial da raiz
        double erroAtual;

        // Itera até que o erro seja menor que o erro tolerado
        do {
            // Calcula f(a) e f(b) a cada iteração
            x.setArgumentValue(a);
            fa = func.calculate();
            x.setArgumentValue(b);
            fb = func.calculate();

            // Calcula o ponto de interseção da linha reta (fórmula da Posição Falsa)
            xr = (a * fb - b * fa) / (fb - fa);

            // Calcula f(xr)
            x.setArgumentValue(xr);
            double fr = func.calculate();

            // Verifica se a raiz exata foi encontrada
            if (Math.abs(fr) < erroTolerado) {
                System.out.println("Raiz encontrada: x = " + xr);
                return xr;
            }

            // Atualiza o intervalo com base no sinal de f(xr)
            if (fa * fr < 0) {
                b = xr;
            } else {
                a = xr;
            }

            // Calcula o erro atual (diferença entre o valor anterior e o novo)
            erroAtual = Math.abs(b - a);

            // Mostra o erro atual para acompanhar as iterações
            this.iteracoes++;
            this.erro = erroAtual;
            System.out.println("Iteração: x = " + xr + ", Erro atual = " + erroAtual);

        } while (erroAtual > erroTolerado);


        // Retorna o valor aproximado da raiz
        return xr;
    }


}
package com.example.interfacetrabalho;

import org.mariuszgromada.math.mxparser.Function;

import org.mariuszgromada.math.mxparser.mXparser;


public class Bissecao {

    public double bissecao(double x1, double x2, double e, String func) {
        Function f = new Function("f(x) = " + func);

        //calcula a estimativa de iterações
        int max_iteracao = (int) (Math.ceil(Math.log(x2 - x1) - Math.log(e)) / Math.log(2));

        //calcula a metade do intervalo (a+b)/2
        double x_medio = 0;
        double x_old;
        double erro_estimado;
        int num_iteracao = 0;

        //continua as iterações enquanto o erro estimado for maior que o erro desejado
        //ou enquanto enquanto o numero de iterações for menor que o esperado


        do {
            //Verifica se há uma raiz localizada no intervalo, através do teorema de bolzano
            double bolzano = f.calculate(x1) * f.calculate(x2);
            if (bolzano > 0) {
                return 0;
            }

            //armazena o x_medio da iteração anterior em uma variavel
            x_old = x_medio;

            //calcula um novo x_medio
            x_medio = (x1 + x2) / 2;
            num_iteracao++;

            //caso o x seja a raiz, ele é retornado
            if (f.calculate(x_medio) == 0) {
                return x_medio;
            }

            if (f.calculate(x1) == 0) {
                return x1;
            } else if (f.calculate(x2) == 0) {
                return x2;
            }

            //faz a verificação dos sinais e aponta qual será o novo intervalo superior ou inferior
            double teste = f.calculate(x1) * f.calculate(x_medio);
            if (teste > 0) {
                x1 = x_medio;
            } else {
                x2 = x_medio;
            }

            //faz o erro estimado entre o x_medio atual e o anterior

            erro_estimado = x_medio - x_old; // erro absoluto

        } while (erro_estimado >= e || num_iteracao < max_iteracao);
        //ao final das iterações retorna a raiz encontrada

        return x_medio;
    }

}

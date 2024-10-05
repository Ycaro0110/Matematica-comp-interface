package com.example.interfacetrabalho;

import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.mXparser;

public class Secante {

    public int iteracoes = 0;
    public double erro;

    public double secante(double x0, double x1, double e1, String func) {
        Function f = new Function("f(x) = " + func);



        int maxItera = 100; //max iteracoes estipuladas
        int itera = 1;
        double e2;
        double x2;
        e2 = e1;

        if (Math.abs(f.calculate(x0)) < e1) {   //filtro 1
            System.out.println(x0);
            return x0;
        } else if (Math.abs(f.calculate(x1)) < e1 || Math.abs(x1 - x0) < e2) {    //filtro 2
            System.out.println(x1);
            return x1;
        }

        //loop para as iterações

        while (itera < maxItera) {
            x2 = x1 - (f.calculate(x1) / (f.calculate(x1) - f.calculate(x0))) * (x1 - x0); //formula para iteração


            this.erro = Math.abs(x2-x1);

            if (Math.abs(f.calculate(x2)) < e1 || Math.abs(x2 - x1) < e2) { //filtro 3
                return x2;
            }
            x0 = x1; //atribuicao das variaveis;
            x1 = x2;
            itera++;

            this.iteracoes++;

        }

        //Caso não se encontre o x;
        System.out.println("Número máximo de iterações alcançado sem encontrar a raiz.");

        return Double.NaN;
    }
}


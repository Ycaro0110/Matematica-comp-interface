package com.example.interfacetrabalho;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.mariuszgromada.math.mxparser.License;
import org.mariuszgromada.math.mxparser.mXparser;

public class HelloController {
    @FXML
    public Button calc;
    @FXML
    private TextField x_1;
    @FXML
    private TextField x_2;
    @FXML
    private TextField erro_field;
    @FXML
    private TextArea equacao;
    @FXML
    private Label resultado;
    final ToggleGroup botoes = new ToggleGroup();
    @FXML
    private RadioButton bissec;
    @FXML
    private RadioButton newton;
    @FXML
    private RadioButton secant;
    @FXML
    private RadioButton pos_falsa;
    @FXML
    private RadioButton todos;


    @FXML
    protected void cliqueAqui() {
        newton.setToggleGroup(botoes);
        pos_falsa.setToggleGroup(botoes);
        bissec.setToggleGroup(botoes);
        secant.setToggleGroup(botoes);
        todos.setToggleGroup(botoes);
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Ycaro");
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        String message = License.getUseTypeConfirmationMessage();

        mXparser.consolePrintln("isCallSuccessful = " + isCallSuccessful);
        mXparser.consolePrintln("isConfirmed = " + isConfirmed);
        mXparser.consolePrintln("message = " + message);


        Bissecao m1 = new Bissecao();
        Secante m2 = new Secante();
        Newton_raph m3 = new Newton_raph();
        Posicao_falsa m4 = new Posicao_falsa();

        double x1 = Double.parseDouble(x_1.getText());
        double x2 = Double.parseDouble(x_2.getText());
        double erro = Double.parseDouble(erro_field.getText());

        double resultado_bissecao = m1.bissecao(x1, x2, erro, equacao.getText());
        double resultado_secante = m2.secante(x1, x2, erro, equacao.getText());
        double resultado_newton = m3.newtonRaphson(equacao.getText(), x1, erro);
        double resultado_posicaoFalsa = m4.posicaoFalsa(equacao.getText(), x1, x2, erro);


        if (bissec.isSelected()) {
            resultado.setText("A raiz é : " + resultado_bissecao + "    " + m1.iteracoes + " iterações" + "    E: " + m1.erro);
        } else if (secant.isSelected()) {
            resultado.setText("A raiz é : " + resultado_secante + "    " + m3.iteracoes + " iterações" + "    E: " + m3.erro);
        } else if (newton.isSelected()) {
            resultado.setText("A raiz é : " + resultado_newton + "    " + m2.iteracoes + " iterações" + "    E: " + m2.erro);
        } else if (pos_falsa.isSelected()) {
            resultado.setText("A raiz é : " + resultado_posicaoFalsa + "    " + m4.iteracoes + " iterações" + "    E: " + m4.erro);
        } else if (todos.isSelected()) {
            resultado.setText("Bisseção: " + resultado_bissecao + "    " + m1.iteracoes + " iterações" + "    E: " + m1.erro + "\n"
                    + "Newton: " + resultado_newton + "    " + m3.iteracoes + " iterações" + "    E: " + m3.erro + "\n"
                    + "Secante: " + resultado_secante + "    " + m2.iteracoes + " iterações" + "    E: " + m2.erro + "\n"
                    + "Posição-falsa: " + resultado_posicaoFalsa + "    " + m4.iteracoes + " iterações" + "    E: " + m4.erro + "\n");

        }


    }


}
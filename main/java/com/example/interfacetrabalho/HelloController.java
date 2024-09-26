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
    protected void cliqueAqui() {
        newton.setToggleGroup(botoes);
        pos_falsa.setToggleGroup(botoes);
        bissec.setToggleGroup(botoes);
        secant.setToggleGroup(botoes);
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Ycaro");
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        String message = License.getUseTypeConfirmationMessage();

        mXparser.consolePrintln("isCallSuccessful = " + isCallSuccessful);
        mXparser.consolePrintln("isConfirmed = " + isConfirmed);
        mXparser.consolePrintln("message = " + message);


        double resultado1 = getResultado();

        String raiz = Double.toString(resultado1);
        if (raiz.equals("0.0")) {
            resultado.setText("Não existe raiz neste intervalo");
        } else {
            resultado.setText("A raiz é : " + raiz);
        }


    }

    private double getResultado() {
        Bissecao m1 = new Bissecao();
        Secante m2 = new Secante();
        Newton_raph m3 = new Newton_raph();

        double x1 = Double.parseDouble(x_1.getText());
        double x2 = Double.parseDouble(x_2.getText());
        double erro = Double.parseDouble(erro_field.getText());
        // String expressao = equacao.getText();

        double resultado1 = 0;
        if (bissec.isSelected()) {
            resultado1 = m1.bissecao(x1, x2, erro, equacao.getText());
        } else if (secant.isSelected()) {
            resultado1 = m2.secante(x1, x2, erro, equacao.getText());
        } else if (newton.isSelected()) {
            resultado1 = m3.newtonRaphson(equacao.getText(), x1, erro);
        }

        return resultado1;
    }
}
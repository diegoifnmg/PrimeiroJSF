/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Diego
 */
@Named(value = "teste")
@SessionScoped
public class teste implements Serializable {

    private String valor;
    private int operandoA,operandoB,soma;
    
    public void soma(){
      
        soma = operandoA + operandoB;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getOperandoA() {
        return operandoA;
    }

    public void setOperandoA(int operandoA) {
        this.operandoA = operandoA;
    }

    public int getOperandoB() {
        return operandoB;
    }

    public void setOperandoB(int operandoB) {
        this.operandoB = operandoB;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }
    
    public teste() {
    }
}

package com.joaovictorsm.padcalculator;

import java.io.Serializable;

public class ResultMomento implements Serializable {
    // entradas
    private double cobrimento, ap, bp, fyk, cargaPilar, fck, tensaoSolo, acoPilar, mx, my;
    // saidas
    private double a, b, h, d, ca, cb, hzero, vsapata, psapata, m1ak, m1bk,
            areaAcoA, areaAcoB, xa, xb, numIteracoes;
    private double[] numeroBarrasA, numeroBarrasB, espacamentoBarrasA, espacamentoBarrasB;

    @Override
    public String toString() {
        String resumo =
                "COBRIMENTO = " + cobrimento + "," +
                        "LADO A DO PILAR = " + ap + "," +
                        "Lado b do pilar = " + bp + "," +
                        "fyk =  " + fyk + "," +
                        "Nk =  " + cargaPilar + "," +
                        "fck =  " + fck + "," +
                        "Tensão adimíssivel do solo =  " + tensaoSolo + "," +
                        "A Sapata =  " + a + "," +
                        "B Sapata =  " + b + "," +
                        "h =  " + h + "," +
                        "d =  " + d + "," +
                        "Ca =  " + ca + "," +
                        "Cb =  " + cb + "," +
                        "h0 =  " + hzero + "," +
                        "Volume da Sapata =  " + vsapata + "," +
                        "Peso da Sapata =  " + psapata + "," +
                        "Momento A característico =  " + m1ak + "," +
                        "Momento B característico =  " + m1bk + "," +
                        "Área Aço A =  " + areaAcoA + "," +
                        "Área Aço B =" + areaAcoB + "," +
                        "Iterações =" + numIteracoes + "," +
                        "Numero Barras A =" + vectorToString(numeroBarrasA) + "," +
                        "Numero Barras B =" + vectorToString(numeroBarrasB) + "," +
                        "Espacamento Barras A =" + vectorToString(espacamentoBarrasA) + "," +
                        "Espacamento Barras B =" + vectorToString(espacamentoBarrasB) +
                        "Aço do pilar =" + acoPilar;
        return resumo;
    }

    public ResultMomento(double cobrimento, double ap, double bp, double fyk,
                         double cargaPilar, double fck, double tensaoSolo, double acoPilar,
                         double mx, double my, double a, double b, double h, double d,
                         double ca, double cb, double hzero, double vsapata, double psapata,
                         double m1ak, double m1bk, double areaAcoA, double areaAcoB,
                         double xa, double xb, double numIteracoes, double[] numeroBarrasA,
                         double[] numeroBarrasB, double[] espacamentoBarrasA,
                         double[] espacamentoBarrasB) {
        this.cobrimento = cobrimento;
        this.ap = ap;
        this.bp = bp;
        this.fyk = fyk;
        this.cargaPilar = cargaPilar;
        this.fck = fck;
        this.tensaoSolo = tensaoSolo;
        this.acoPilar = acoPilar;
        this.mx = mx;
        this.my = my;
        this.a = a;
        this.b = b;
        this.h = h;
        this.d = d;
        this.ca = ca;
        this.cb = cb;
        this.hzero = hzero;
        this.vsapata = vsapata;
        this.psapata = psapata;
        this.m1ak = 1.4 * m1ak;//this.m1ak = m1ad nesse caso vai ser o momento de projeto para nao refazer tudo
        this.m1bk = 1.4 * m1bk;//this.m1bk = m1bd nesse caso vai ser o momento de projeto para nao refazer tudo
        this.areaAcoA = areaAcoA;
        this.areaAcoB = areaAcoB;
        this.xa = xa;
        this.xb = xb;
        this.numIteracoes = numIteracoes;
        this.numeroBarrasA = numeroBarrasA;
        this.numeroBarrasB = numeroBarrasB;
        this.espacamentoBarrasA = espacamentoBarrasA;
        this.espacamentoBarrasB = espacamentoBarrasB;
    }


    private String vectorToString(double[] vector) {
        String text = "[";
        for (double aux : vector) {
            text += " " + aux;
        }
        text += "]";
        return text;
    }

    public double getCobrimento() {
        return cobrimento;
    }

    public void setCobrimento(double cobrimento) {
        this.cobrimento = cobrimento;
    }

    public double getAp() {
        return ap;
    }

    public void setAp(double ap) {
        this.ap = ap;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    public double getFyk() {
        return fyk;
    }

    public void setFyk(double fyk) {
        this.fyk = fyk;
    }

    public double getCargaPilar() {
        return cargaPilar;
    }

    public void setCargaPilar(double cargaPilar) {
        this.cargaPilar = cargaPilar;
    }

    public double getFck() {
        return fck;
    }

    public void setFck(double fck) {
        this.fck = fck;
    }

    public double getTensaoSolo() {
        return tensaoSolo;
    }

    public void setTensaoSolo(double tensaoSolo) {
        this.tensaoSolo = tensaoSolo;
    }

    public double getAcoPilar() {
        return acoPilar;
    }

    public void setAcoPilar(double acoPilar) {
        this.acoPilar = acoPilar;
    }

    public double getMx() {
        return mx;
    }

    public void setMx(double mx) {
        this.mx = mx;
    }

    public double getMy() {
        return my;
    }

    public void setMy(double my) {
        this.my = my;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getCb() {
        return cb;
    }

    public void setCb(double cb) {
        this.cb = cb;
    }

    public double getHzero() {
        return hzero;
    }

    public void setHzero(double hzero) {
        this.hzero = hzero;
    }

    public double getVsapata() {
        return vsapata;
    }

    public void setVsapata(double vsapata) {
        this.vsapata = vsapata;
    }

    public double getPsapata() {
        return psapata;
    }

    public void setPsapata(double psapata) {
        this.psapata = psapata;
    }

    public double getM1ak() {
        return m1ak;
    }

    public void setM1ak(double m1ak) {
        this.m1ak = m1ak;
    }

    public double getM1bk() {
        return m1bk;
    }

    public void setM1bk(double m1bk) {
        this.m1bk = m1bk;
    }

    public double getAreaAcoA() {
        return areaAcoA;
    }

    public void setAreaAcoA(double areaAcoA) {
        this.areaAcoA = areaAcoA;
    }

    public double getAreaAcoB() {
        return areaAcoB;
    }

    public void setAreaAcoB(double areaAcoB) {
        this.areaAcoB = areaAcoB;
    }

    public double getXa() {
        return xa;
    }

    public void setXa(double xa) {
        this.xa = xa;
    }

    public double getXb() {
        return xb;
    }

    public void setXb(double xb) {
        this.xb = xb;
    }

    public double getNumIteracoes() {
        return numIteracoes;
    }

    public void setNumIteracoes(double numIteracoes) {
        this.numIteracoes = numIteracoes;
    }

    public double[] getNumeroBarrasA() {
        return numeroBarrasA;
    }

    public void setNumeroBarrasA(double[] numeroBarrasA) {
        this.numeroBarrasA = numeroBarrasA;
    }

    public double[] getNumeroBarrasB() {
        return numeroBarrasB;
    }

    public void setNumeroBarrasB(double[] numeroBarrasB) {
        this.numeroBarrasB = numeroBarrasB;
    }

    public double[] getEspacamentoBarrasA() {
        return espacamentoBarrasA;
    }

    public void setEspacamentoBarrasA(double[] espacamentoBarrasA) {
        this.espacamentoBarrasA = espacamentoBarrasA;
    }

    public double[] getEspacamentoBarrasB() {
        return espacamentoBarrasB;
    }

    public void setEspacamentoBarrasB(double[] espacamentoBarrasB) {
        this.espacamentoBarrasB = espacamentoBarrasB;
    }

}
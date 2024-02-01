/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion;

import com.itextpdf.text.BaseColor;
import java.awt.Color;
import javax.swing.DefaultListModel;

/**
 * Esta clase va a gestionar las categorías, todos los gastos que se añadan
 * con sus respectivos conceptos y su color
 * <p>
 * Tiene un constructor, un método get para cada variable, una sobrecarga en el
 * método añadirGasto, un método getUltimoGasto, un método getUltimoConcepto, un
 * método anadirGastoIndividual y un método verGastos  </p>
 * @author emont
 * @version 1.0
 */
public class Categoria {

    private Color color;
    private BaseColor colorBase;
    private String nombre;
    private float gastos;
    DefaultListModel<String> gastosIndividuales = new DefaultListModel<>();
    DefaultListModel<String> conceptos = new DefaultListModel<>();

    /**
     * Constructor
     *
     * @param c
     * @param bC
     * @param n
     */
    public Categoria(Color c, BaseColor bC, String n) {
        this.color = c;
        this.colorBase = bC;
        this.nombre = n;

    }

    /**
     * Obtiene el color de la categoría en formato RGB.
     *
     * @return El color de la categoría.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Obtiene el color de la categoría en formato BaseColor.
     *
     * @return El color de la categoría en formato BaseColor.
     */
    public BaseColor getColorBase() {
        return colorBase;
    }

    /**
     * Obtiene el total de gastos en la categoría.
     *
     * @return El total de gastos en la categoría.
     */
    public float getGasto() {
        return gastos;
    }

    /**
     * Obtiene el total de gastos en la categoría como entero.
     *
     * @return El total de gastos en la categoría como entero.
     */
    public int getGastoInt() {
        return (int) gastos;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de gastos registrados en la categoría.
     *
     * @return El tamaño de la lista de gastos individuales.
     */
    public int getTamanoGastos() {
        return gastosIndividuales.getSize();
    }

    /**
     * Obtiene el último gasto registrado en la categoría.
     *
     * @return Una cadena que representa el último gasto. Si no hay gastos
     * registrados, devuelve "0€".
     */
    public String getUltimoGasto() {
        if (!gastosIndividuales.isEmpty()) {
            return gastosIndividuales.elementAt(gastosIndividuales.getSize() - 1);
        } else {
            return "0€";
        }

    }

    /**
     * Obtiene el concepto almacenado en la posición relativa indicada.
     *
     * Este método devuelve el concepto ubicado en la posición relativa respecto
     * al concepto más reciente almacenado en la lista. Por ejemplo, si num es
     * 1, se devolverá el concepto más reciente; si es 2, se obtendrá el segundo
     * concepto más reciente, y así sucesivamente.
     *
     * @param num La posición relativa del concepto que se desea obtener.
     * @return El concepto almacenado en la posición indicada. Si la posición no
     * es válida o la lista de conceptos está vacía, se devuelve una cadena
     * vacía.
     */
    public String getConceptos(int num) {
        if (num <= conceptos.getSize()) {
            if (!conceptos.isEmpty()) {
                return conceptos.elementAt(conceptos.getSize() - num);
            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    /**
     * Obtiene el gasto correspondiente al número proporcionado.
     *
     * @param num Número que indica la posición del gasto, siendo 1 el último, 2
     * el penúltimo, y así sucesivamente.
     * @return El gasto correspondiente al número indicado o "0€" si no hay
     * gastos registrados.
     */
    public String getGastos(int num) {
        if (num <= gastosIndividuales.getSize()) {
            if (!gastosIndividuales.isEmpty()) {
                return gastosIndividuales.elementAt(gastosIndividuales.getSize() - num);
            } else {
                return "0€";
            }
        } else {
            return "0€";
        }

    }

    /**
     * Obtiene el último concepto registrado.
     *
     * @return El último concepto registrado o una cadena vacía si no hay
     * conceptos.
     */
    public String getUltimoConcepto() {
        if (!conceptos.isEmpty()) {
            return conceptos.elementAt(conceptos.getSize() - 1);
        } else {
            return "";
        }
    }

    /**
     * Añade un gasto entero a la categoría.
     *
     * @param g El gasto entero a añadir.
     */
    public void anadirGasto(int g) {
        this.gastos = gastos + g;
    }

    /**
     * Añade un gasto decimal a la categoría.
     *
     * @param g El gasto decimal a añadir.
     */
    public void anadirGasto(float g) {
        this.gastos = gastos + g;
    }

    /**
     * Añade un gasto individual a la categoría.
     *
     * @param d El monto del gasto.
     * @param concepto La descripción o concepto del gasto.
     */
    public void anadirGastoIndividual(float d, String concepto) {
        String dinero = d + "€";
        gastosIndividuales.addElement(dinero);
        conceptos.addElement(concepto);
    }

}

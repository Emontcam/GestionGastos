/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * Clase que personaliza la apariencia de una barra de desplazamiento. Extiende
 * BasicScrollBarUI y redefine varios métodos para personalizar colores y
 * estilos.
 *
 * @author emont
 * @version 1.0
 */
public class PersonalizarBarra extends BasicScrollBarUI {

    private final Color barraColor = new Color(167, 204, 204);
    private final Color fondoColor = new Color(0, 102, 102);
    private final Color flechaColor = new Color(0, 102, 102);

    /**
     * Crea y devuelve un botón de flecha para la barra de desplazamiento.
     *
     * @param orientation Orientación del botón de flecha.
     * @return Botón de flecha personalizado.
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createArrowButton(orientation);
    }

    /**
     * Crea y devuelve un botón de flecha para la barra de desplazamiento.
     *
     * @param orientation Orientación del botón de flecha.
     * @return Botón de flecha personalizado.
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createArrowButton(orientation);
    }

    /**
     * Crea y devuelve un botón de flecha personalizado para la barra de
     * desplazamiento.
     *
     * @param orientation Orientación del botón de flecha (SwingConstants.NORTH,
     * SOUTH, EAST o WEST).
     * @return Botón de flecha personalizado.
     */
    private JButton createArrowButton(int orientation) {
        return new BasicArrowButton(orientation, flechaColor, fondoColor, barraColor, barraColor) {
            /**
             * Pinta el componente, llenando el área con el color de fondo.
             *
             * @param g Gráfico utilizado para pintar el componente.
             */
            @Override
            public void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.setColor(fondoColor);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }

    /**
     * Pinta el "pulgar" (parte móvil) de la barra de desplazamiento.
     *
     * @param g Gráfico utilizado para pintar el pulgar.
     * @param c Componente de la barra de desplazamiento.
     * @param thumbBounds Área del pulgar.
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle thumbBounds) {
        g.setColor(barraColor);
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }

    /**
     * Pinta la "pista" (parte inmóvil) de la barra de desplazamiento.
     *
     * @param g Gráfico utilizado para pintar la pista.
     * @param c Componente de la barra de desplazamiento.
     * @param trackBounds Área de la pista.
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle trackBounds) {
        g.setColor(fondoColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }
}

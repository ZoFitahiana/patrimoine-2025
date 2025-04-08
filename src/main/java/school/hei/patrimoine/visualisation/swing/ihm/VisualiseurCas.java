package school.hei.patrimoine.visualisation.swing.ihm;

import school.hei.patrimoine.cas.example.*;

import java.util.List;

import static java.awt.EventQueue.invokeLater;

public class VisualiseurCas {

    public static void main(String[] args) {
        invokeLater(
                () ->
                        new MainIHM(
                                List.of(
                                        new EtudiantPireCas().patrimoine(),
                                        new PatrimoineRicheSupplier().get(),
                                        new PatrimoineCresusSupplier().get(),
                                        new PatrimoineZetyAu3Juillet2024().get(),
                                        new PatrimoineTiana().get(),
                                        new PatrimoineBako().get())));
    }
}

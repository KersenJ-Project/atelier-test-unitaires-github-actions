
package ca.cegepmv.atelier;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatriceTest {

    private final Calculatrice calculatrice = new Calculatrice();

    // Niveau 1

    @Test
    void additionnerDeuxNombresPositifs() {
        int a = 2;
        int b = 3;

        int resultat = calculatrice.additionner(a, b);

        assertEquals(5, resultat);
    }

    @Test
    void soustraireDonneLaDifference() {
        int a = 10;
        int b = 4;

        int resultat = calculatrice.soustraire(a, b);

        assertEquals(6, resultat);
    }

    @Test
    void multiplierDeuxNombres() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int resultat = calculatrice.multiplier(a, b);

        // Assert
        assertEquals(20, resultat);
    }

    @Test
    void maxRetourneLePlusGrandDesDeuxNombres() {
        // Arrange
        int a = 7;
        int b = 3;

        // Act
        int resultat = calculatrice.max(a, b);

        // Assert
        assertEquals(7, resultat);
    }

    // Niveau 2

    @Test
    void estPairDistingueLesNombresPairsEtImpairs() {

        assertAll(
            () -> assertTrue(calculatrice.estPair(4)),
            () -> assertFalse(calculatrice.estPair(7)),
            () -> assertTrue(calculatrice.estPair(0))
        );
    }

    @Test
    void diviserParZeroLanceUneException() {

        assertThrows(
            ArithmeticException.class,
            () -> calculatrice.diviser(10, 0)
        );
    }

    // Niveau 3

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    void estPremierRetourneVraiPourLesNombresPremiersConnus(int nombre) {

        assertTrue(calculatrice.estPremier(nombre));
    }

    @ParameterizedTest
    @CsvSource({
        "1, false",
        "4, false",
        "9, false",
        "17, true"
    })
    void estPremierGereLesCasLimites(int nombre, boolean attendu) {

        assertEquals(attendu, calculatrice.estPremier(nombre));
    }

    @Test
    void diviserAvecNombresNegatifs() {

        // Arrange
        int a = -10;
        int b = 2;

        // Act
        int resultat = calculatrice.diviser(a, b);

        // Assert
        assertEquals(-5, resultat);
    }
}

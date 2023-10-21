import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/*
 * Aquest exemple defineix un
 * model observer simple, sobre
 * tipus de dades primitius
 * 
 * També mira els canvis a l'arxiu
 * 'arxiu.txt' i els mostra
 * per pantalla quan es modifica
 * encara que siguin fets per una
 * eina externa
 */

public class Main {
    public static void main(String[] args) {
        PR450Producte p0 = new PR450Producte(0, "Llibre");
        PR450Producte p1 = new PR450Producte(1, "Boli");
        PR450Producte p2 = new PR450Producte(2, "Rotulador");
        PR450Producte p3 = new PR450Producte(3, "Carpeta");
        PR450Producte p4 = new PR450Producte(4, "Motxilla");
        System.out.println("WE NEED TO\n\nLEARN JAVA\n\nAS QUICKLY AS POSSIBLE");

        PR450Magatzem magatzem = new PR450Magatzem();
        PR450Entregues entregues = new PR450Entregues();    

        PropertyChangeListener lProduct0 = new PropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat el %s de %s a %s\n",
                        evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
            }
        };
        p0.addPropertyChangeListener("producteName", lProduct0);
        p1.addPropertyChangeListener("producteName", lProduct0);
        p0.addPropertyChangeListener("producteId", lProduct0);
        p1.addPropertyChangeListener("producteId", lProduct0);

        PropertyChangeListener lMagatzem0 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amb id %s al %s, capacitat: %s\n",
                        evt.getOldValue(), evt.getPropertyName(), evt.getNewValue());
            }
        };
        magatzem.addPropertyChangeListener("magatzemAdd", lMagatzem0);

        PropertyChangeListener lMagatzem1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha esborrat el producte amb id %s del %s, capacitat: %s\n",
                        evt.getOldValue(), evt.getPropertyName(), evt.getNewValue());

            }
        };
        magatzem.addPropertyChangeListener("magatzemRemove", lMagatzem1);

        

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");
        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        // entregues.removeProducte(2);
        // entregues.removeProducte(3);

        System.out.println(magatzem);
        System.out.println(entregues);

    }
}
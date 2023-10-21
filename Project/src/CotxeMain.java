import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
 * En aquest exmple fa servir el model Observer
 * es veu com afegir funcions que
 * es criden segons canvis de variables
 * en un objecte
 * Es poden definir diverses funcions (exemple gasolina)
 * a un mateix canvi de variable
 */

public class CotxeMain {
    public static void main(String[] args) {

        CotxeEvents cotxe = new CotxeEvents();

        PropertyChangeListener l0 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("L'estat s'ha canviat de %s cap a %s a través de la propietat '%s'\n",
                        evt.getOldValue(), evt.getNewValue(), evt.getPropertyName());
            }
        };
        cotxe.addPropertyChangeListener("estat", l0);

        PropertyChangeListener l1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("La gasolina s'ha canviat de %s cap a %s a través de la propietat '%s'\n",
                        evt.getOldValue(), evt.getNewValue(), evt.getPropertyName());
            }
        };
        cotxe.addPropertyChangeListener("gasolina", l1);

        PropertyChangeListener l2 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Gasolina segon event\n");
            }
        };
        cotxe.addPropertyChangeListener("gasolina", l2);

        System.out.println("1");
        cotxe.setEstat(CotxeEstats.ENDAVANT);
        System.out.println("2");
        cotxe.setEstat(CotxeEstats.EDARRERA);
        System.out.println("3");
        // Les següents accions ja no les pot fer perquè no té gasolina
        cotxe.setEstat(CotxeEstats.GIRDRETA);
        System.out.println("4");
        cotxe.setEstat(CotxeEstats.EDARRERA);
        System.out.println("5");
        cotxe.setEstat(CotxeEstats.ATURAT);
        System.out.println("6");
    }
}
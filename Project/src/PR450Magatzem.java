import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class PR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> magatzem = new ArrayList<>();
    private int capacitad = 10;

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    public ArrayList<PR450Producte> getMagatzem() {
        return this.magatzem;
    }

    public void setMagatzem(ArrayList<PR450Producte> productes) {
        this.magatzem = productes;
    }

    public int getCapacitad() {
        return this.capacitad;
    }

    public void setCapacitad(int capacitad) {
        this.capacitad = capacitad;
    }

    public void addProducte(PR450Producte newProducte) {
        ArrayList<PR450Producte> oldProducts = this.magatzem;
        ArrayList<PR450Producte> newProducts = oldProducts;
        newProducts.add(newProducte);
        if (getCapacitad() > 0){
            this.setCapacitad(this.capacitad-1);
            this.magatzem = newProducts;
            llistaObservers.firePropertyChange("magatzemAdd", newProducte.getId(), getCapacitad());
        }
    }

    public void removeProducte(int id) {
        Iterator<PR450Producte> iterator = magatzem.iterator();
        while (iterator.hasNext()) {
            PR450Producte p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                this.setCapacitad(this.capacitad+1);
                llistaObservers.firePropertyChange("magatzemRemove", id, getCapacitad());

            }
        }
    }
}

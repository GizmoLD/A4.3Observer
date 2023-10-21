import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class PR450Entregues {


    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes = new ArrayList<>();

    public void addPropertyChangeListener(String name, PropertyChangeListener listener){
        llistaObservers.addPropertyChangeListener(name,listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    public ArrayList<PR450Producte> getProductes() {
        return this.productes;
    }

    public void setProductes(ArrayList<PR450Producte> productes) {

        this.productes = productes;
    }

    public void addProduct(PR450Producte producte) {
        this.productes.add(producte);
    }

    public void removeProducte(int id) {
        Iterator<PR450Producte> iterator = productes.iterator();
        while (iterator.hasNext()) {
            PR450Producte p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                
            }
        }
    }
}
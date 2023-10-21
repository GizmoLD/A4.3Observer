import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PR450Producte{
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);

    private int id;
    private String nom;

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        llistaObservers.firePropertyChange("producteId", oldId, id);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String newName) {
        String oldName = this.nom;
        this.nom = newName;
        llistaObservers.firePropertyChange("producteName", oldName, newName);
    }

    @Override
    public String toString() {
        return  
            " "+ getId() + ": " + getNom();
    }
}

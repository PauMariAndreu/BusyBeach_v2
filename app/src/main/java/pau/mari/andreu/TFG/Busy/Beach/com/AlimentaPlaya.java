package pau.mari.andreu.TFG.Busy.Beach.com;

/**
 * Created by PAU on 06/04/2016.
 */
public class AlimentaPlaya {
    String nombre;
    String costa;
    String coches;
    String capacidad;
    String extra;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCosta() {
        return costa;
    }
    public void setCosta(String costa) {
        this.costa = costa;
    }
    public String getCoches() {
        return coches;
    }
    public void setCoches(String coches) {
        this.coches = coches;
    }
    public String getCapacidad() {
        return capacidad;
    }
    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "AlimentaPlaya [nombre=" + nombre + ", costa=" + costa
                + ", coches=" + coches + ", capacidad=" + capacidad + ", extra=" + extra + "]";
    }
}

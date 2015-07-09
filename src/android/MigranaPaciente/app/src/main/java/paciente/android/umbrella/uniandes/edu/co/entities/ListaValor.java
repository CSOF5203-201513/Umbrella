package paciente.android.umbrella.uniandes.edu.co.entities;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class ListaValor {
    private int id;
    private int idlista;
    private String valor;
    private String descripcion;

    public int getIdlista() {
        return idlista;
    }

    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString()
    {
        return valor;
    }

}

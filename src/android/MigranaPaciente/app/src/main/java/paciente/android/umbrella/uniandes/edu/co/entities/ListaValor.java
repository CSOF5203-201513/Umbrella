package paciente.android.umbrella.uniandes.edu.co.entities;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class ListaValor {
    private int id;
    private String valor;
    private String descripcion;

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

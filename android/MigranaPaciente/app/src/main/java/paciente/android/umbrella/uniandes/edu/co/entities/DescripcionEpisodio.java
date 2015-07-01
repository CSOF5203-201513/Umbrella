package paciente.android.umbrella.uniandes.edu.co.entities;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class DescripcionEpisodio {
    private int id;
    private int idEpisodioMigrana;
    private int idTipoDesencadenante;
    private String nombreTipoDesencadenante;
    private String descripcionDesencadenante;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEpisodioMigrana() {
        return idEpisodioMigrana;
    }

    public void setIdEpisodioMigrana(int idEpisodioMigrana) {
        this.idEpisodioMigrana = idEpisodioMigrana;
    }

    public int getIdTipoDesencadenante() {
        return idTipoDesencadenante;
    }

    public void setIdTipoDesencadenante(int idTipoDesencadenante) {
        this.idTipoDesencadenante = idTipoDesencadenante;
    }

    public String getNombreTipoDesencadenante() {
        return nombreTipoDesencadenante;
    }

    public void setNombreTipoDesencadenante(String nombreTipoDesencadenante) {
        this.nombreTipoDesencadenante = nombreTipoDesencadenante;
    }

    public String getDescripcionDesencadenante() {
        return descripcionDesencadenante;
    }

    public void setDescripcionDesencadenante(String descripcionDesencadenante) {
        this.descripcionDesencadenante = descripcionDesencadenante;
    }
}

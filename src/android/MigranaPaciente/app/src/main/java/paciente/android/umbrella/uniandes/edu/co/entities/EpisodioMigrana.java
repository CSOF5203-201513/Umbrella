package paciente.android.umbrella.uniandes.edu.co.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class EpisodioMigrana {
    private int id;
    private String fechaCreacion;
    private int idlocalizacionDolor;
    private String localizacionDolor;
    private int idIntensidad;
    private String intensidad;
    private int idPaciente;
    private String pacienteNumeroIdentificacion;
    private String pacienteNombre;
    private int idMedico;
    private String medicoNumeroIdentificacion;
    private String medicoNombre;
    private String urlAudio;
    private List<DescripcionEpisodio> desencadenantes;

    public EpisodioMigrana()
    {
        desencadenantes = new ArrayList<DescripcionEpisodio>();
    }

    public int getId() {
        return id;
    }

    public List<DescripcionEpisodio> getDesencadenantes() {
        return desencadenantes;
    }

    public void setDesencadenantes(List<DescripcionEpisodio> desencadenantes) {
        this.desencadenantes = desencadenantes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdlocalizacionDolor() {
        return idlocalizacionDolor;
    }

    public void setIdlocalizacionDolor(int idlocalizacionDolor) {
        this.idlocalizacionDolor = idlocalizacionDolor;
    }

    public String getLocalizacionDolor() {
        return localizacionDolor;
    }

    public void setLocalizacionDolor(String localizacionDolor) {
        this.localizacionDolor = localizacionDolor;
    }

    public int getIdIntensidad() {
        return idIntensidad;
    }

    public void setIdIntensidad(int idIntensidad) {
        this.idIntensidad = idIntensidad;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPacienteNumeroIdentificacion() {
        return pacienteNumeroIdentificacion;
    }

    public void setPacienteNumeroIdentificacion(String pacienteNumeroIdentificacion) {
        this.pacienteNumeroIdentificacion = pacienteNumeroIdentificacion;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getMedicoNumeroIdentificacion() {
        return medicoNumeroIdentificacion;
    }

    public void setMedicoNumeroIdentificacion(String medicoNumeroIdentificacion) {
        this.medicoNumeroIdentificacion = medicoNumeroIdentificacion;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    public String getUrlAudio() {
        return urlAudio;
    }

    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }

    @Override
    public String toString()
    {
        return " ID:"+this.getId() +"\n Dolor:" + this.getLocalizacionDolor()+ "\n Medico:" + this.getMedicoNombre();
    }
}

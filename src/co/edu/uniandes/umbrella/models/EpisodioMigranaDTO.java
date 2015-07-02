/**
 * 
 */
package co.edu.uniandes.umbrella.models;

/**
 * @author erica.prado
 *
 */
public class EpisodioMigranaDTO {

	
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

    private int estado;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the idlocalizacionDolor
     */
    public int getIdlocalizacionDolor() {
        return idlocalizacionDolor;
    }

    /**
     * @param idlocalizacionDolor the idlocalizacionDolor to set
     */
    public void setIdlocalizacionDolor(int idlocalizacionDolor) {
        this.idlocalizacionDolor = idlocalizacionDolor;
    }

    /**
     * @return the localizacionDolor
     */
    public String getLocalizacionDolor() {
        return localizacionDolor;
    }

    /**
     * @param localizacionDolor the localizacionDolor to set
     */
    public void setLocalizacionDolor(String localizacionDolor) {
        this.localizacionDolor = localizacionDolor;
    }

    /**
     * @return the idIntensidad
     */
    public int getIdIntensidad() {
        return idIntensidad;
    }

    /**
     * @param idIntensidad the idIntensidad to set
     */
    public void setIdIntensidad(int idIntensidad) {
        this.idIntensidad = idIntensidad;
    }

    /**
     * @return the intensidad
     */
    public String getIntensidad() {
        return intensidad;
    }

    /**
     * @param intensidad the intensidad to set
     */
    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the pacienteNumeroIdentificacion
     */
    public String getPacienteNumeroIdentificacion() {
        return pacienteNumeroIdentificacion;
    }

    /**
     * @param pacienteNumeroIdentificacion the pacienteNumeroIdentificacion to
     * set
     */
    public void setPacienteNumeroIdentificacion(String pacienteNumeroIdentificacion) {
        this.pacienteNumeroIdentificacion = pacienteNumeroIdentificacion;
    }

    /**
     * @return the pacienteNombre
     */
    public String getPacienteNombre() {
        return pacienteNombre;
    }

    /**
     * @param pacienteNombre the pacienteNombre to set
     */
    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    /**
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the medicoNumeroIdentificacion
     */
    public String getMedicoNumeroIdentificacion() {
        return medicoNumeroIdentificacion;
    }

    /**
     * @param medicoNumeroIdentificacion the medicoNumeroIdentificacion to set
     */
    public void setMedicoNumeroIdentificacion(String medicoNumeroIdentificacion) {
        this.medicoNumeroIdentificacion = medicoNumeroIdentificacion;
    }

    /**
     * @return the medicoNombre
     */
    public String getMedicoNombre() {
        return medicoNombre;
    }

    /**
     * @param medicoNombre the medicoNombre to set
     */
    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    /**
     * @return the urlAudio
     */
    public String getUrlAudio() {
        return urlAudio;
    }

    /**
     * @param urlAudio the urlAudio to set
     */
    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Constructor
     */
    public EpisodioMigranaDTO() {

    }


}

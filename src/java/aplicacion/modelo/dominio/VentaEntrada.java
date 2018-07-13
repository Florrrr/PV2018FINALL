package aplicacion.modelo.dominio;
// Generated 14/06/2018 11:42:48 by Hibernate Tools 4.3.1



/**
 * VentaEntrada generated by hbm2java
 */
public class VentaEntrada  implements java.io.Serializable {


     private Integer venCodigo;
     private Perfil perfiles;
     private String venPrecio;
     private String venDescripcion;
     private boolean venEstado;
     private ButacaCartelera butacasCartelera;

    public VentaEntrada() {
    }

    public VentaEntrada(Perfil perfiles, String venPrecio, String venDescripcion, boolean venEstado, ButacaCartelera butacasCartelera) {
       this.perfiles = perfiles;
       this.venPrecio = venPrecio;
       this.venDescripcion = venDescripcion;
       this.venEstado = venEstado;
       this.butacasCartelera = butacasCartelera;
    }
   
    public Integer getVenCodigo() {
        return this.venCodigo;
    }
    
    public void setVenCodigo(Integer venCodigo) {
        this.venCodigo = venCodigo;
    }
    public Perfil getPerfiles() {
        return this.perfiles;
    }
    
    public void setPerfiles(Perfil perfiles) {
        this.perfiles = perfiles;
    }
    public String getVenPrecio() {
        return this.venPrecio;
    }
    
    public void setVenPrecio(String venPrecio) {
        this.venPrecio = venPrecio;
    }
    public String getVenDescripcion() {
        return this.venDescripcion;
    }
    
    public void setVenDescripcion(String venDescripcion) {
        this.venDescripcion = venDescripcion;
    }
    public boolean isVenEstado() {
        return this.venEstado;
    }
    
    public void setVenEstado(boolean venEstado) {
        this.venEstado = venEstado;
    }

    /**
     * @return the butacasCartelera
     */
    public ButacaCartelera getButacasCartelera() {
        return butacasCartelera;
    }

    /**
     * @param butacasCartelera the butacasCartelera to set
     */
    public void setButacasCartelera(ButacaCartelera butacasCartelera) {
        this.butacasCartelera = butacasCartelera;
    }




}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ButacaBean;
import aplicacion.controlador.beans.CarteleraBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.SalaBean;
import aplicacion.controlador.beans.VentaEntradaBean;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Sala;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.modelo.dominio.VentaEntrada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class VentaEntradaFormBean implements Serializable{
    @ManagedProperty(value="#{ventaEntradaBean}")
    private VentaEntradaBean ventaEntradasBean;
    @ManagedProperty(value="#{carteleraBean}")
    private CarteleraBean carteleraBean;
    @ManagedProperty(value="#{perfilBean}")
    private PerfilBean perfilBean;
    @ManagedProperty(value="#{butacaBean}")
    private ButacaBean butacaBean;
    @ManagedProperty(value="#{salaBean}")
    private SalaBean salaBean;
    
    private String nombreP;
    private String horario;
    private String precio;
    private String idButaca;
    private String imagenBut;
    private Date fecha;
    private List<Cartelera> carteleras;
    private List<Pelicula> peliculas;
    private List<Perfil> perfiles;
    private List<Butaca> butacaA;
    private List<Butaca> butacaB;
    private Cartelera unaCartelera;
    private Pelicula unaPelicula;
    private Sala salaA;
    private Sala salaB;
    private boolean act1;
    private boolean act2;
    private boolean act3;
    private boolean act4;
    private String resumenReserva;
    private double pp;

    /**
     * Creates a new instance of VentaEntradaFormBean
     */
    public VentaEntradaFormBean() {
        carteleraBean=new CarteleraBean();
        perfilBean=new PerfilBean();
        ventaEntradasBean=new VentaEntradaBean();
        butacaBean= new ButacaBean();
        salaBean= new SalaBean();
        imagenBut="/resources/images/butaca.bmp";
        act1=false;
        act2=true;
        act3=true;
        act4=false;
        listarButacas();
    }
    
    private void listarButacas() {
        setUnaCartelera(getCarteleraBean().listar().get(0));
        setSalaA(getSalaBean().validar(1));
        setSalaB(getSalaBean().validar(2));
        setButacaA(getButacaBean().listar(getSalaA()));
        setButacaB(getButacaBean().listar(getSalaB()));
        setPrecio(Double.toString(getPp()));
    }
    
    public void establecerPelicula(Cartelera pel){
        setUnaCartelera(pel);
        setUnaPelicula(pel.getPeliculas());
        setFecha(pel.getCarFecha());
        setHorario(pel.getCarHorario());
        setAct1(true);
        setAct2(false);
    }
    
    
    public void cambiarPrecio(){
        ArrayList<Cartelera> aux=new ArrayList();
        for(int i=0;i<getCarteleras().size();i++){
            if(getCarteleras().get(i).getCarHorario().equals(getHorario())){
                aux.add(getCarteleras().get(i));
            }
        }
        setCarteleras((List)aux);
        setAct2(true);
        setAct3(false);
    }
    
    public int definirSala(){
        int idSala=0;
        if(getUnaCartelera().getSalas().getSalCodigo()==1){
            idSala=1;
        }
        else{
            idSala=4;
        }
        return idSala;
    }
    
    public void seleccionarButaca(){
        RequestContext.getCurrentInstance().execute("PF('seleccionButaca').show()");
        RequestContext.getCurrentInstance().update("frmSeleccionButaca");
    }
    
    public void reservarButaca (String idButaca){
        setImagenBut("/resources/images/check.png");
        setIdButaca(idButaca);
    }
    
    public void reservarEntrada(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("u");
        setPerfiles(getPerfilBean().listarPerfiles());
        Perfil usuarioPerfil= new Perfil();
        for(Perfil p:getPerfiles()){
            if(p.getUsuarios().getUsuNombreUsuario().equals(usuario.getUsuNombreUsuario())){
                usuarioPerfil=p;
            }
        }
        ButacaCartelera unaButacaCartelera=new ButacaCartelera(getIdButaca(),false,true, getUnaCartelera());
        VentaEntrada unaVenta=new VentaEntrada(usuarioPerfil, getPrecio(),"Venta Credito",true,unaButacaCartelera);
        setResumenReserva("Butaca: "+getIdButaca()+". Precio: "+getPrecio()+". Fecha: "+getUnaCartelera().getCarFecha().toString());
        getVentaEntradasBean().agregar(unaVenta);
    }
    
    public void comprarEntrada(){
        setImagenBut("/resources/images/check.png");
    }
    
    

    /**
     * @return the ventaEntradasBean
     */
    public VentaEntradaBean getVentaEntradasBean() {
        return ventaEntradasBean;
    }

    /**
     * @param ventaEntradasBean the ventaEntradasBean to set
     */
    public void setVentaEntradasBean(VentaEntradaBean ventaEntradasBean) {
        this.ventaEntradasBean = ventaEntradasBean;
    }

    /**
     * @return the carteleraBean
     */
    public CarteleraBean getCarteleraBean() {
        return carteleraBean;
    }

    /**
     * @param carteleraBean the carteleraBean to set
     */
    public void setCarteleraBean(CarteleraBean carteleraBean) {
        this.carteleraBean = carteleraBean;
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the butacaBean
     */
    public ButacaBean getButacaBean() {
        return butacaBean;
    }

    /**
     * @param butacaBean the butacaBean to set
     */
    public void setButacaBean(ButacaBean butacaBean) {
        this.butacaBean = butacaBean;
    }

    /**
     * @return the salaBean
     */
    public SalaBean getSalaBean() {
        return salaBean;
    }

    /**
     * @param salaBean the salaBean to set
     */
    public void setSalaBean(SalaBean salaBean) {
        this.salaBean = salaBean;
    }

    /**
     * @return the nombreP
     */
    public String getNombreP() {
        return nombreP;
    }

    /**
     * @param nombreP the nombreP to set
     */
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the idButaca
     */
    public String getIdButaca() {
        return idButaca;
    }

    /**
     * @param idButaca the idButaca to set
     */
    public void setIdButaca(String idButaca) {
        this.idButaca = idButaca;
    }

    /**
     * @return the imagenBut
     */
    public String getImagenBut() {
        return imagenBut;
    }

    /**
     * @param imagenBut the imagenBut to set
     */
    public void setImagenBut(String imagenBut) {
        this.imagenBut = imagenBut;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the carteleras
     */
    public List<Cartelera> getCarteleras() {
        return carteleras;
    }

    /**
     * @param carteleras the carteleras to set
     */
    public void setCarteleras(List<Cartelera> carteleras) {
        this.carteleras = carteleras;
    }

    /**
     * @return the peliculas
     */
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * @param peliculas the peliculas to set
     */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * @return the perfiles
     */
    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the butacaA
     */
    public List<Butaca> getButacaA() {
        return butacaA;
    }

    /**
     * @param butacaA the butacaA to set
     */
    public void setButacaA(List<Butaca> butacaA) {
        this.butacaA = butacaA;
    }

    /**
     * @return the butacaB
     */
    public List<Butaca> getButacaB() {
        return butacaB;
    }

    /**
     * @param butacaB the butacaB to set
     */
    public void setButacaB(List<Butaca> butacaB) {
        this.butacaB = butacaB;
    }

    /**
     * @return the unaCartelera
     */
    public Cartelera getUnaCartelera() {
        return unaCartelera;
    }

    /**
     * @param unaCartelera the unaCartelera to set
     */
    public void setUnaCartelera(Cartelera unaCartelera) {
        this.unaCartelera = unaCartelera;
    }

    /**
     * @return the unaPelicula
     */
    public Pelicula getUnaPelicula() {
        return unaPelicula;
    }

    /**
     * @param unaPelicula the unaPelicula to set
     */
    public void setUnaPelicula(Pelicula unaPelicula) {
        this.unaPelicula = unaPelicula;
    }

    /**
     * @return the salaA
     */
    public Sala getSalaA() {
        return salaA;
    }

    /**
     * @param salaA the salaA to set
     */
    public void setSalaA(Sala salaA) {
        this.salaA = salaA;
    }

    /**
     * @return the salaB
     */
    public Sala getSalaB() {
        return salaB;
    }

    /**
     * @param salaB the salaB to set
     */
    public void setSalaB(Sala salaB) {
        this.salaB = salaB;
    }

    /**
     * @return the act1
     */
    public boolean isAct1() {
        return act1;
    }

    /**
     * @param act1 the act1 to set
     */
    public void setAct1(boolean act1) {
        this.act1 = act1;
    }

    /**
     * @return the act2
     */
    public boolean isAct2() {
        return act2;
    }

    /**
     * @param act2 the act2 to set
     */
    public void setAct2(boolean act2) {
        this.act2 = act2;
    }

    /**
     * @return the act3
     */
    public boolean isAct3() {
        return act3;
    }

    /**
     * @param act3 the act3 to set
     */
    public void setAct3(boolean act3) {
        this.act3 = act3;
    }

    /**
     * @return the act4
     */
    public boolean isAct4() {
        return act4;
    }

    /**
     * @param act4 the act4 to set
     */
    public void setAct4(boolean act4) {
        this.act4 = act4;
    }

    /**
     * @return the resumenReserva
     */
    public String getResumenReserva() {
        return resumenReserva;
    }

    /**
     * @param resumenReserva the resumenReserva to set
     */
    public void setResumenReserva(String resumenReserva) {
        this.resumenReserva = resumenReserva;
    }

    /**
     * @return the pp
     */
    public double getPp() {
        return pp;
    }

    /**
     * @param pp the pp to set
     */
    public void setPp(double pp) {
        this.pp = pp;
    }

    
    
}

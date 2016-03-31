/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.LoginBiz;
import DTO.LoginDTO;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("DiagnosTyCsPU");
    
    private Long idPersona;
    private String contrasena;
    private String nombrePersona;
    
    public static String mensajeEmergenteTipo = "SEVERITY_INFO";
    public static String mensajeEmergenteTitulo = "Bienvenido";
    public static String mensajeEmergenteContenido = ""; 
    
    public static Long idPersonaLogueada;

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        LoginBean.emf = emf;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public static String getMensajeEmergenteTipo() {
        return mensajeEmergenteTipo;
    }

    public static void setMensajeEmergenteTipo(String mensajeEmergenteTipo) {
        LoginBean.mensajeEmergenteTipo = mensajeEmergenteTipo;
    }

    public static String getMensajeEmergenteTitulo() {
        return mensajeEmergenteTitulo;
    }

    public static void setMensajeEmergenteTitulo(String mensajeEmergenteTitulo) {
        LoginBean.mensajeEmergenteTitulo = mensajeEmergenteTitulo;
    }

    public static String getMensajeEmergenteContenido() {
        return mensajeEmergenteContenido;
    }

    public static void setMensajeEmergenteContenido(String mensajeEmergenteContenido) {
        LoginBean.mensajeEmergenteContenido = mensajeEmergenteContenido;
    }

    public static Long getIdPersonaLogueada() {
        return idPersonaLogueada;
    }

    public static void setIdPersonaLogueada(Long idPersonaLogueada) {
        LoginBean.idPersonaLogueada = idPersonaLogueada;
    }
    
    public String login(){
        
        LoginDTO loginDTO = new LoginDTO();       
        loginDTO.setIdPersona(idPersona);
        loginDTO.setContrasena(contrasena);
        
        LoginBiz loginBiz = new LoginBiz();
        loginDTO = loginBiz.login(loginDTO);
        
        if(loginDTO.getMensaje().equals("error")){
            LoginBean.mensajeEmergenteTipo = "SEVERITY_ERROR";
            LoginBean.mensajeEmergenteContenido = "Inicio de Sesión Fallido";
            LoginBean.mensajeEmergenteTitulo = "Usuario o contraseña incorrectos.";
            return "inicio.xhtml";                    
        }else{
            LoginBean.setMensajeEmergenteTipo("SEVERITY_INFO");
            LoginBean.setMensajeEmergenteTitulo("Bienvenido");
            LoginBean.setMensajeEmergenteContenido("DiagnosTyCs para " 
                + loginDTO.getNombrePersona());
            nombrePersona = loginDTO.getNombrePersona();
            idPersona = loginDTO.getIdPersona();
            idPersonaLogueada = loginDTO.getIdPersona();
            return loginDTO.getMensaje();
        }

    }
    
    public String logout(){
        
        LoginBean.mensajeEmergenteTipo = "SEVERITY_INFO";
        LoginBean.mensajeEmergenteContenido = "Sesión finalizada";
        LoginBean.mensajeEmergenteTitulo = "Esperamos que vuelva pronto";
        nombrePersona = null;
        contrasena = null;
        idPersona = null;
        idPersonaLogueada = null;
        
        return "inicio.xhtml";
    }
    
    public void addMessage() {
                
        FacesMessage message = new FacesMessage();
        switch (mensajeEmergenteTipo) {
            case "SEVERITY_INFO":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajeEmergenteTitulo, mensajeEmergenteContenido);
                break;
            case "SEVERITY_ERROR":
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajeEmergenteTitulo, mensajeEmergenteContenido);
                break;
            case "SEVERITY_FATAL":
                message = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensajeEmergenteTitulo, mensajeEmergenteContenido);
                break;
            case "SEVERITY_WARN":
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensajeEmergenteTitulo, mensajeEmergenteContenido);
                break;
            default:
                break;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }
    
    @PreDestroy
    public void destruct()
    {
        emf.close();
    }
}

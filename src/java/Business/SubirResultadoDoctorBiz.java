/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ExamenLaboratorioDAO;
import DAO.ImagenDiagnosticaDAO;
import DTO.CitaDTO;
import Entidades.Cita;
import Entidades.Doctor;
import Entidades.ImagenDiagnostica;
import Entidades.Laboratorio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.imageio.stream.FileImageOutputStream;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Jaime
 */
public class SubirResultadoDoctorBiz {

   public List<CitaDTO> parseCita_CitaDTO(Doctor doctor){
    
       List<CitaDTO> citasDTO = new ArrayList<>();
       CitaDTO citaDTO;
              
       for(Cita c : doctor.getCitaCollection()){
           
           citaDTO = new CitaDTO();
           citaDTO.setCitaID(c.getCitaID());
           citaDTO.setNombreMedico(c.getMedicomedicoID().getPersonapersonaID().getNombre());
           citaDTO.setFecha(c.getFecha());
           citaDTO.setValor(c.getValor());
           citaDTO.setCita(c);
           citaDTO.setIdPaciente(c.getPacientepacienteID().getNumDocumento());
           citaDTO.setNombrePaciente(c.getPacientepacienteID().getNombre());
           citasDTO.add(citaDTO);
           
       }    
       
       return citasDTO;
       
   }
   
   public List<Laboratorio> actualizarExamenesLaboratorio(List<Laboratorio> examenesLaboratorio){
       
       ExamenLaboratorioDAO examenLaboratorioDAO = new ExamenLaboratorioDAO();
       
       for(Laboratorio laboratorio: examenesLaboratorio){
           laboratorio = examenLaboratorioDAO.updateExamenLaboratorio(laboratorio);
       }
       
       return examenesLaboratorio;
    }
   
    public List<ImagenDiagnostica> actualizarImagenDiagnostica(UploadedFile archivoImagen, 
            List<ImagenDiagnostica> imagenesDiagnosticas) throws IOException {
        
        ImagenDiagnosticaDAO imagenDiagnosticaDAO = new ImagenDiagnosticaDAO();
        
        for(ImagenDiagnostica imagen: imagenesDiagnosticas){
            imagen.setRutaImagen(almacenarArchivoImagen(archivoImagen, imagen.getImagenDiagnosticaID()));
            imagen = imagenDiagnosticaDAO.updateImagenDiagnostica(imagen);
        }
        
        return imagenesDiagnosticas;
        
    }
   
    public String almacenarArchivoImagen(UploadedFile imagen, Long imagenID) throws IOException{
       
        byte[] datos;
        String rutaImagen;
       
        datos = IOUtils.toByteArray(imagen.getInputstream());        
        rutaImagen = "C:" + File.separator + "Imagenes" + File.separator + imagenID.toString() + ".png";
        FileImageOutputStream outputStream = null;
        try {
            outputStream = new FileImageOutputStream
                    (new File(rutaImagen));
            outputStream.write(datos, 0, datos.length);
        } catch (IOException e) {
            throw new FacesException("Error guardando la foto.", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
        
        return rutaImagen;
       
   }
   
}

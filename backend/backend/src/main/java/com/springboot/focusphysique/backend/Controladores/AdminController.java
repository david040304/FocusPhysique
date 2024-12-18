package com.springboot.focusphysique.backend.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Entidades.Administrador;
import com.springboot.focusphysique.backend.Servicio.IAdminServicio;



@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    //Configurar los mwtodos

    @Autowired
    private IAdminServicio servicio;

    //Configurar metodo para insertar
    @PostMapping
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador entity){
        Administrador nuevAdmin = servicio.crearAdministrador(entity);
        return new ResponseEntity<>(nuevAdmin, (HttpStatus.CREATED));
    }

    //configurar metodo para obtnerAdmin
    @GetMapping
    public ResponseEntity<Iterable<Administrador>> getAllAdministrador(){
        return ResponseEntity.ok().body(servicio.obtenerAdmin());
    }
    //configurar metodo obtenerAdminPorId
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdminPorId(@PathVariable Integer id){
        Optional<Administrador> opAdmin = servicio.obtenerAdminPorId(id);
        if(opAdmin.isPresent()){
            return ResponseEntity.ok().body(opAdmin.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAdmin(@PathVariable(name = "id") Integer id) {
        try {
            servicio.eliminarAdmin(id);
            return ResponseEntity.ok("Administrador eliminado correctamente.");
        } catch (RuntimeException e) {
            // Manejo de excepciones para cuando no se pueda eliminar el usuario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar el Administrador: " + e.getMessage());
        }
    }

    //configurar metodo actualizarAdmin
    @PutMapping("/{id}")
    public ResponseEntity<Administrador> actualizarAdmin(@PathVariable (name = "id") Integer id, 
    @RequestBody Administrador AdminOld){
        Optional<Administrador> admin = servicio.obtenerAdminPorId(id);
        if(admin.isPresent()){
            Administrador AdminNew = admin.get();
            AdminNew.setP_Nombre(AdminOld.getP_Nombre());
            AdminNew.setS_Nombre(AdminOld.getS_Apellido());
            AdminNew.setP_Apellido(AdminOld.getP_Apellido());
            AdminNew.setS_Apellido(AdminOld.getS_Apellido());
            AdminNew.setEdad(AdminOld.getEdad());
            AdminNew.setTelefono(AdminOld.getTelefono());

        }
        return ResponseEntity.notFound().build();
    }


}

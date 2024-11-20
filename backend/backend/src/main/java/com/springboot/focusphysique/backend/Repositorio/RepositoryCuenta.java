package com.springboot.focusphysique.backend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface RepositoryCuenta  extends JpaRepository<Cuenta,Integer>{
    
}

    package com.example.demo.repositorio;

    import org.springframework.data.repository.CrudRepository;
    import com.example.demo.Entidad.Producto;

    import java.util.List;

    public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

        List<Producto> findByNombreContaining(String nombre);
    }


package futchamp.utilities;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * Esta interface generica servira para declarar los metodos basicos en comun de
 * todas las entidades para poder realizar CRUD a la BBDD.
 * <p>
 * Se usaran dentro de los metodos que estan en los services y llamados por los controladores
 *
 * @param <E> Class Entity
 */
public interface UGService<E> {
	
    /**
     * Este metodo agrega un elemento o registro a la lista(BBDD)
     *
     * @param element Sera el objeto de tipo entidad
     * @return Sera el objeto a guardar
     */
    ResponseEntity<E> addElementListUG(E element);

    /**
     * Este metodo mostrara todos los elementos o registros disponibles en la base de datos
     *
     * @return Una lista de elementos de tipo modelo
     */
    ResponseEntity<List<E>> getAllElementListUG();

    /**
     * Este metodo actualizara un registro de la base de datos
     *
     * @param element Sera el objeto de tipo entidad a actualizar
     * @return sera el objeto de tipo entidad actualizado.
     */
    ResponseEntity<E> updateElementListUG(E element);

    /**
     * Este metodo eliminara un elemento o registro de la base de datos
     *
     * @param idElement sera el numero identificador de tipo Long para realizar la busqueda y eliminar de la BBDD
     * @return sera el elemento o registro eliminado
     */
    ResponseEntity<?> deleteElementListUG(Long idElement);

}

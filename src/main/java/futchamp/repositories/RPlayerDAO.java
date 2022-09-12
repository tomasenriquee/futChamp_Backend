package futchamp.repositories;

import static futchamp.literals.RKeysDAO.DAO_PLAYER;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import futchamp.entities.Player;

@Repository(DAO_PLAYER)
public interface RPlayerDAO extends JpaRepository<Player, Serializable> {

	/**
	 * Verifica que exista un jugador por medio de su dni
	 *
	 * @param dni Sera el dato alfanumerico de tipo unico.
	 * @return Sera el dato de tipo boleano True si existe
	 */
	boolean existsPlayerByDni(String dni);

	/**
	 * Verifica que exista un jugador por medio de su email
	 *
	 * @param email Sera el dato alfanumerico de tipo unico.
	 * @return Sera el dato de tipo boleano True si existe
	 */
	boolean existsPlayerByEmail(String email);

}

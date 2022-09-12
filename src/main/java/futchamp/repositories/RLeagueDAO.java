package futchamp.repositories;

import static futchamp.literals.RKeysDAO.DAO_LEAGUE;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import futchamp.entities.League;

@Repository(DAO_LEAGUE)
public interface RLeagueDAO extends JpaRepository<League, Serializable> {

	/**
	 * Verifica si existe una League por medio de su nombre
	 *
	 * @param name Sera el nombre de la League que es un dato de tipo unico.
	 * @return Devuelve True si existe la league
	 */
	boolean existsLeagueByName(String name);

	/**
	 * Busca una League por medio de su nombre.
	 *
	 * @param name Sera el nombre de la League que es un dato de tipo unico.
	 * @return Sera un objeto de tipo League
	 */
	League findLeagueByName(String name);

}

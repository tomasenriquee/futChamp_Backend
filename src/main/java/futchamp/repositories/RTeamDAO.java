package futchamp.repositories;

import static futchamp.literals.RKeysDAO.DAO_TEAM;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import futchamp.entities.Team;

@Repository(DAO_TEAM)
public interface RTeamDAO extends JpaRepository<Team, Serializable> {

	/**
	 * Busca un equipo por su nombre que es un dato de tipo unico.
	 *
	 * @param name Sera el nombre del equipo.
	 * @return Sera un objeto de tipo Equipo (Team)
	 */
	Team findTeamByName(String name);

	/**
	 * Verifica si existe un equipo por medio de su nombre
	 *
	 * @param name Sera el nombre del equipo que es un dato de tipo unico.
	 * @return Devuelve True si existe
	 */
	boolean existsTeamByName(String name);

}

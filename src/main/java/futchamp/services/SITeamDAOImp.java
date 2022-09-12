package futchamp.services;

import static futchamp.literals.Qualifiers.SER_TEAM;
import static futchamp.literals.RKeysDAO.DAO_LEAGUE;
import static futchamp.literals.RKeysDAO.DAO_TEAM;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import futchamp.entities.League;
import futchamp.entities.Team;
import futchamp.repositories.RLeagueDAO;
import futchamp.repositories.RTeamDAO;
import futchamp.servicesSI.SITeamDAO;
import futchamp.utilities.UGService;

@Service(SER_TEAM)
public class SITeamDAOImp implements SITeamDAO, UGService<Team> {

	/** Log para mensajes por consola */
	private static final Logger logTeam = LoggerFactory.getLogger(SITeamDAOImp.class);

	/** Inyección para realizar CRUD a la BBDD de Team */
	@Autowired
	@Qualifier(DAO_TEAM)
	private RTeamDAO teamDAO;
	
	/** Inyección para realizar CRUD a la BBDD de LEAGUE */
	@Autowired
	@Qualifier(DAO_LEAGUE)
	private RLeagueDAO leagueDao;
	
	

	@Override
	public ResponseEntity<Team> addElementListUG(Team element) {		
		
        try {
            if (leagueDao.existsLeagueByName(element.getLeague().getName())) {
                League league = leagueDao.findLeagueByName(element.getLeague().getName());
                element.setLeague(league);
                teamDAO.save(element);
                logTeam.info("Equipo creado y guardado.");
                return ResponseEntity.status(HttpStatus.CREATED).body(element);
            } else {
            	logTeam.info("El nombre de la league no existe.");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El nombre de la league no existe.");
            }
        } catch (Exception e) {
        	logTeam.info("Error al crear equipo: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al crear equipo: " + e.getMessage());
        }
	}

	@Override
	public ResponseEntity<List<Team>> getAllElementListUG() {
		try {
			List<Team> teamModelList = teamDAO.findAll();
			if (teamModelList.isEmpty()) {
				logTeam.info("Lista de Teams Vacia.");
			} else {
				logTeam.info("Lista de Teams encontrada.");
			}
			return ResponseEntity.status(HttpStatus.OK).body(teamModelList);
		} catch (Exception e) {
			logTeam.info("Error al buscar la lista de equipos: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al buscar la lista de equipos: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Team> updateElementListUG(Team element) {
		if (teamDAO.existsById(element.getId())) {
			logTeam.info("Equipo encontrado.");
			if (leagueDao.existsById(element.getLeague().getId())) {
				logTeam.info("League de equipo encontrada.");
				try {
					Team team = teamDAO.findById(element.getId()).get();
					team.setName(element.getName());
					team.setCategory(element.getCategory());
					team.setPicture(element.getPicture());
					League league = leagueDao.findById(element.getLeague().getId()).get();
					team.setLeague(league); // Se actualiza League del equipo
					teamDAO.save(team);
					logTeam.info("Equipo actualizado.");
					return ResponseEntity.status(HttpStatus.OK).body(team);
				} catch (Exception e) {
					logTeam.info("CATCH: Error al actualizar el equipo: " + e.getMessage());
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CATCH: Error al actualizar el equipo: " + e.getMessage());
				}
			} else {
				logTeam.info("ELSE: No existe la league del equipo a actualizar");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ELSE: No existe la league del equipo a actualizar");
			}
		} else {
			logTeam.info("ELSE: No existe el equipo a actualizar.");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ELSE: No existe el equipo a actualizar.");
		}
	}

	@Override
	public ResponseEntity<?> deleteElementListUG(Long idElement) {
        try {
            if (teamDAO.existsById(idElement)) {
                Team team = teamDAO.findById(idElement).get();
                teamDAO.delete(team);
                logTeam.info("Equipo encontrado y elimindo.");
                return ResponseEntity.status(HttpStatus.OK).body(team);
            } else {
            	logTeam.info("El equipo a eliminar no existe.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El equipo a eliminar no existe.");
            }
        } catch (Exception e) {
        	logTeam.info("Error al eleiminar el equipo: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eleiminar el equipo: " + e.getMessage());
        }
	}

}

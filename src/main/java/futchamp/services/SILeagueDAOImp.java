package futchamp.services;

import static futchamp.literals.Qualifiers.SER_LEAGUE;
import static futchamp.literals.RKeysDAO.DAO_LEAGUE;

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
import futchamp.repositories.RLeagueDAO;
import futchamp.servicesSI.SILeagueDAO;
import futchamp.utilities.UGService;

@Service(SER_LEAGUE)
public class SILeagueDAOImp implements SILeagueDAO, UGService<League> {

	/** Log para mensajes por consola */
	private static final Logger logLeague = LoggerFactory.getLogger(SILeagueDAOImp.class);

	/** Inyección para realizar CRUD a la BBDD de LEAGUE */
	@Autowired
	@Qualifier(DAO_LEAGUE)
	private RLeagueDAO leagueDao;

	@Override
	public ResponseEntity<League> addElementListUG(League element) {
		try {
			leagueDao.save(element);
			logLeague.info("League creado y guardado.");
			return ResponseEntity.status(HttpStatus.CREATED).body(element);
		} catch (Exception e) {
			logLeague.info("No se pudo crear la league: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.FOUND, "No se puedo crear la league: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<List<League>> getAllElementListUG() {
		try {
			List<League> leagueModelList = leagueDao.findAll();
			if (leagueModelList.isEmpty()) {
				logLeague.info("Lista de leagues vacia.");
			} else {
				logLeague.info("Lista de leagues encontrada.");
			}
			return ResponseEntity.status(HttpStatus.OK).body(leagueModelList);
		} catch (Exception e) {
			logLeague.info("Error al buscar la lista de leagues: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al buscar la lista de leagues: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<League> updateElementListUG(League element) {
        try {
            if (leagueDao.existsById(element.getId())) {
                League league = leagueDao.findById(element.getId()).get();
                league.setName(element.getName());
                league.setPicture(element.getPicture());
                leagueDao.save(league);
                logLeague.info("League encontrada y actualizada.");
                return ResponseEntity.status(HttpStatus.OK).body(league);
            } else {
            	logLeague.info("No existe la League a actualizar.");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la League a actualizar.");
            }
        } catch (Exception e) {
        	logLeague.info("Error al actualizar la League: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar la League: " + e.getMessage());
        }
	}

	@Override
	public ResponseEntity<?> deleteElementListUG(Long idElement) {
		try {
			if (leagueDao.existsById(idElement)) {
				League league = leagueDao.findById(idElement).get();
				leagueDao.delete(league);
				logLeague.info("League encontrada y eliminada.");
				return ResponseEntity.status(HttpStatus.OK).body(league);
			} else {
				logLeague.info("La league a eliminar no existe.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La league a eliminar no existe.");
			}
		} catch (Exception e) {
			logLeague.info("Error al eliminar la league: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar la league: " + e.getMessage());
		}
	}

}

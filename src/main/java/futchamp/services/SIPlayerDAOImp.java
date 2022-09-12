package futchamp.services;

import static futchamp.literals.Qualifiers.SER_PLAYER;
import static futchamp.literals.RKeysDAO.DAO_PLAYER;
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

import futchamp.entities.Player;
import futchamp.entities.Team;
import futchamp.repositories.RPlayerDAO;
import futchamp.repositories.RTeamDAO;
import futchamp.servicesSI.SIPlayerDAO;
import futchamp.utilities.UGService;

@Service(SER_PLAYER)
public class SIPlayerDAOImp implements UGService<Player>, SIPlayerDAO {

	/** Log para mensajes por consola */
	private static final Logger logPlayer = LoggerFactory.getLogger(SIPlayerDAOImp.class);

	/** Inyección para realizar CRUD a la BBDD de LEAGUE */
	@Autowired
	@Qualifier(DAO_PLAYER)
	private RPlayerDAO playerDAO;

	@Autowired
	@Qualifier(DAO_TEAM)
	private RTeamDAO teamDAO;

	@Override
	public ResponseEntity<Player> addElementListUG(Player element) {
		try {
			if (playerDAO.existsPlayerByDni(element.getDni()) || playerDAO.existsPlayerByEmail(element.getEmail())) {
				logPlayer.info("IF: El jugador a crear ya existe.");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IF: El jugador a crear ya existe.");
			} else {
				logPlayer.info("No existe el jugador a crear.");
				if (teamDAO.existsTeamByName(element.getTeam().getName())) {
					logPlayer.info("El equipo del jugador a crear si existe.");
					Team team = teamDAO.findTeamByName(element.getTeam().getName());
					element.setTeam(team);
					playerDAO.save(element);
					logPlayer.info("Jugador creado y guardado.");
					return ResponseEntity.status(HttpStatus.CREATED).body(element);
				} else {
					logPlayer.info("ELSE: El equipo del jugador a crear no existe.");
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ELSE: El equipo del jugador a crear no existe.");
				}
			}
		} catch (Exception e) {
			logPlayer.info("CATCH: Error al crear el jugador: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CATCH: Error al crear el jugador: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<List<Player>> getAllElementListUG() {
		try {
			List<Player> playerModelList = playerDAO.findAll();
			if (playerModelList.isEmpty()) {
				logPlayer.info("Lista de jugadores Vacia.");
			} else {
				logPlayer.info("Lista de jugadores encontrada.");
			}
			return ResponseEntity.status(HttpStatus.OK).body(playerModelList);
		} catch (Exception e) {
			logPlayer.info("CATCH: Error al obtener la lisa de jugadores: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CATCH: Error al obtener la lisa de jugadores: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Player> updateElementListUG(Player element) {
		try {
			if (playerDAO.existsById(element.getId()) && teamDAO.existsTeamByName(element.getTeam().getName())) {
				Player player = playerDAO.findById(element.getId()).get();
				player.setName(element.getName());
				player.setSurname(element.getSurname());
				player.setDni(element.getDni());
				player.setEmail(element.getEmail());
				player.setBirthday(element.getBirthday());
				player.setGender(element.getGender());
				player.setAddress(element.getAddress());
				player.setMobile(element.getMobile());
				player.setPhoto(element.getPhoto());
				player.setPosition(element.getPosition());
				player.setDorsal(element.getDorsal());
				player.setTeam(teamDAO.findTeamByName(element.getTeam().getName()));
				playerDAO.save(player);
				logPlayer.info("Jugador actualizado.");
				return ResponseEntity.status(HttpStatus.OK).body(player);
			} else {
				logPlayer.info("ELSE: No existe el jugador a actualizar.");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ELSE: No existe el jugador a actualizar.");
			}
		} catch (Exception e) {
			logPlayer.info("CATCH: Error al actualizar el jugador: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CATCH: Error al actualizar el jugador: " + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deleteElementListUG(Long idElement) {
        try {
            if (playerDAO.existsById(idElement)) {
                Player player = playerDAO.findById(idElement).get();
                playerDAO.delete(player);
                logPlayer.info("Jugadoro encontrado y eliminado.");
                return ResponseEntity.status(HttpStatus.OK).body(player);
            } else {
            	logPlayer.info("ELSE: No existe el jugador a eliminar.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ELSE: No existe el jugador a eliminar.");
            }
        } catch (Exception e) {
        	logPlayer.info("CATCH: Error al eliminar el jugador: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CATCH: Error al eliminar el jugador: " + e.getMessage());
        }
	}

}

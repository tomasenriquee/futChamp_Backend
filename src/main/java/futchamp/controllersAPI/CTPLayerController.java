package futchamp.controllersAPI;

import static futchamp.literals.Links.ID_PLAYER;
import static futchamp.literals.Links.PLAYER;
import static futchamp.literals.Links.SLASH;
import static futchamp.literals.Qualifiers.SER_PLAYER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import futchamp.entities.Player;
import futchamp.services.SIPlayerDAOImp;

@RestController
@RequestMapping(PLAYER)
public class CTPLayerController {

	@Autowired
	@Qualifier(SER_PLAYER)
	private SIPlayerDAOImp playerDAOImp;

	@PostMapping(SLASH)
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		return playerDAOImp.addElementListUG(player);
	}

	@GetMapping(SLASH)
	public ResponseEntity<List<Player>> getAllPlayers() {
		return playerDAOImp.getAllElementListUG();
	}

	@PutMapping(SLASH)
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
		return playerDAOImp.updateElementListUG(player);
	}

	/** futchamp/V2/player/{idPlayer} */
	@DeleteMapping(ID_PLAYER)
	public ResponseEntity<?> deletePlayer(@PathVariable Long idPlayer) {
		return playerDAOImp.deleteElementListUG(idPlayer);
	}

}

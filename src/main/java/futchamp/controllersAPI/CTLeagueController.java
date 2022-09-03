package futchamp.controllersAPI;

import static futchamp.literals.Links.LEAGUE;
import static futchamp.literals.Links.SLASH;
import static futchamp.literals.Qualifiers.SER_LEAGUE;

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

import futchamp.entities.League;
import futchamp.services.SILeagueDAOImp;

@RestController
@RequestMapping(LEAGUE)
public class CTLeagueController {

	/** Llamada a los servicios de LEAGUE */
	@Autowired
	@Qualifier(SER_LEAGUE)
	private SILeagueDAOImp leagueDaoImp;

	/** futchamp/V2/league/ */
	@PostMapping(SLASH)
	public ResponseEntity<League> addLeague(@RequestBody League league) {
		return leagueDaoImp.addElementListUG(league);
	}

	@GetMapping(SLASH)
	public ResponseEntity<List<League>> getAllLeague() {
		return leagueDaoImp.getAllElementListUG();
	}

	@PutMapping(SLASH)
	public ResponseEntity<League> updateLeague(@RequestBody League league) {
		return leagueDaoImp.updateElementListUG(league);
	}

	/** futchamp/V2/league/{idLeague} */
	@DeleteMapping(SLASH + "{idLeague}")
	public ResponseEntity<?> deleteLeague(@PathVariable Long idLeague) {
		return leagueDaoImp.deleteElementListUG(idLeague);
	}

}

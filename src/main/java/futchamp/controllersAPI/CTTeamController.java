package futchamp.controllersAPI;

import static futchamp.literals.Links.ID_TEAM;
import static futchamp.literals.Links.SLASH;
import static futchamp.literals.Links.TEAM;
import static futchamp.literals.Qualifiers.SER_TEAM;

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

import futchamp.entities.Team;
import futchamp.services.SITeamDAOImp;

@RestController
@RequestMapping(TEAM)
public class CTTeamController {

	@Autowired
	@Qualifier(SER_TEAM)
	private SITeamDAOImp teamDAOImp;

	/** futchamp/V2/team/ */
	@PostMapping(SLASH)
	public ResponseEntity<Team> addTeam(@RequestBody Team team) {
		return teamDAOImp.addElementListUG(team);
	}

	@GetMapping(SLASH)
	public ResponseEntity<List<Team>> getAllTeams() {
		return teamDAOImp.getAllElementListUG();
	}

	@PutMapping(SLASH)
	public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
		return teamDAOImp.updateElementListUG(team);
	}

	/** futchamp/V2/team/{idTeam} */
	@DeleteMapping(ID_TEAM)
	public ResponseEntity<?> deleteTeam(@PathVariable Long idTeam) {
		return teamDAOImp.deleteElementListUG(idTeam);
	}

}

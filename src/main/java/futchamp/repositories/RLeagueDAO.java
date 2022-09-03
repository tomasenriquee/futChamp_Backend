package futchamp.repositories;

import static futchamp.literals.RKeysDAO.DAO_LEAGUE;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import futchamp.entities.League;

@Repository(DAO_LEAGUE)
public interface RLeagueDAO extends JpaRepository<League, Serializable> {

}

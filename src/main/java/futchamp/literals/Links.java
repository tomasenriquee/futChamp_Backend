package futchamp.literals;

/**
 * Esta Interface Almacenara las links o rutas para acceder a la api y esta relacionada directamente con las clases controller de cada entidad
 */
public interface Links {

	/** Nombre de empresa o proyecto */
	String NAME_API = "/futchamp";

	/** Version api */
	String VERSION = "/V2";

	/** Barra diagonal */
	String SLASH = "/";

	/** Ruta => /futchamp/V2/ */
	String ROUTE = NAME_API + VERSION + SLASH;

	/** 
	 * Enlaces o rutas de acceso para el controlador de LEAGUE
	 */

	/** Ruta => /futchamp/V2/league */
	String LEAGUE = ROUTE + "league";

	/** Ruta => /{idLeague} */
	String ID_LEAGUE = SLASH + "{idLeague}";

	/**
	 * Enlaces o rutas de acceso para el controlador de TEAM
	 */

	/** Ruta => /futchamp/V2/team */
	String TEAM = ROUTE + "team";

	/** Ruta => /{idTeam} */
	String ID_TEAM = SLASH + "{idTeam}";
	
	
    /**
     * Enlaces para las rutas de acceso para el controlador de PLAYER
     */

	/** Ruta => /futchamp/V2/player */
    String PLAYER = ROUTE + "player";
    
	/** Ruta => /{idPlayer} */
	String ID_PLAYER = SLASH + "{idPlayer}";
}

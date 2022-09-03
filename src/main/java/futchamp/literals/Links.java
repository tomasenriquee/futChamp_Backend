package futchamp.literals;

/**
 * Esta Interface Almacenara las links o rutas para acceder a la api y esta
 * relacionada directamente con las clases controller de cada entidad
 */
public interface Links {

	/** Nombre de empresa o proyecto */
	String NAME_API = "/futchamp";

	/** Version api */
	String VERSION = "/V2";

	/** Barra diagonal */
	String SLASH = "/";

	/** Ruta =>  /futchamp/V2/ */
	String ROUTE = NAME_API + VERSION + SLASH;

	/**
	 * Enlaces o rutas de acceso para el controlador de LEAGUE
	 */

	/** Ruta => /futchamp/V2/league */
	String LEAGUE = ROUTE + "league";
}

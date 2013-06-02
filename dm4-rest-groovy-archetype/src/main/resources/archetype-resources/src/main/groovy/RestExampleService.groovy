#set( $symbol_dollar = '$' )
package ${package}

import de.deepamehta.core.osgi.PluginActivator
import de.deepamehta.core.service.event.AllPluginsActiveListener

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.WebApplicationException

import java.util.logging.Logger

@Path("/example/groovy")
class RestExampleService extends PluginActivator implements AllPluginsActiveListener {

    private static Logger log = Logger.getLogger RestExampleService.class.getName()

    @Override
    void allPluginsActive() {
        log.info "create some Notes and open /example/groovy/notes to check this service"
    }

    /**
     * @return list of all <code>Note</code> titles
     */
    @GET
    @Path("/notes")
    @Produces("application/json")
    Set<String> listAllNoteTitles() {
        log.info "return all Note titles"
        try {
            dms.getTopics("dm4.notes.note", true, 0, null).collect {
                log.finest it.toJSON().toString()
                it.getCompositeValue().getString "dm4.notes.title", "n/a"
            }
        } catch (e) {
            log.warning e.getMessage()
            throw new WebApplicationException(e)
        }
    }

}


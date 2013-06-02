#set( $symbol_dollar = '$' )
package ${package};

import de.deepamehta.core.RelatedTopic;
import de.deepamehta.core.ResultSet;
import de.deepamehta.core.osgi.PluginActivator;
import de.deepamehta.core.service.event.AllPluginsActiveListener;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Path("/example")
public class RestExampleService extends PluginActivator implements AllPluginsActiveListener {

    private static Logger log = Logger.getLogger(RestExampleService.class.getName());

    @Override
    public void allPluginsActive() {
        log.info("create some Notes and open /example/notes to check this service");
    }

    /**
     * @return list of all <code>Note</code> titles
     */
    @GET
    @Path("/notes")
    @Produces("application/json")
    public Set<String> listAllNoteTitles() {
        log.info("return all Note titles");
        try {
            Set<String> titles = new HashSet<String>();
            for (RelatedTopic note : dms.getTopics("dm4.notes.note", true, 0, null)) {
                log.finest(note.toJSON().toString());
                titles.add(note.getCompositeValue().getString("dm4.notes.title", "n/a"));
            }
            return titles;
        } catch (Exception e) {
            log.warning(e.getMessage());
            throw new WebApplicationException(e);
        }
    }

}

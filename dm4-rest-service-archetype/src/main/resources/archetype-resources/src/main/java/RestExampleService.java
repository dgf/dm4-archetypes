#set( $symbol_dollar = '$' )
package ${package};

import de.deepamehta.core.RelatedTopic;
import de.deepamehta.core.ResultSet;
import de.deepamehta.core.osgi.PluginActivator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Path("/example")
public class RestExampleService extends PluginActivator {

    private static Logger log = Logger.getLogger(RestExampleService.class.getName());

    /**
     * @return list of all <code>Note</code> titles
     */
    @GET
    @Path("/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> listAllNoteTitles() {
        log.info("return all note titles");
        try {
            ResultSet<RelatedTopic> notes = dms.getTopics("dm4.notes.note", true, 0, null);
            Set<String> titles = new HashSet<String>();
            for (RelatedTopic note : notes) {
                titles.add(note.getCompositeValue().getString("dm4.notes.title", "n/a"));
            }
            log.finest("all Note topics\n" + notes.toJSON());
            return titles;
        } catch (Exception e) {
            log.warning(e.getMessage());
            throw new WebApplicationException(e);
        }
    }

}

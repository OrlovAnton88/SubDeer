package aorlov.subdeer.filters;

import java.util.Collection;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 17.06.14
 * Time: 0:53
 * To change this template use File | Settings | File Templates.
 */
public interface SimpleFilter {

    public Collection<Set>  getLists(String path);

    public void sortOut(Collection input, Collection filers);
}

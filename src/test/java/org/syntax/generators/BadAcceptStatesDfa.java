package org.syntax.generators;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import org.syntax.Dfa;
import org.syntax.State;

public class BadAcceptStatesDfa extends Dfa {
    public BadAcceptStatesDfa() {
        super(Sets.newHashSet('a', 'b'), Sets.newHashSet(new State(0), new State(1), new State(2)), new State(0),
                Sets.newHashSet(new State(0), new State(3)), HashBasedTable.create());
    }
}

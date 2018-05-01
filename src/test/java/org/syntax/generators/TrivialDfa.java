package org.syntax.generators;

import com.google.common.collect.HashBasedTable;
import org.syntax.Dfa;
import org.syntax.State;

import java.util.Collections;
import java.util.HashSet;


public class TrivialDfa extends Dfa {
    public TrivialDfa() {
        super(new HashSet<>(), Collections.singleton(new State(0)), new State(0), new HashSet<>(), HashBasedTable.create());
    }
}


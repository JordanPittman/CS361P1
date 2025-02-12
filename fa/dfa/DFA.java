package fa.dfa;

import java.util.*;

/**
 * @author Jordan Pittman
 *
 * Implimentation of the DFA interface class.
 * Handles construction of DFAs and determining
 * if strings are part of a DFA.
 */
public class DFA implements DFAInterface {
    private Set<DFAState> states = new LinkedHashSet<>();
    private Set<Character> alphabet = new LinkedHashSet<>();
    private DFAState startState;
    private Set<DFAState> finalStates = new LinkedHashSet<>();

    /**
     * Get the state with the given name from the 
     * internal collection of states in this DFA
     * @param name - the name of the DFAState
     * @return DFAState - the state with this name, or null if no
     *                    state with the given name is present in this DFA
     */
    private DFAState get(String name) {
        for (DFAState s : states) if (s.getName().equals(name)) return s;
        return null;
    }

    @Override
    public boolean addState(String name) {
        if (get(name) != null) return false;
        states.add(new DFAState(name));
        return true;
    }

    @Override
    public boolean setStart(String name) {
        DFAState s = get(name);
        if (s == null) return false;
        startState = s;
        return true;
    }

    @Override
    public boolean setFinal(String name) {
        DFAState s = get(name);
        if (s == null) return false;
        s.setFinal();
        finalStates.add(s);
        return true;
    }

    @Override
    public void addSigma(char symbol) {
        alphabet.add(symbol);
    }

    @Override
    public boolean addTransition(String from, String to, char symbol) {
        DFAState f = get(from), t = get(to);
        if (f == null || t == null || !alphabet.contains(symbol)) return false;
        f.addTransition(symbol, t);
        return true;
    }

    @Override
    public boolean accepts(String input) {
        if (startState == null) return false;
        DFAState curr = startState;
        for (char c : input.toCharArray()) {
            curr = curr.getNextState(c);
            if (curr == null) return false;
        }
        return curr.isFinal();
    }

    @Override
    public DFAState getState(String name) {
        return get(name);
    }

    @Override
    public boolean isFinal(String name) {
        DFAState s = get(name);
        return (s != null && s.isFinal());
    }

    @Override
    public boolean isStart(String name) {
        return (startState != null && startState.getName().equals(name));
    }

    @Override
    public Set<Character> getSigma() {
        return alphabet;
    }

    @Override
    public DFA swap(char s1, char s2) {
        DFA d = new DFA();
        for (char c : alphabet) d.alphabet.add((c == s1) ? s2 : (c == s2) ? s1 : c);
        for (DFAState st : states) {
            d.addState(st.getName());
            if (st.isFinal()) d.setFinal(st.getName());
        }
        if (startState != null) d.setStart(startState.getName());
        for (DFAState st : states) {
            for (Map.Entry<Character,DFAState> e : st.getTransitions().entrySet()) {
                char c = (e.getKey() == s1) ? s2 : (e.getKey() == s2) ? s1 : e.getKey();
                d.addTransition(st.getName(), e.getValue().getName(), c);
            }
        }
        return d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Q = { ");
        for (DFAState s : states) sb.append(s.getName()).append(" ");
        sb.append("}\nSigma = { ");
        for (char c : alphabet) sb.append(c).append(" ");
        sb.append("}\ndelta =\n\t");
        for (char c : alphabet) sb.append(c).append(" ");
        sb.append("\n");
        for (DFAState s : states) {
            sb.append(s.getName()).append(" ");
            for (char c : alphabet) {
                DFAState n = s.getNextState(c);
                sb.append(n == null ? "-" : n.getName()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("q0 = ").append(startState == null ? "-" : startState.getName());
        sb.append("\nF = { ");
        for (DFAState s : finalStates) sb.append(s.getName()).append(" ");
        return sb.append("}\n").toString().replaceAll("\\s+", " ").trim();
    }
}

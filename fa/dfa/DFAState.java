package fa.dfa;
import fa.State;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jordan Pittman
 *
 * Extension of the State class that allows
 * the storage and retrevial of information
 * about a given state, i.e. if it is a final
 * state.
 */
public class DFAState extends State {

   /** 
    * Collection of transitions from this state to
    * another state in the associated DFA          */
    private Map<Character,DFAState> transitions = new HashMap<>();

    /**
     * Keep track of whether this is a final 
     * state in the associated DFA           */
    private boolean isFinal;

    /**
     * Construct a new DFAState with the given name
     * @param name - the name of the state
     */
    public DFAState(String name){ super(name); }

    /**
     * Construct a new transition from this state 
     * to another state in the DFA               
     * @param c - the character to transition on
     * @param s - the state to transition to
     */
    public void addTransition(char c, DFAState s){ transitions.put(c,s); }

    /**
     * Follow the given transition to find
     * the next state in the DFA
     * @param c - the character to transition on
     * @return DFAState - the next state, or null if no state
     *                    is defined on this transition.    
     */
    public DFAState getNextState(char c){ return transitions.get(c); }

    /**
     * Set this state as a final state
     */
    public void setFinal(){ isFinal=true; }

    /**
     * check if this state is a final state
     * @return boolean - true if state is final, false otherwise
     */
    public boolean isFinal(){ return isFinal; }

    /**
     * Return the entire transition table for this
     * state. Useful for internal methods in the DFA
     * @return Map<Character,DFAState> - the transition table for this state
     */
    public Map<Character,DFAState> getTransitions(){ return transitions; }
}

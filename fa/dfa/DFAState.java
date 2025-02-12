package fa.dfa;
import fa.State;
import java.util.HashMap;
import java.util.Map;

public class DFAState extends State {
    private Map<Character,DFAState> transitions = new HashMap<>();
    private boolean isFinal;

    public DFAState(String name){ super(name); }
    public void addTransition(char c, DFAState s){ transitions.put(c,s); }
    public DFAState getNextState(char c){ return transitions.get(c); }
    public void setFinal(){ isFinal=true; }
    public boolean isFinal(){ return isFinal; }
    public Map<Character,DFAState> getTransitions(){ return transitions; }
}

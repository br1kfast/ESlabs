import java.util.ArrayList;
import java.util.List;

/**
 * @author JunFei
 * @data
 */
public class DataRules {
    public List<Rule> getListOfRules() {
        Rule rule101 = new Rule(101, new Ver(3, 0), new Ver[]{new Ver(1,0), new Ver(2, 0)}, 2,0);
        Rule rule102 = new Rule(102, new Ver(7, 0), new Ver[]{new Ver(3, 0), new Ver(2, 0), new Ver(4, 0)}, 3,0);
        Rule rule103 = new Rule(103, new Ver(4, 0), new Ver[]{new Ver(5, 0), new Ver(6, 0)}, 2,0);
        Rule rule104 = new Rule(104, new Ver(14, 0), new Ver[]{new Ver(7, 0), new Ver(8, 0)}, 2,0);
        Rule rule105 = new Rule(105, new Ver(8, 0), new Ver[]{new Ver(4, 0), new Ver(10, 0), new Ver(11, 0)}, 3,0);
        Rule rule106 = new Rule(106, new Ver(11, 0), new Ver[]{new Ver(12, 0), new Ver(13, 0)}, 2,0);
        Rule rule107 = new Rule(107, new Ver(8, 0), new Ver[]{new Ver(15, 0)}, 1,0);
        Rule rule108 = new Rule(108, new Ver(14, 0), new Ver[]{new Ver(8, 0), new Ver(9, 0)}, 2,0);

        List<Rule> listOfRules = new ArrayList<>();
        listOfRules.add(rule101);
        listOfRules.add(rule102);
        listOfRules.add(rule103);
        listOfRules.add(rule104);
        listOfRules.add(rule105);
        listOfRules.add(rule106);
        listOfRules.add(rule107);
        listOfRules.add(rule108);
        return listOfRules;
    }
}

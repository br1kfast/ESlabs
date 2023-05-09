import java.util.ArrayList;
import java.util.List;

/**
 * @author JunFei
 * @data
 * @purpose
 */
public class Data {
    public List<Ver> getListOfVers() {
        Ver ver1 = new Ver(1, 0);
        Ver ver2 = new Ver(2, 0);
        Ver ver3 = new Ver(3, 0);
        Ver ver4 = new Ver(4, 0);
        Ver ver5 = new Ver(5, 0);
        Ver ver6 = new Ver(6, 0);
        Ver ver7 = new Ver(7, 0);
        Ver ver8 = new Ver(8, 0);
        Ver ver9 = new Ver(9, 0);
        Ver ver10 = new Ver(10, 0);
        Ver ver11 = new Ver(11, 0);
        Ver ver12 = new Ver(12, 0);
        Ver ver13 = new Ver(13, 0);
        Ver ver14 = new Ver(14, 0);
        Ver ver15 = new Ver(15, 0);

        List<Ver> listOfVers = new ArrayList<>();
        listOfVers.add(ver1);
        listOfVers.add(ver2);
        listOfVers.add(ver3);
        listOfVers.add(ver4);
        listOfVers.add(ver5);
        listOfVers.add(ver6);
        listOfVers.add(ver7);
        listOfVers.add(ver8);
        listOfVers.add(ver9);
        listOfVers.add(ver10);
        listOfVers.add(ver11);
        listOfVers.add(ver12);
        listOfVers.add(ver13);
        listOfVers.add(ver14);
        listOfVers.add(ver15);

        return listOfVers;
    }
    public List<Rule> getListOfRules() {
        Ver ver1 = new Ver(1, 0);
        Ver ver2 = new Ver(2, 0);
        Ver ver3 = new Ver(3, 0);
        Ver ver4 = new Ver(4, 0);
        Ver ver5 = new Ver(5, 0);
        Ver ver6 = new Ver(6, 0);
        Ver ver7 = new Ver(7, 0);
        Ver ver8 = new Ver(8, 0);
        Ver ver9 = new Ver(9, 0);
        Ver ver10 = new Ver(10, 0);
        Ver ver11 = new Ver(11, 0);
        Ver ver12 = new Ver(12, 0);
        Ver ver13 = new Ver(13, 0);
        Ver ver14 = new Ver(14, 0);
        Ver ver15 = new Ver(15, 0);
        Rule rule101 = new Rule(101, ver3, new Ver[]{ver1, ver2}, 2,0);
        Rule rule102 = new Rule(102, ver7, new Ver[]{ver3, ver2, ver4}, 3,0);
        Rule rule103 = new Rule(103, ver4, new Ver[]{ver5, ver6}, 2,0);
        Rule rule104 = new Rule(104, ver14, new Ver[]{ver7, ver8}, 2,0);
        Rule rule105 = new Rule(105, ver8, new Ver[]{ver4, ver10, ver11}, 3,0);
        Rule rule106 = new Rule(106, ver11, new Ver[]{ver12, ver13}, 2,0);
        Rule rule107 = new Rule(107, ver8, new Ver[]{ver15}, 1,0);
        Rule rule108 = new Rule(108, ver14, new Ver[]{ver8, ver9}, 2,0);

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

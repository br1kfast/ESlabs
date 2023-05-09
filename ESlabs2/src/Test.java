import java.util.ArrayList;
import java.util.List;

/**
 * @author JunFei
 * @data
 * @purpose
 */
public class Test {
    public static void main(String[] args) {
        Ver ver0 = new Ver();
        ver0.num = 1;
        ver0.flag = 0;
        Ver ver1 = new Ver(2, 0);
        Ver ver2 = new Ver(3, 0);
        Ver ver3 = new Ver(2, 0);
        Rule rule = new Rule(1, new Ver(7, 0), new Ver[]{new Ver(8, 0), new Ver(9, 0)}, 2, 0);


        List<Ver> vers = new ArrayList<>();
        vers.add(ver0);
        vers.add(ver1);
        vers.add(ver2);

        for (Ver ver : vers) {
            if (ver.num == ver3.num)
                ver.flag = 1;
        }
        System.out.println(vers.get(1).getFlag());//1

        ver0.flag = 1;
        System.out.println(ver0.flag);//1
        System.out.println(vers.get(0).flag);//1
        vers.remove(1);
        System.out.println(vers.get(1).num);
//        Ver[] vers = {ver0, ver1, ver2, ver3};
//        System.out.println(vers.length);
//        vers[0] = null;
//        System.out.println(vers.length);

        Ver[] invs = rule.invs;
        invs[1].flag = 1;
        System.out.println(rule.invs[1].flag);
    }
}

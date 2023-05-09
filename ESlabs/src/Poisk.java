import java.util.*;

/**
 * @author JunFei
 * @data
 * @purpose 证明 对一组给定的输入顶点
 *          从输入顶点到输出顶点
 *          是否正确 即路径是否可达
 *          Доказательство от входной вершины до вершины результата
 */
public class Poisk {

    /*使用BFS*/
    //Обход поиска в ширину
    public boolean findFromData (List<Ver> listOfVers, List<Rule> listOfRules, Ver[] vers, Ver target) {

        if (vers == null) {
            return false;
        }

        //移除那些输出顶点为当前输入条件的规则 减少搜索量
        //Удалите те правила, выходной вершиной которых является текущее входное условие,
        //чтобы уменьшить объем поиска
        for (int i = 0; i < listOfRules.size(); i++) {
            for (int j = 0; j < vers.length; j++) {
                if (listOfRules.get(i).outv.num == vers[j].num) {
                    listOfRules.remove(i);
                }
            }
        }

        //count数组存储每条规则的输入顶点数量
        //!!В массиве count хранится количество входных вершин для каждого правила
        //Используется для помощи в проверке того, что правила соответствуют условиям
        int[] count = new int[listOfRules.size()];
        for (int i = 0; i < listOfRules.size(); i++) {
            count[i] = listOfRules.get(i).invn;
        }

        //获取输入顶点
        //Входная очередь соединения вершин
        Queue<Ver> versQueue = new LinkedList<>();
        for (int i = 0; i < vers.length; i++) {
            versQueue.add(vers[i]);
            vers[i].flag = 1;
        }

        //输出顶点
        //вершина результата
        int targetNumber = target.num;


        //Перебирать вершины в очереди одну за другой
        while (!versQueue.isEmpty()) {

            Ver ver = versQueue.poll();

            if (ver.num == targetNumber) {
                System.out.println("The list of rules number is: ");
                for (int i = 0; i < listOfRules.size(); i++) {
                    if (listOfRules.get(i).flag == 1) {
                        System.out.print(listOfRules.get(i).num + " ");
                    }
                }
                System.out.println();
                System.out.println("The input and output is: ");
                for (int i = 0; i < vers.length; i++) {
                    System.out.print(vers[i].num + " ");
                }
                System.out.print("->" + " " + targetNumber);
                System.out.println();
                return true;
            }

            //Пройдитесь по набору правил, найдите те правила,
            // входная вершина которых имеет текущую вершину, и "count - 1
            for (int i = 0; i < listOfRules.size(); i++) {
                for (int j =0; j < listOfRules.get(i).invn; j++) {
                    if (listOfRules.get(i).invs[j].num == ver.num) {
                        count[i]--;
                        listOfRules.get(i).invs[j].flag = 1;
                    }
                }
            }

            //Пройдите набор правил, чтобы найти правила, входные вершины которых удовлетворяют условиям,
            // тогда правило доказано, и получите его входные вершины.
            for (int i = 0; i < listOfRules.size(); i++) {
                if (count[i] == 0 && listOfRules.get(i).flag == 0) {
                    listOfRules.get(i).flag = 1;//将规则标记为1表示所有输入条件已满足
                    versQueue.add(listOfRules.get(i).outv);//将该规则的输出顶点加入到队列Добавить выходную вершину правила в очередь
                }
            }

        }

        return false;

    }


    public static void main(String[] args) {


        //从终端获取输入规则
        //Получить номер входной вершины и целевой вершины из терминала
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers:");
        String s = scanner.nextLine();
        String[] nums = s.split(" ");
        Ver[] vers = new Ver[nums.length];
        for (int i = 0; i< nums.length; i++) {
            vers[i] = new Ver(Integer.parseInt(nums[i]), 0);
        }
        System.out.println("Target number:");
        int i = scanner.nextInt();
        Ver target = new Ver(i,0);

        DataRules dataRules = new DataRules();
        DataVers dataVers = new DataVers();
        List<Rule> listOfRules = dataRules.getListOfRules();
        List<Ver> listOfVers = dataVers.getListOfVers();

        Poisk poisk = new Poisk();
        System.out.println(poisk.findFromData(listOfVers, listOfRules, vers, target));


    }

}

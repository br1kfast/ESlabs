import java.util.*;

/**
 * @author JunFei
 * @data
 * @purpose 证明从输出顶点到输入顶点
 *          Если условие выполнено, выведите результат
 *
 */
public class Poisk {
    /*DFS*/
    //Поиск в глубину
    public boolean findFromTarget(List<Ver> listOfVers, List<Rule> listOfRules, List<Ver> vers, Ver target) {

        //！！注意：集合中所有的规则和顶点都是从规则列表中(listOfRules)获取的，以便统一处理各顶点和规则,与输入集和顶点集无关
        Stack<Rule> rulesStack = new Stack<>();//存放需要遍历的规则（除头规则）Храните правила, которые необходимо пройти (кроме правил заголовка)
        Stack<Ver> versStack = new Stack<>();//存放需要遍历的顶点Храните вершины, которые необходимо пройти

        Stack<Rule> firstRules = new Stack<>(); //存放头规则store the rules that their output is the target
        List<Rule> closedRules = new ArrayList<>();
        //набор результатов правила
        List<Rule> resultRules = new ArrayList<>();
        List<Ver> closedVers = new ArrayList<>();//关闭顶点列表，已遍历的顶点вершины пройдены
        //набор результатов вершин
        List<Ver> resultVers = new ArrayList<>();//顶点结果列表，已遍历并已证明(有flag=1)的顶点Вершины, которые были пройдены и проверены (с флагом = 1)

        //规则入栈targetRules并从listOfRules中移除
        //Правила помещаются в targetRules и удаляются из listOfRules
        //Уменьшить количество правил обхода
        for (int i = 0; i < listOfRules.size(); i++) {
            if (listOfRules.get(i).outv.num == target.num) {
                firstRules.push(listOfRules.get(i));
                listOfRules.remove(i);
            }
        }

        //若有多个头规则，则需要这样做
        while (!firstRules.isEmpty()) {

            /*从头规则开始*/
            /*начать с нуля правила*/
            Rule firstRule = firstRules.pop();
            Ver[] vers0;
            vers0 = firstRule.getInvs();
            for (int i = 0; i < firstRule.invn; i++) {
                if (vers0[i].flag == 0)
                    versStack.push(vers0[i]);
            }
            if (vers.size() >= firstRule.invn) { //输入顶点数少，自然就没有必要继续比较
                int count = 0;//используется для подсчета количества циклов
                for (Ver ver1 : vers0) {
                    for (int i = 0; i < vers.size(); i++) {
                        if (vers.get(i).num == ver1.num) {
                            ver1.flag = 1;//установить флаг
                            closedVers.add(ver1);//加入关闭顶点列表Добавить в список закрытых вершин
                            resultVers.add(ver1);//加入已证明顶点列表Присоединяйтесь к списку проверенных вершин
                            //此顶点已证明（有），从顶点栈中移除，意味着它下面的规则都不用遍历
                            versStack.remove(ver1);//Эта вершина была доказана (доказана), удалена из стека вершин, а это значит, что правила ниже нее не нужно проходить
                            count++;
                        }
                    }
                }
//                for (int i = 0; i < firstRule.invn; i++) {
//                    if (firstRule.invs[i].flag == 1)
//                        count++;
//                }
                //Если заданная вершина включает в себя все входные вершины главного правила,
                // условие выполняется и результат выдается непосредственно
                if (count == firstRule.invn) {
                    firstRule.flag = 1;
                    System.out.println("The numbers of rules is:");
                    System.out.println(firstRule.num);
                    System.out.println("The input and output is:");
                    for (int i = 0; i < vers.size(); i++) {
                        System.out.print(vers.get(i).num + " ");
                    }
                    System.out.print("->" + " " + target.num);
                    System.out.println();
                    return true;
                }
            } else {
                continue; //如果用户输入顶点数量小于当前规则的输入顶点数量，则直接结束此次循环，没必要继续比较，此规则不可取，以下类似
                          //Если количество входных вершин меньше, чем количество входных вершин текущего правила вывода, этот цикл будет завершен напрямую, как показано ниже.
            }

            while (!versStack.isEmpty()) {//Получить значение в стеке вершин
                Ver curVer = versStack.pop();
                closedVers.add(curVer);
                int count1 = 0;
                for (Rule rule : listOfRules) {
                    if (rule.outv.num == curVer.num) {
                        rulesStack.push(rule);
                        count1++;
                    }
                }
                while (!rulesStack.isEmpty()) {//Получить значение в стеке правил
                    Rule curRule = rulesStack.pop();
//                    Ver outVer = curRule.outv;
                    closedRules.add(curRule);
                    Ver[] vers1;
                    vers1 = curRule.getInvs();
                    for (int i = 0; i < curRule.invn; i++) {
                        if (vers1[i].flag == 0)
                            versStack.push(vers1[i]);//Поместите все входные вершины правила в стек, готовые к их обходу.
                    }
                    //Во входном наборе вершин (кроме вершины с флагом=1,
                    // чтобы предотвратить повторный обход) определить,
                    // соответствует ли входная вершина текущему правилу.
                    //每次遍历到新的规则都要进行输入顶点匹配的比较
                    if (vers.size() >= curRule.invn) {
                        for (Ver ver1 : vers1) {
                            for (int i = 0; i < vers.size(); i++) {
                                if (vers.get(i).num == ver1.num && ver1.flag == 0) {
                                    ver1.flag = 1;
                                    closedVers.add(ver1);
                                    resultVers.add(ver1);
                                    versStack.remove(ver1);//Если они существуют, удалить их из стека без обхода их и вершин под ними
                                }
                            }
                        }
                        //Проверить, удовлетворяет ли текущее правило условию
                        int count2 = 0;
                        for (int i = 0; i < curRule.invn; i++) {
                            if (curRule.invs[i].flag == 1)
                                count2++;
                        }
                        if (count2 == curRule.invn) {
                            curRule.flag = 1;
                            resultRules.add(curRule);//该规则已被证实Правило проверено и добавлено в результирующий набор правил.
                            curVer.flag = 1;//该规则的输出顶点就也被证实Разумеется, выходная вершина правила также проверяется.
                        }
                    } else {
                        continue;
                    }

                    //检查是否有已遍历但未证明(未满足条件)的规则是否已满足条件
                    //Проверяет, было ли пройдено какое-либо правило, но не доказано (условие не выполнено), что условие было выполнено
                    //Найти из закрытых правил
                    for (Rule wpRule : closedRules) {
                        if (wpRule.flag == 0) {
                            int count3 = 0;
                            for (int i = 0; i < wpRule.invn; i++) {
                                if (wpRule.invs[i].flag == 1)
                                    count3++;
                            }
                            if (count3 == wpRule.invn) {
                                wpRule.flag = 1;
                                resultRules.add(wpRule);
                                wpRule.outv.flag = 1;
                            }

                        }

                    }

                }

            }
            /*头规则下面都已遍历，需重新检查头规则是否满足*/
            //Все под текущим правилом головы пройдено,
            // и необходимо перепроверить, удовлетворяет ли правило головы условиям
            int count4 = 0;
            for (int i = 0; i < firstRule.invn; i++) {
                if (firstRule.invs[i].flag == 1)
                    count4++;
            }
            if (count4 == firstRule.invn)
                firstRule.flag = 1;

            //Если условие выполнено, выведите результат
            if (firstRule.flag == 1) {
                System.out.println("The numbers of rules is:");
                for (int i = 0; i < resultRules.size(); i++) {
                    System.out.print(resultRules.get(i).num + " ");
                }
                System.out.print(firstRule.num);
                System.out.println();
                System.out.println("The input and output is:");
                for (int i = 0; i < resultVers.size(); i++) {
                    System.out.print(resultVers.get(i).num + " ");
                }
                System.out.print("->" + " " + target.num);
                System.out.println();
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        //从终端获取输入顶点的编号
        //Получить правила ввода из терминала
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers:");
        String s = scanner.nextLine();
        String[] nums = s.split(" ");
        List<Ver> vers = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
             vers.add(new Ver(Integer.parseInt(nums[i]), 0));
        }
        System.out.println("Target number:");
        int i = scanner.nextInt();
        Ver target = new Ver(i,0);

        Data data = new Data();
        List<Rule> listOfRules = data.getListOfRules();
        List<Ver> listOfVers = data.getListOfVers();

        Poisk poisk = new Poisk();
        System.out.println(poisk.findFromTarget(listOfVers, listOfRules, vers, target));
    }
}

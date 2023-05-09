/**
 * @author JunFei
 * @data
 * @purpose 规则класс правил
 */
public class Rule {
    int num;//规则编号номер правила
    Ver outv;//выходная вершина
    Ver[] invs;//выходные вершины
    int invn;//Количество входных вершин
    int flag;//знак

    public Rule() {}

    public Rule(int num, Ver outv, Ver[] invs, int invn, int flag) {
        this.num = num;
        this.outv = outv;
        this.invs = invs;
        this.invn = invn;
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Ver getOutv() {
        return outv;
    }

    public void setOutv(Ver outv) {
        this.outv = outv;
    }

    public Ver[] getInvs() {
        return invs;
    }

    public void setInvs(Ver[] inv) {
        this.invs = invs;
    }

    public int getInvn() {
        return invn;
    }

    public void setInvn(int invn) {
        this.invn = invn;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

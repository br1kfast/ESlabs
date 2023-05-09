/**
 * @author JunFei
 * @data
 * @purpose
 */
public class Rule {
    int num;//规则编号
    Ver outv;
    Ver[] invs;
    int invn;
    int flag;

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

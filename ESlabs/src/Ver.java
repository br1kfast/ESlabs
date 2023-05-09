/**
 * @author JunFei
 * @data
 * @purpose 顶点вершина
 */
public class Ver {
    int num;//编号номер вершины
    int flag;//标志знак

    public Ver() {}

    public Ver(int num, int flag) {
        this.num = num;
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

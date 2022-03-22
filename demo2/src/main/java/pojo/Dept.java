package pojo;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 21:24
 * 部门类
 */
public class Dept {
    private int did;
    private String deptName;
    private List<Emp> emps;

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept(int did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

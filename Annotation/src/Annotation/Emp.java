package Annotation;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Emp
 * @Description
 * @Author 李振兴
 * @Date 2020/11/3 14:57
 **/
@Table(Tablename = "Emp")
public class Emp implements Serializable {
    @Colum(ColumName = "empno",ColumType = "varchar",ColumConstrain = "primary",ColumLenght = "20")
    private int empno;
    @Colum(ColumName = "name",ColumType = "varchar",ColumLenght = "20")
    private String name;
    @Colum(ColumName = "mgr",ColumType = "Integer",ColumLenght = "20")
    private int mgr;
    @Colum(ColumName = "hiredate",ColumType = "DATA")
    private Date hiredate;
    @Colum(ColumName = "sal",ColumType = "varchar",ColumLenght = "20")
    private Double sal;

    public Emp(int empno, String name, int mgr, Date hiredate, Double sal) {
        this.empno = empno;
        this.name = name;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}

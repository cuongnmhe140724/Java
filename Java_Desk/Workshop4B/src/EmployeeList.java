
import java.util.*;
import java.io.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Minh Thanh
 */
public class EmployeeList {
    
    ArrayList<Employee> t;

    public EmployeeList() {
        t = new ArrayList<Employee>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void clear() {
        t.clear();
    }

    int searchByCode(String xCode) {
        int n, i;
        Employee x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.code.equals(xCode)) {
                return (i);
            }
        }
        return (-1);
    }

    int size() {
        return (t.size());
    }

    void add(Employee x) {
        int k = searchByCode(x.code);
        if (k >= 0) {
            JOptionPane.showMessageDialog(null, "The code " + x.code + " already exists!");
            return;
        }
        t.add(x);
    }

    void addMany(String[] a, String[] b, String[] c, double[] d,
            double[] e, double[] f) {
        int n;
        n = a.length;
        Employee x;
        for (int i = 0; i < n; i++) {
            x = new Employee(a[i], b[i], c[i], d[i], e[i], f[i]);
            t.add(x);
        }
    }

    Employee get(int i) {
        int n = size();
        if (i < 0 || i >= n) {
            return (null);
        }
        Employee x = (Employee) t.get(i);
        return (x);

    }

    int searchByName(String xName) {
        int n, i;
        Employee x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.name.equals(xName)) {
                return (i);
            }
        }
        return (-1);
    }

    void searchByName(EmployeeList h, String xName) {
        int n, i;
        Employee x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.name.equals(xName)) {
                h.add(new Employee(x.code, x.name, x.sex, x.salary, x.bonus, x.income));
            }
        }
    }

    // tim gan giong
    void searchByNameRel(EmployeeList h, String xName) {
        int n, i;
        Employee x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.name.indexOf(xName) >= 0) {
                h.add(new Employee(x.code, x.name, x.sex, x.salary, x.bonus, x.income));
            }
        }
    }

    void delete(int i) {
        int n = size();
        if (i < 0 || i >= n - 1) {
            return;
        }
        t.remove(i);
    }

    void delete(String xName) {
        int k = searchByName(xName);
        delete(k);
    }

    void sortByName() {
        Collections.sort(t);
    }
    
    void inputFromFile(String fname){
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            if (f == null) {
                return;
            }
            String s;
            String[] a;
            String xCode, xName,xSex;
            double xSal, xBonus,xIncome;
            while (true) {
                s = f.readLine();
                if (s == null || s.trim().length() < 6) {
                    break;
                }
                a = s.split("[|]");
                xCode = a[0].trim();
                xName = a[1].trim();
                xSex = a[2].trim();
                xSal = Double.parseDouble(a[3].trim());
                xBonus =Double.parseDouble(a[4].trim());
                xIncome = Double.parseDouble(a[5].trim());
                add(new Employee(xCode, xName, xSex, xSal, xBonus, xIncome));
            }
            f.close();

        } catch (Exception e) {
        }
    }

}

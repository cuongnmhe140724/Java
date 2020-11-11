/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh Thanh
 */
public class EmpNode {

    Employee employee;
    EmpNode next;

    public EmpNode() {
    }

    public EmpNode(EmpNode next, Employee employee) {
        this.employee = employee;
        this.next = next;
    }
}

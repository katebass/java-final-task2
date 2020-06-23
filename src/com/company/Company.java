package com.company;

import java.util.ArrayList;

/**
 * @author Kateryna Basova KHNUE
 * @version 23 of June 2020
 * Classname Company
 *
 * 1. Create a test set of companies in your main class.
 * 2. Take for this set IT-companies: Chief, Lawyer, Developer (Design, Front-end, Back-end, DevOps). See attch.
 * 3. Take into account 4 different cases for a company (on-top, on bottom, in the node, out of chain)
 * 4. Test all this cases in your main class.
 * 5. Implement the interface in a class CompanyService.
 *
 **/
public class Company {
    // parent for this company nullable, when there is no parent for this company
    private String name;
    private Company parent;
    private long employeesCount;
    private ArrayList<Company> children;

    // constructor with parameters
    public Company(String name, Company parent, long employeesCount) {
        this.name = name;
        this.parent = parent;
        this.employeesCount = employeesCount;
        this.children = new ArrayList<>(); // new company doesn't have children

        // if this company has parent, add it to parent's children list
        if (parent != null) {
            ArrayList<Company> el = new ArrayList<Company>(parent.getChildren());
            el.add(this);
            parent.setChildren(el);
        }
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Company> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Company> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Company{" +
                "parent=" + parent +
                ", name='" + name + '\'' +
                ", employeesCount=" + employeesCount +
                '}';
    }
}
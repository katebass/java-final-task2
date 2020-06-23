package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kateryna Basova KHNUE
 * @version 23 of June 2020
 * Classname Main
 * The main class where all actions will be executed
 *
 * 1. Create a test set of companies in your main class.
 * 2. Take for this set IT-companies: Chief, Lawyer, Developer (Design, Front-end, Back-end, DevOps). See attch.
 * 3. Take into account 4 different cases for a company (on-top, on bottom, in the node, out of chain)
 * 4. Test all this cases in your main class.
 * 5. Implement the interface in a class CompanyService.
 *
 **/
public class Main {

    public static void main(String[] args) {

        CompanyServiceImpl service = new CompanyServiceImpl();

        // create Company objects
        Company cheif = new Company("cheif", null, 50);
        Company accounting = new Company("accounting", null, 30);
        Company lawyer = new Company("lawyer", cheif, 20);
        Company developer = new Company("developer", cheif, 5);
        Company backEnd = new Company("backEnd", developer, 4);
        Company frontEnd = new Company("frontEnd", developer, 4);
        Company devOps = new Company("devOps", backEnd, 2);
        Company design = new Company("design", frontEnd, 2);

        // add all companies to ArrayList
        List<Company> companies = new ArrayList<>(
                Arrays.asList(
                        cheif,
                        accounting,
                        lawyer,
                        developer,
                        backEnd,
                        frontEnd,
                        devOps,
                        design
                )
        );

        System.out.println("All existing companies: ");
        for (Company company : companies) {
            System.out.println(company.getName());
        }

        // define Designer top level parent
        String designTopLevelParent = service.getTopLevelParent(design).getName();
        System.out.println("Designer top level parent: " + designTopLevelParent);

        // define Designer top level parent
        String lawyerTopLevelParent = service.getTopLevelParent(lawyer).getName();
        System.out.println("Lawyer top level parent: " + lawyerTopLevelParent);

        // define Accounting top level parent
        String accountingTopLevelParent = service.getTopLevelParent(accounting).getName();
        System.out.println("Accounting top level parent: " + accountingTopLevelParent);

        // define employee count for developer and all its children
        long EmployeesCount = service.getEmployeeCountForCompanyAndChildren(developer, companies);
        System.out.println("Employees Amount for developer and all its children: " + EmployeesCount);

        // define employee count for developer and all its children
        long EmployeesCount2 = service.getEmployeeCountForCompanyAndChildren(cheif, companies);
        System.out.println("Employees Amount for cheif and all its children: " + EmployeesCount2);


    }
}

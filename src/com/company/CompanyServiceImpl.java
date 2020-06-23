package com.company;

import java.util.List;

/**
 * @author Kateryna Basova KHNUE
 * @version 23 of June 2020
 * Classname CompanyServiceImpl
 *
 * Curent service class implements interface CompanyService methods.
 *
 **/

public class CompanyServiceImpl implements ICompanyService {
    /**
     * @param child - company for which we are searching the top level parent
     *                  (parent of parent of ...)
     * @return top level paren
     */
    @Override
    public Company getTopLevelParent(Company child) {
        // if company has parent, then its not a top level parent
        // if company parent is null then it's a top level parent
        while (child.getParent() != null) {
            child = child.getParent(); // go to the next top level parent
        }
        return child;
    }

    /**
     * @param company  - company for which we are searching the count of employees
     *                 (count of this company employees +
     *                 count employees of all children and their children employees )
     * @param companies  - list of all available companies
     *
     * @return count of employees
     */
    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        // add employees count to total counter
        long count = company.getEmployeesCount();

        // get current company's children to count their employees
        List<Company> children = company.getChildren();

        // while there is children left
        while (children.size() != 0) {
            // get first child in the list
            Company currentChild = children.get(0);
            // if current child has children
            if (currentChild.getChildren().size() > 0) {
                // add companies to children list for future processing
                children.addAll(currentChild.getChildren());
            }
            // sum current child employees count
            count += currentChild.getEmployeesCount();
            // remove child form the list because
            // it's employees count count was already added to counter
            children.remove(currentChild);
        }
        // return counted value
        return count;
    }
}

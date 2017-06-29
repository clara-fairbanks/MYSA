/*******************
 * Program Name: MySA
 * Program Purpose: To create a comprehensive budget and savings plan for students
 * Created by Clara Fairbanks
 * Last update: 12/08/2014
 */


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class MySAGui extends JFrame {

    //1st Panel Components:
    private JPanel welcomePan, mysaIntro;
    private JLabel acName, mysa1, instruction1, instruction2;
    private JTextField sName;
    private JButton nextPan1;

    //2nd Panel, Income Components
    private JPanel incomePanel,  inFeilds,  totalPanel;
    private JLabel enterIncome, work, finAid, parents, loans, other, totalAmount;
    private JTextField workAm, finAidAm, parentsAm, loanAm, otherAm, totalIn;
    private JButton nextPan2;

    //3rd Panel, Expenses Components
    private JPanel expensesPanel, inFeildsEx, totalPan;
    private JLabel enterExpenses, rent, utilities, phone, transportation, otherEx, totalExpenses;
    private JTextField rentAm, utilitiesAm, phoneAm, transportantAm, otherExAm, totalEx;
    private JButton nextPan3;

    //4th Panel, Savings Components
    private JPanel savingsPanel, saveIntroPan, savingOptionsPan;
    private JLabel savingIntro, savingExpl, level1Des, level2Des, level3Des;
    private JRadioButton level1, level2, level3;
    private JButton nextpan4;

    //5th Panel, Budget Components:
    private JPanel budgetPanel, compare, moneyManage, dailyPan,  weeklyPan, savingsPan;
    //compare panel elements;
    private JLabel income, incomeL, expenses, expensesL, difference, differenceL;
    private JButton savePlan, restart;
    private JButton getBudgetTips;


    //moneyManage elements:
    private JLabel explain, explain2, weekly, weeklyHead, daily, dailyHead, savingHead, save;
    String amount;


    //Account Info Variables
    private double totalMonthlyIncome;
    private double totalMonthlyExpenses;
    private double savingsLevel;
    private double savingsAmmount = totalMonthlyIncome*savingsLevel;
    private double diff;
    private double finalDiff;

    //style
    private Font totalFont = new Font("Party LET", Font.BOLD,80);
    private Font infofont = new Font("Serif", Font.ITALIC, 40);
    private Font subfont = new Font("Serif", Font.ITALIC, 20);
    private Font enterFeildFont = new Font("Sans-Serif", Font.BOLD, 20);
    private Border padding = BorderFactory.createEmptyBorder(10, 20, 30, 5);


    public MySAGui(){

        setSize((int)(1000),350);
        setTitle("MySA");

        welcomePanel();

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void welcomePanel() {
        welcomePan = new JPanel();
        welcomePan.setBorder(padding);
        welcomePan.setLayout(new GridLayout(5, 1));

        mysaIntro = new JPanel();
        mysaIntro.setLayout(new BorderLayout());
        acName = new JLabel("Hi, I'm MySA");

        acName.setFont(infofont);
        mysa1 = new JLabel("    a personalized student budget and savings planner!");
        mysa1.setFont(subfont);
        mysaIntro.add(acName, BorderLayout.NORTH);
        mysaIntro.add(mysa1, BorderLayout.SOUTH);
        welcomePan.add(mysaIntro);

        JPanel getNm = new JPanel();
        JLabel getName= new JLabel("Whats your name?");
        getName.setFont(infofont);
        getNm.add(getName);
        sName = new JTextField(15);
        sName.addActionListener(new pan1FeildListener());
        getNm.add(sName);
        welcomePan.add(getNm);

        instruction1 = new JLabel("");
        instruction1.setFont(subfont);
        welcomePan.add(instruction1);


        JPanel butPanel = new JPanel();
        nextPan1 = new JButton("next");
        nextPan1.addActionListener(new buttonListener());
        butPanel.add(nextPan1);
        welcomePan.add(butPanel, BorderLayout.SOUTH);

        add(welcomePan);

    }

    //creates all components for income panel
    private void createIncomePanel(){
        incomePanel = new JPanel();
        incomePanel.setLayout(new BorderLayout());
        incomePanel.setBorder(padding);

        enterIncome = new JLabel("Enter all sources of MONTHLY income below");
        enterIncome.setBorder(padding);
        enterIncome.setFont(infofont);
        incomePanel.add(enterIncome, BorderLayout.NORTH);

        inFeilds = new JPanel(new GridLayout(5,2));

        work = new JLabel("Work");
        work.setFont(enterFeildFont);
        workAm = new JTextField(8);
        workAm.addActionListener(new pan2FeildListener());
        inFeilds.add(work);
        inFeilds.add(workAm);

        finAid = new JLabel("Financial Aid");
        finAid.setFont(enterFeildFont);
        finAidAm = new JTextField(8);
        finAidAm.addActionListener(new pan2FeildListener());
        inFeilds.add(finAid);
        inFeilds.add(finAidAm);

        parents = new JLabel("Parents");
        parents.setFont(enterFeildFont);
        parentsAm = new JTextField(8);
        parentsAm.addActionListener(new pan2FeildListener());
        inFeilds.add(parents);
        inFeilds.add(parentsAm);

        loans = new JLabel("Loans");
        loans.setFont(enterFeildFont);
        loanAm = new JTextField(8);
        loanAm.addActionListener(new pan2FeildListener());
        inFeilds.add(loans);
        inFeilds.add(loanAm);

        other = new JLabel("Other");
        other.setFont(enterFeildFont);
        otherAm = new JTextField(8);
        otherAm.addActionListener(new pan2FeildListener());
        inFeilds.add(other);
        inFeilds.add(otherAm);

        totalPanel = new JPanel();
        totalPanel.setLayout(new BorderLayout());
        totalAmount = new JLabel("Total Montly income: ");
        totalAmount.setFont(enterFeildFont);
        totalIn = new JTextField(6);
        totalIn.setFont(totalFont);
        totalIn.setEditable(false);
        totalPanel.add(totalAmount, BorderLayout.NORTH);
        totalPanel.add(totalIn, BorderLayout.CENTER);

        JPanel butPanel = new JPanel();
        nextPan2 = new JButton("Next");
        nextPan2.addActionListener(new buttonListener());
        butPanel.add(nextPan2);
        incomePanel.add(inFeilds, BorderLayout.WEST);
        incomePanel.add(butPanel, BorderLayout.SOUTH);
        incomePanel.add(totalPanel, BorderLayout.EAST);


        add(incomePanel, BorderLayout.CENTER);

    }

    //creates expenses panel
    private void createExpensesPanel(){
        expensesPanel = new JPanel();
        expensesPanel.setLayout(new BorderLayout());
        enterExpenses = new JLabel("Great! Now enter all monthly expenses below");
        enterExpenses.setBorder(padding);
        enterExpenses.setFont(infofont);
        expensesPanel.add(enterExpenses, BorderLayout.NORTH);

        inFeildsEx = new JPanel(new GridLayout(5,2));

        rent = new JLabel("Rent:");
        rent.setFont(enterFeildFont);
        rentAm = new JTextField(8);
        rentAm.addActionListener(new pan3FeildListener());
        inFeildsEx.add(rent);
        inFeildsEx.add(rentAm);

        utilities = new JLabel("Utilities");
        utilities.setFont(enterFeildFont);
        utilitiesAm = new JTextField(5);
        utilitiesAm.addActionListener(new pan3FeildListener());
        inFeildsEx.add(utilities);
        inFeildsEx.add(utilitiesAm);

        phone = new JLabel("Phone");
        phone.setFont(enterFeildFont);
        phoneAm= new JTextField(8);
        phoneAm.addActionListener(new pan3FeildListener());
        inFeildsEx.add(phone);
        inFeildsEx.add(phoneAm);

        transportation = new JLabel("Transportation");
        transportation.setFont(enterFeildFont);
        transportantAm= new JTextField(8);
        transportantAm.addActionListener(new pan3FeildListener());
        inFeildsEx.add(transportation);
        inFeildsEx.add(transportantAm);

        otherEx = new JLabel("Other");
        otherEx.setFont(enterFeildFont);
        otherExAm = new JTextField(8);
        otherExAm.addActionListener(new pan3FeildListener());
        inFeildsEx.add(otherEx);
        inFeildsEx.add(otherExAm);

        totalPan = new JPanel();
        totalPan.setLayout(new BorderLayout());
        totalExpenses = new JLabel("Total Monthly expenses:");
        totalExpenses.setFont(enterFeildFont);
        totalEx = new JTextField(5);
        totalEx.setFont(totalFont);
        totalEx.setEditable(false);
        totalPan.add(totalExpenses, BorderLayout.NORTH);
        totalPan.add(totalEx, BorderLayout.CENTER);

        JPanel butPanel = new JPanel();
        nextPan3 = new JButton("Next");
        nextPan3.addActionListener(new buttonListener());
        butPanel.add(nextPan3);
        expensesPanel.add(inFeildsEx, BorderLayout.WEST);
        expensesPanel.add(butPanel, BorderLayout.SOUTH);
        expensesPanel.add(totalPan, BorderLayout.EAST);


        add(expensesPanel, BorderLayout.CENTER);

    }

    //creates all components for savings panel
    private void createSavingsPanel(){

        savingsPanel = new JPanel();
        savingsPanel.setLayout(new BorderLayout());
        savingsPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,5));

        saveIntroPan = new JPanel();
        saveIntroPan.setLayout(new GridLayout(2,1));
        savingIntro = new JLabel("The first step to success with money is saving!");
        savingIntro.setFont(infofont);
        savingExpl = new JLabel("Choose the level of savings you want to commit to");
        savingExpl.setFont(subfont);
        saveIntroPan.add(savingIntro);
        saveIntroPan.add(savingExpl);

        savingOptionsPan = new JPanel();
        savingOptionsPan.setLayout(new GridLayout(3,2));

        ButtonGroup saveOpts = new ButtonGroup();

        level1 = new JRadioButton("Level 1");
        level1.setFont(enterFeildFont);
        level1.addActionListener(new buttonListener());
        saveOpts.add(level1);
        savingOptionsPan.add(level1);

        level1Des = new JLabel("5%");
        level1Des.setFont(totalFont);
        savingOptionsPan.add(level1Des);

        level2 = new JRadioButton("Level 2");
        level2.setFont(enterFeildFont);
        level2.addActionListener(new buttonListener());
        saveOpts.add(level2);
        savingOptionsPan.add(level2);

        level2Des = new JLabel("10%");
        level2Des.setFont(totalFont);
        savingOptionsPan.add(level2Des);

        level3 = new JRadioButton("Level 3");
        level3.setFont(enterFeildFont);
        level3.addActionListener(new buttonListener());
        saveOpts.add(level3);
        savingOptionsPan.add(level3);

        level3Des = new JLabel("15%");
        level3Des.setFont(totalFont);
        savingOptionsPan.add(level3Des);

        JPanel butPanel = new JPanel();
        nextpan4 = new JButton("next");
        nextpan4.addActionListener(new buttonListener());
        butPanel.add(nextpan4);

        savingsPanel.add(saveIntroPan, BorderLayout.NORTH);
        savingsPanel.add(savingOptionsPan, BorderLayout.CENTER);
        savingsPanel.add(butPanel, BorderLayout.SOUTH);

        add(savingsPanel);

    }

    //creates budget panel
    private void createBudgetPanel(){

        diff = (totalMonthlyIncome-totalMonthlyExpenses-totalMonthlyIncome*savingsLevel);

        budgetPanel = new JPanel();
        budgetPanel.setLayout(new BorderLayout());

        compare = new JPanel();
        compare.setLayout(new GridLayout(2, 3));
        compare.setBorder(BorderFactory.createTitledBorder("Results"));

        incomeL = new JLabel("                  Income ++");
        incomeL.setFont(subfont);
        income = new JLabel("           "+String.valueOf(totalMonthlyIncome));
        income.setFont(enterFeildFont);

        differenceL = new JLabel("      Available $$");
        differenceL.setFont(subfont);
        difference = new JLabel("       "+String.valueOf(diff));
        difference.setFont(enterFeildFont);

        expensesL = new JLabel("        Expenses --");
        expensesL.setFont(subfont);
        expenses = new JLabel("     $"+String.valueOf(totalMonthlyExpenses));
        expenses.setFont(enterFeildFont);

        compare.add(incomeL);
        compare.add(differenceL);
        compare.add(expensesL);
        compare.add(income);
        compare.add(difference);
        compare.add(expenses);
        budgetPanel.add(compare, BorderLayout.NORTH);

        moneyManage = new JPanel();
        moneyManage.setLayout(new GridLayout(1,3));

        weeklyPan = new JPanel();
        weeklyPan.setBorder(BorderFactory.createLineBorder(Color.black));
        weeklyPan.setLayout(new GridLayout(2,1));
        weeklyHead= new JLabel("Weekly Allowance  ");
        weeklyHead.setFont(subfont);
        weeklyPan.add(weeklyHead);
        weekly = new JLabel("$"+String.valueOf(diff*.25));
        weekly.setFont(totalFont);
        weeklyPan.add(weekly);
        moneyManage.add(weeklyPan);

        dailyPan = new JPanel();
        dailyPan.setBorder(BorderFactory.createLineBorder(Color.black));
        dailyPan.setLayout(new GridLayout(2,1));
        dailyHead = new JLabel("   Daily Allowance");
        dailyHead.setFont(subfont);
        dailyPan.add(dailyHead);
        daily = new JLabel("$"+String.valueOf(diff*.03));
        daily.setFont(totalFont);
        dailyPan.add(daily);
        moneyManage.add(dailyPan, BorderLayout.CENTER);

        savingsPan = new JPanel();
        savingsPan.setBorder(BorderFactory.createLineBorder(Color.black));
        savingsPan.setLayout(new GridLayout(2,1));
        savingHead = new JLabel("Monthly Savings");
        savingHead.setFont(subfont);
        savingsPan.add(savingHead);
        save = new JLabel("$"+String.valueOf(totalMonthlyIncome*savingsLevel));
        save.setFont(totalFont);
        savingsPan.add(save);
        moneyManage.add(savingsPan, BorderLayout.WEST);

        JPanel buttonPan = new JPanel();
        savePlan = new JButton("Save Plan");
        savePlan.addActionListener(new buttonListener());
        getBudgetTips = new JButton("Get Money Tips!");
        getBudgetTips.addActionListener(new buttonListener());
        restart = new JButton("Start Over");
        restart.addActionListener(new buttonListener());
        buttonPan.add(getBudgetTips);
        buttonPan.add(savePlan);
        buttonPan.add(restart);
        budgetPanel.add(buttonPan, BorderLayout.SOUTH);

        budgetPanel.add(moneyManage, BorderLayout.CENTER);
        add(budgetPanel);

    }

    //Handles all welcome panel events
    private class pan1FeildListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sName) {

                instruction1.setText("          Hi " + sName.getText() +
                        "! I am going to help you organize your finances...");
                instruction2.setText("          Lets start by making a budget  :D");
            }
        }
    }

    //accumulates income
    private void accumulate(String a){
        double amt = Double.parseDouble(a);
        totalMonthlyIncome += amt;
        totalIn.setText(String.valueOf(totalMonthlyIncome));
    }

    //handles all income events
    private class pan2FeildListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()== workAm){
                String amount = workAm.getText();
                accumulate(amount);
            } else if (e.getSource() == parentsAm) {
                String amount = parentsAm.getText();
                accumulate(amount);
            } else if (e.getSource() == loanAm) {
                String amount = loanAm.getText();
                accumulate(amount);
            } else if (e.getSource() == finAidAm) {
                String amount = finAidAm.getText();
                accumulate(amount);
            } else {
                String amount = otherAm.getText();
                accumulate(amount);
            }

        }
    }

    //accumulates expenses
    private void accumulateExp(String a){
        double amt = Double.parseDouble(a);
        totalMonthlyExpenses += amt;
        totalEx.setText(String.valueOf(totalMonthlyExpenses));
    }

    //handles all expenses panel events
    private class pan3FeildListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getSource() == rentAm) {
                    String amount = rentAm.getText();
                    accumulateExp(amount);

                } else if (e.getSource() == utilitiesAm) {
                    String amount = utilitiesAm.getText();
                    accumulateExp(amount);

                } else if (e.getSource() == phoneAm) {
                    String amount = phoneAm.getText();
                    accumulateExp(amount);

                } else if (e.getSource() == transportantAm) {
                    String amount = transportantAm.getText();
                    accumulateExp(amount);
                } else {
                    String amount = otherExAm.getText();
                    accumulateExp(amount);
                }
            }
    }

    //handles all button eventss
    private class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //Moves from welcom panel to income panel
            if (e.getSource() == nextPan1) {
                welcomePan.setVisible(false);
                createIncomePanel();
            }
            //Hides income panel, shows expenses panel
            if (e.getSource() == nextPan2){
                incomePanel.setVisible(false);
                createExpensesPanel();
            }
            //Hides expenses panel, shows savings panel
            if(e.getSource() == nextPan3){
                expensesPanel.setVisible(false);
                createSavingsPanel();
            }

            //Selects savings level, calcualtes savings ammount, subtracts from available funds
            if(level1.isSelected()){
                savingsLevel = .05;
                savingsAmmount = totalMonthlyIncome*.05;
                finalDiff = diff-savingsAmmount;
            }
            else if(level2.isSelected()){
                savingsLevel = .1;
                savingsAmmount = totalMonthlyIncome*.1;
                finalDiff = diff-savingsAmmount;
            }
            else{
                savingsLevel = .15;
                savingsAmmount = totalMonthlyIncome*.15;
                finalDiff = diff-savingsAmmount;
            }

            //Hides savings panel, moves to budget panel
            if(e.getSource()==nextpan4){
                savingsPanel.setVisible(false);
                createBudgetPanel();
            }
            //Creates a text file, writes budget plan to text file
            if(e.getSource()== savePlan){
                try {
                    File aptFile = new File("MySavingsPlan.txt");
                    PrintWriter write = new PrintWriter(aptFile);
                    write.println("Monthly Income : "+ totalMonthlyIncome);
                    write.println("Monthly Expenses : "+ totalMonthlyExpenses);
                    write.println("Monthly Savings Goal : "+ totalMonthlyIncome*savingsLevel);
                    write.println("Daily Allowance : " + ((finalDiff)*.03));
                    write.println("Weekly Allowance : " + ((finalDiff)*.4));
                    write.println("Congratulations "+ sName.getText()+ "!! You have made a budget!  Now get back to your homework!");

                    write.close();
                    JOptionPane.showMessageDialog(null, "Your savings plan has been saved in a file named MySavingsPlan.txt");

                }
                catch (FileNotFoundException ex)
                {
                    System.out.println("File not found.");
                }
            }
            if(e.getSource()== restart){
                budgetPanel.setVisible(false);
                welcomePanel();
                totalMonthlyIncome = 0;
                totalMonthlyExpenses= 0;

            }
            //calls from array of budget tips and selects one at random
            if(e.getSource()== getBudgetTips){

                Random rand = new Random();
                int randElement = rand.nextInt(15);
                BudgetTips getAtip = new BudgetTips(randElement);

            }
        }
    }
}
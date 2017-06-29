import javax.swing.*;

/**
 * Created by clarafairbanks on 12/12/16.
 */
public class BudgetTips {

    public BudgetTips(int randTip) {

        String[] tips = new String[20];
        tips[0] = "Take out enough cash to last one week at a time. " +
                "\nMake up your mind that the cash you have is all you get for discretionary expenses, " +
                "\nor things that you could live without, each week. It's much easier to turn down " +
                "\na $60 pair of shoes when it will take the last of your week's cash than it is when you " +
                "\njust have to swipe a credit card.";
        tips[1] = "If you have credit card debt, you may feel like it's going to take forever to pay it off. " +
                "\nBut you can get ahead by choosing one card -- ideally, the one with the highest interest " +
                "\nrate -- and paying as much as you can on it every month. If you have other cards, pay the " +
                "\nminimum balance on those until you've paid off the first card. Then, choose the next card " +
                "\nand pay extra on it while you pay minimums on the others. If you pay only the minimums on " +
                "\nall your cards, you'll be paying a lot more in interest than you may realize.";
        tips[2] = "If you have credit card debt, you may feel like it's going to take forever to pay it off. " +
                "\nBut you can get ahead by choosing one card -- ideally, the one with the highest interest " +
                "\nrate -- and paying as much as you can on it every month. If you have other cards, pay the " +
                "\nminimum balance on those until you've paid off the first card. Then, choose the next card " +
                "\nand pay extra on it while you pay minimums on the others. If you pay only the minimums on " +
                "\nall your cards, you'll be paying a lot more in interest than you may realize.";
        tips[3] = "If you find that you keep reaching into your savings, set up a CD or other account with early " +
                "\nwithdrawal penalties. Banks and other institutions pay more interest if you'll agree to let " +
                "\nthem use your money for a longer amount of time. Putting your savings into a yearly CD will " +
                "\nyield more than a three-month note would.";
        tips[4] = "Remember that life is unpredictable, and things happen that are out of our control. When" +
                "\nyou make a budget, try to allow some extra money for variable expenses. And, be gentle with " +
                "\nyourself if you go over your budget sometimes. It can be hard to get back on track if you " +
                "\nlet yourself get too frustrated over a mistake or two.";
        tips[5] = "Save your loose change. Putting aside fifty cents a day over the course of a " +
                "\nyear will allow you to save nearly 40% of a $500 emergency fund.";
        tips[6] = "Think over each expensive purchase for at least 24 hours. Acting on this principle " +
                "\nwill mean you have far fewer regrets about impulse purchases, and far more money for " +
                "\nemergency savings.";
        tips[7] = "Most people don’t track what they spend and may not realize when expenses add up to " +
                "\nmore than their budget can handle. To keep track of what you spend, put what you think " +
                "\nyou should spend for the month on transportation, food, entertainment, etc., into envelopes. " +
                "\nThis will help you avoid buying things you don’t need, and what’s left over can go into saving.";
        tips[8] = "Save money by buying items online, in bulk. Some companies even offer free shipping on " +
                "\nlarge orders. Clearance items are sometimes available, and good savings can be found on " +
                "\nnon-perishable groceries and diapers. This saves time and money!";
        tips[9] ="Substitute coffee for expensive coffee drinks. The $2 a day you could well save by buying a " +
                "\ncoffee rather than a cappuccino or latte would allow you, over the course of a year, to completely " +
                "\nfund a $500 emergency fund.";
        tips[10] = "Bring lunch to work. If buying lunch at work costs $5, but making lunch at home costs only $2.50, " +
                "\nthen in a year, you could afford to create a $500 emergency fund and still have money left over.";
        tips[11]= "Shop for food with a list and stick to it. People who do food shopping with a list, and buy l" +
                "\nittle else, spend much less money than those who decide what to buy when they get to the food market." +
                "\nThe annual savings could easily be hundreds of dollars.";
        tips[12]="Make your monthly credit card payment on time. The $30-35 you save by not being charged a late fee " +
                "\neach month on one card would save you most of the money you need for $500 in emergency savings";
        tips[13]="Use only the ATMs of your bank or credit union. Using the ATM of another financial institution " +
                "\nonce a week could well cost you $3 a withdrawal, or more than $150 over the course of a year.";
        tips[14]= "Assess clothing in terms of quality as well as price. An inexpensive shirt or coat is a " +
                "\npoor bargain if it wears out in less than a year. Consider fabric, stitching, washability, " +
                "\nand other quality related factors in your selection of clothes.";
        tips[15]= "Research free or inexpensive entertainment in your community. Use local newspapers and websites " +
                "\nto learn about free or low-cost parks, museums, film showings, sports events, and other places " +
                "\nwhich you and your family would enjoy.";
        tips[16]= "Borrow books rather than purchasing them. Borrowing books and reading magazines at your local library, " +
                "\nrather than purchasing reading material, can save you hundreds of dollars a year.";


        JOptionPane.showMessageDialog(null, tips[randTip]);
    }

}

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BankAccountHome extends JFrame
{
	ArrayList<BankAccount> bankAccounts;
		
	public BankAccountHome()
	{
		bankAccounts = new ArrayList<BankAccount>();
	
		WelcomePage myPanel = new WelcomePage();
		setBounds(100, 100, 500, 400);
		add(myPanel);
			
		CardLayout cl = new CardLayout();
		JPanel cardHolder = new JPanel();
		cardHolder.setLayout(cl);
		
		JPanel panelHome = new WelcomePage();	
		JPanel panelAdd = new AddAccount(bankAccounts);
		JPanel panelDelete = new DeleteAccount(bankAccounts);
		JPanel panelFind = new FindAccounts(bankAccounts);	
		JPanel panelDeposit = new DepositAmt(bankAccounts);
		JPanel panelWithdraw = new WithdrawAmt(bankAccounts);
		JPanel panelTransfer = new TransferAmt(bankAccounts);
		JPanel panelGetBal = new GetBalance(bankAccounts);
	
		
		cardHolder.add(panelHome, "Home");
		cardHolder.add(panelAdd, "Add Account");
		cardHolder.add(panelFind, "Find Accounts");
		cardHolder.add(panelDelete, "Delete Account");
		cardHolder.add(panelDeposit, "Deposit");
		cardHolder.add(panelWithdraw, "Withdraw");
		cardHolder.add(panelTransfer, "Transfer");
		cardHolder.add(panelGetBal, "Get Balance");
		
		JMenuBar mBar = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenuItem mHome = new JMenuItem("Home");
		mBar.add(mFile);
		mFile.add(mHome);		
		
		JMenu mAccount = new JMenu("Accounts");
		JMenuItem addAccount = new JMenuItem("Add Account");
		JMenuItem deleteAccount = new JMenuItem("Delete Account");
		JMenuItem findAccount = new JMenuItem("Find Accounts");
		JMenuItem getBalance = new JMenuItem("Get Balance");
		mBar.add(mAccount);
		mAccount.add(addAccount);
		mAccount.add(deleteAccount);
		mAccount.add(findAccount);
		mAccount.add(getBalance);
		
		JMenu mTransactions = new JMenu("Transaction");
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdraw = new JMenuItem("Withdraw");
		JMenuItem transfer = new JMenuItem("Transfer");
		
		mBar.add(mTransactions);
		mTransactions.add(deposit);
		mTransactions.add(withdraw);
		mTransactions.add(transfer);
		
		
		
		this.setJMenuBar(mBar);
		
		mHome.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Home");
			}
	
		});
		
		addAccount.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Add Account");
			}
	
		});
		
		deleteAccount.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Delete Account");
			}
	
		});
		
		findAccount.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Find Accounts");
			}
	
		});
		
		deposit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Deposit");
			}
	
		});
		
		withdraw.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Withdraw");
			}
	
		});
		
		transfer.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Transfer");
			}
	
		});
		
		getBalance.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				cl.show(cardHolder, "Get Balance");
			}
	
		});
		
		
		cl.show(cardHolder, "Home");
		add(cardHolder);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new BankAccountHome();

	}

}

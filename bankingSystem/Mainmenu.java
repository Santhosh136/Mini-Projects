package bankingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Mainmenu {

	private JFrame frmBankManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu window = new Mainmenu();
					window.frmBankManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the application.
	 */
	public Mainmenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankManagementSystem = new JFrame();
		frmBankManagementSystem.setType(Type.POPUP);
		frmBankManagementSystem.setTitle("Banking Management System - Menu");
		frmBankManagementSystem.setBounds(100, 100, 926, 623);
		frmBankManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankManagementSystem.getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.activeCaption);
		panel1.setBounds(0, 24, 1122, 637);
		frmBankManagementSystem.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\elcot\\Pictures\\banking.jpg"));
		label.setBounds(30, 0, 880, 562);
		//panel1.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1122, 23);
		frmBankManagementSystem.getContentPane().add(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmCustomer = new JMenuItem("Customer");
		mntmCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerPage cus = new CustomerPage();
				panel1.add(cus);
				cus.setVisible(true);
			}
		});
		mnNew.add(mntmCustomer);
		
		JMenuItem mntmAccount = new JMenuItem("Account");
		mntmAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountPage acc = new AccountPage();
				panel1.add(acc);
				acc.setVisible(true);
			}
		});
		mnNew.add(mntmAccount);
		
		JMenu mnTransaction = new JMenu("Transaction");
		menuBar.add(mnTransaction);
		
		JMenuItem mntmWithdraw = new JMenuItem("Withdraw");
		mntmWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WithdrawPage wdr = new WithdrawPage();
				panel1.add(wdr);
				wdr.setVisible(true);
			}
		});
		mnTransaction.add(mntmWithdraw);
		
		JMenuItem mntmDeposit = new JMenuItem("Deposit");
		mntmDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepositPage dep = new DepositPage();
				panel1.add(dep);
				dep.setVisible(true);
			}
		});
		mnTransaction.add(mntmDeposit);
		
		JMenu mnBalance = new JMenu("Balance");
		menuBar.add(mnBalance);
		
		JMenuItem mntmBalanceCheck = new JMenuItem("Balance Check");
		mntmBalanceCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalancePage bal = new BalancePage();
				panel1.add(bal);
				bal.setVisible(true);
			}
		});
		mnBalance.add(mntmBalanceCheck);
		
		JMenu mnExit = new JMenu("Exit");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		menuBar.add(mnExit);
		
		JMenuItem mntmExitTheApplication = new JMenuItem("Exit the Application");
		mntmExitTheApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBankManagementSystem.setVisible(false);
			}
		});
		mnExit.add(mntmExitTheApplication);
		
		
	}
}

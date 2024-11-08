package com.demo;

import java.util.List;
import java.util.Scanner;

import com.demo.DAO.AdminDAO;
import com.demo.DAO.BillDAO;
import com.demo.DAO.CustomerDAO;
import com.demo.DAO.PaymentDAO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomerDAO customerDAO = new CustomerDAO();
		BillDAO billDAO = new BillDAO();
		AdminDAO adminDAO = new AdminDAO();
		PaymentDAO paymentDAO = new PaymentDAO();

		while (true) {
			System.out.println("Electricity Bill Management System");
			System.out.println("1. Add Admin");
			System.out.println("2. View Admin By Id");
			System.out.println("3. View Admin Full List");
			System.out.println("4. Update Admin");
			System.out.println("5. Delete Admin");
			System.out.println("6. Add Customer");
			System.out.println("7. View Customer By Id");
			System.out.println("8.  Update Customer");
			System.out.println("9. Delete Customer");
			System.out.println("10. View Customer Full List");
			System.out.println("11. Add Bill");
			System.out.println("12. View Bill");
			System.out.println("13. Add Payment");
			System.out.println("14. retrieve Payment Details");
			System.out.println("15. Please Enter Your Choice");

			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {

			case 1:
				// Add Admin
				System.out.println("Enter the Admin UserName: ");
				String username = scanner.nextLine();

				System.out.println("Enter the password : ");
				String password = scanner.nextLine();

				Admin admin = new Admin();
				admin.setUsername(username);
				admin.setPassword(password);
				adminDAO.saveAdmin(admin);

				System.out.println("Admin added successfully: ");
				break;

			case 2:
				// View Admin By Id
				System.out.println("Enter Admin ID: ");
				int adminid = scanner.nextInt();

				Admin retrieveadmin = adminDAO.getAdmin(adminid);
				System.out.println("Admin Id: " + retrieveadmin.getId() + " UserName :" + retrieveadmin.getUsername());
				break;

			case 3:
				// View Admin Full List

				List<Admin> admins = adminDAO.getAllAdmins();
				System.out.println("All Admins:");
				for (Admin ad : admins) {
					System.out.println("ID: " + ad.getId() + ", Username: " + ad.getUsername());
				}
				break;

			case 4:
				// Update Admin
				System.out.println("Enter Admin ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				Admin updateAdmin = adminDAO.getAdmin(updateId);
				System.out.println("enter the new username: ");
				updateAdmin.setUsername(scanner.nextLine());
				System.out.println("enter the new password: ");
				updateAdmin.setPassword(scanner.nextLine());
				adminDAO.updateAdmin(updateAdmin);
				System.out.println("Admin Record Updated Successfully: ");
				break;

			case 5:
				// Delete Admin
				System.out.println("enter the Admin Id to delete : ");
				int deleteId = scanner.nextInt();
				adminDAO.deleteAdmin(deleteId);

				System.out.println("Admin deleted successfully!");
				break;

			case 6:
				// Add Customer
				System.out.println("Enter customer name: ");

				String name = scanner.nextLine();
				scanner.nextLine();

				System.out.println("Enter customer address: ");
				String address = scanner.nextLine();

				System.out.println("Enter phone number: ");
				String phoneNumber = scanner.nextLine();

				Customer customer = new Customer();
				customer.setName(name);
				customer.setAddress(address);
				customer.setPhoneNumber(phoneNumber);
				customerDAO.saveCustomer(customer);
				System.out.println("Customer added successfully!");
				break;

			case 7:
				// View Customer By Id
				System.out.println("Enter customer ID: ");
				int id = scanner.nextInt();
				Customer retrievedCustomer = customerDAO.getCustomerById(id);
				System.out.println("Customer Name: " + retrievedCustomer.getName() + " Customer Address: "
						+ retrievedCustomer.getAddress() + " Customer Phone Number:"
						+ retrievedCustomer.getPhoneNumber());
				break;

			case 8:
				// Update Customer
				System.out.println("Enter customer ID to update: ");
				int updateIds = scanner.nextInt();
				scanner.nextLine();
				Customer customerToUpdate = customerDAO.getCustomerById(updateIds);
				System.out.println("Enter new name: ");
				customerToUpdate.setName(scanner.nextLine());
				customerDAO.updateCustomer(customerToUpdate);
				System.out.println("Customer updated successfully!");
				break;

			case 9:
				// Delete Customer
				System.out.println("Enter customer ID to delete: ");
				int deleteIds = scanner.nextInt();
				customerDAO.deleteCustomer(deleteIds);
				System.out.println("Customer deleted successfully!");
				break;

			case 10:
				// View Customer Full List
				List<Customer> c = customerDAO.getAllCustomer();
				System.out.println("All Customers:");
				for (Customer cust : c) {
					System.out.println("ID: " + cust.getId() + ", Name: " + cust.getName());
				}
				break;

			case 11:

				// Add Bill
				System.out.println("Enter customer ID for the bill: ");
				int billCustomerId = scanner.nextInt();
				Customer customerForBill = customerDAO.getCustomerById(billCustomerId);
				if (customerForBill == null) {
					System.out.println("Customer not found with ID: " + billCustomerId);
					break;
				}
				System.out.println("Enter bill amount: ");
				double amount = scanner.nextDouble();

				Bill bill = new Bill();
				bill.setCustomer(customerForBill); // Set the Customer object here
				bill.setAmount(amount);
				bill.setBillDate(new java.util.Date());
				billDAO.saveBill(bill);
				System.out.println("Bill added successfully!");
				break;

			case 12:
				// View Bill
				System.out.println("Enter bill ID: ");
				int billId = scanner.nextInt();
				Bill retrievedBill = billDAO.getBillById(billId);
				System.out.println("Bill Amount: " + retrievedBill.getAmount());
				break;

			case 13:
				// Add Payment

				System.out.println("Enter BillId: ");

				int bid = scanner.nextInt();
				scanner.nextLine();
				Bill IdforBill = billDAO.getBillById(bid);

				System.out.println("Enter Bill Amount: ");
				double amt = scanner.nextDouble();

				Payment pay = new Payment();

				pay.setBill(IdforBill);
				pay.setAmount(amt);

				paymentDAO.savePayment(pay);
				System.out.println("Payment added successfully!");
				break;

			case 14:
				// retrieve Payment Details

				System.out.println("Enter Payment ID: ");
				int pid = scanner.nextInt();
				Payment retrievedPayment = paymentDAO.getPaymentById(pid);
				System.out.println("Payment Id: " + retrievedPayment.getId() + "Payment Bill Amount: "
						+ retrievedPayment.getAmount() + " Payment Date: " + retrievedPayment.getPaymentDate());

				break;

			case 15:
				// Exit
				System.out.println("Exiting...");
				scanner.close();
				return;

			default:
				System.out.println("please enter a valid choice");
			}
		}
	}
}
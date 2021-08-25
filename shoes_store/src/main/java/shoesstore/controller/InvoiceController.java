package shoesstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.dao.InvoiceDao;
import shoesstore.entities.Invoice;
import shoesstore.entities.Paging;

@Controller
@RequestMapping("invoice")
public class InvoiceController {
	@Autowired
	private InvoiceDao<Invoice, Integer> invoiceDao;
	@Autowired
	@GetMapping
	public String dafault() {
		return "redirect:list/1";
	}
	@GetMapping("list/{indexPage}")
	public String findAll(@PathVariable("indexPage") int indexPage, Model model) {
		Paging paging = new Paging(indexPage);
		List<Invoice> invoices = invoiceDao.findAll(paging);
		model.addAttribute("listInvoice", invoices);
		model.addAttribute("paging", paging);
		System.out.println(paging);
	
		return "invoice-list";
	}
	@GetMapping("add")
	public String showFormAddInvoice(Model model) {
		model.addAttribute("url", "add");
		return "invoice-form";
	}
	
	@GetMapping("delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		Invoice invoice = invoiceDao.findById(Invoice.class, id);
		invoice.setActiveFlag(0);
		invoiceDao.update(invoice);
		return "redirect:../list/1";
	}
	
//	@GetMapping("detail/{id}")
//	public String findDetailsInvoice(@PathVariable("id") int id, Model model) {
//		List<Import> imports = importDao.findByProperty("invoice.id", id);
//		model.addAttribute("listImport",imports);
//		return "invoice-details";
//	}	
//	
}

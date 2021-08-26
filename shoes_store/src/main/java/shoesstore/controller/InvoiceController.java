package shoesstore.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesstore.dao.ImportDao;
import shoesstore.dao.InvoiceDao;
import shoesstore.dao.ProductDao;
import shoesstore.entities.Import;
import shoesstore.entities.Invoice;
import shoesstore.entities.Paging;
import shoesstore.entities.Product;

@Controller
@RequestMapping("invoice")
public class InvoiceController {
	@Autowired
	private InvoiceDao<Invoice, Integer> invoiceDao;
	@Autowired
	private ImportDao<Import, Integer> importDao;
	@Autowired
	private ProductDao<Product, Integer> productDao;
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
	public String formInvoice(Model model) {
		model.addAttribute("url", "add");
		model.addAttribute("invoice", new Invoice());
		return "invoice-form";
	}
	
	@PostMapping("add")
	public String createInvoice(@ModelAttribute("invoice") Invoice iv, Model model) throws java.text.ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String td = LocalDate.now().toString();
        Date today = sdf.parse(td);
        iv.setDate(today);
		iv.setPrice(0.0);
		iv.setQuantity(0);
		iv.setType(0);
		invoiceDao.insert(iv);
		
		return "redirect:list/1";
        
	}
	@GetMapping("import/{id}")
	public String showImportProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("url", "../import/" + id);
		model.addAttribute("import", new Import());
		List<Import> imports = importDao.findByProperty("invoice.id", id);
		model.addAttribute("listImport",imports);
		return "invoice-import";
	}
	@PostMapping("import/{id}")
	public String importProduct(@PathVariable("id") int id,@ModelAttribute("import") Import ip ,Model model) {
		List<Product> pd = productDao.findByProperty("code", ip.getProduct().getCode());
		Invoice iv = invoiceDao.findById(Invoice.class, id);
		ip.setInvoice(iv);
		ip.setType(1);
		if(pd.size() == 1) {
			pd.get(0).setQuantity(pd.get(0).getQuantity() + ip.getQuantity());
			productDao.update(pd.get(0));
			ip.setProduct(pd.get(0));
		}
		else {
			Product product = new Product();
			product.setCode(ip.getProduct().getCode());
			product.setName(ip.getProduct().getName());
			product.setQuantity(ip.getQuantity());
			productDao.insert(product);
			ip.setProduct(productDao.findByProperty("code", ip.getProduct().getCode()).get(0));
		}
		
		iv.setQuantity(iv.getQuantity() + ip.getQuantity());
		iv.setPrice(iv.getPrice() + ip.getQuantity()*ip.getPrice());
		invoiceDao.update(iv);
		importDao.insert(ip);
		return "redirect:../list/1";
	}	
	
	
	@GetMapping("delete/{id}")
	public String deleteInvoice(@PathVariable("id") int id) {
		Invoice invoice = invoiceDao.findById(Invoice.class, id);
		if(importDao.findByProperty("invoice.id", id).size() == 0) {
			invoiceDao.delete(invoice);
		}
		
		return "redirect:../list/1";
	}
	@GetMapping("editimportup/{id}")
	public String showFormEditUp(@PathVariable("id") int id, Model model) {
		Import imp = importDao.findById(Import.class, id);
		Invoice iv = invoiceDao.findById(Invoice.class, imp.getInvoice().getId());
		imp.setQuantity(imp.getQuantity()+1);
		importDao.update(imp);
		iv.setQuantity(iv.getQuantity()+1);
		iv.setPrice(iv.getPrice() + imp.getPrice());
		invoiceDao.update(iv);
		return "redirect:../import/" + imp.getInvoice().getId();
		
	}
	@GetMapping("editimportdown/{id}")
	public String showFormEditDown(@PathVariable("id") int id, Model model) {
		Import imp = importDao.findById(Import.class, id);
		Invoice iv = invoiceDao.findById(Invoice.class, imp.getInvoice().getId());
		if(imp.getQuantity() > 0) {
			imp.setQuantity(imp.getQuantity()-1);
			importDao.update(imp);
			iv.setQuantity(iv.getQuantity()-1);
			iv.setPrice(iv.getPrice() - imp.getPrice());
			invoiceDao.update(iv);
		}
		if(imp.getQuantity() == 0) {
			importDao.delete(imp);
		}
		return "redirect:../import/" + imp.getInvoice().getId();
	}
	@GetMapping("deleteimport/{id}")
	public String deleteImport(@PathVariable("id") int id) {
		Import imp = importDao.findById(Import.class, id);
		Invoice iv = imp.getInvoice();
		iv.setPrice(iv.getPrice() - imp.getPrice()*imp.getQuantity());
		iv.setQuantity(iv.getQuantity() - imp.getQuantity());
		invoiceDao.update(iv);
		importDao.delete(imp);
		return "redirect:../import/" + iv.getId();
	}
	
}

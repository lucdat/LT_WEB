package shoesstore.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shoesstore.dao.InvoiceDao;
import shoesstore.entities.Invoice;

@Controller
@RequestMapping("statistical_cost")
public class StatisticalController {
	@Autowired
	private InvoiceDao<Invoice, Integer> invoiceDao;

	@GetMapping
	public String test() {
		return "statistical_cost";
	}
	@PostMapping("/list")
	public String showList(@RequestParam("start") Date start, @RequestParam("end") Date end , Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(start);
        String endDate = formatter.format(end);
        
        List<Invoice> l = invoiceDao.statistical(strDate, endDate);
        float sum = 0;
        for (Invoice invoice : l) {
			sum += invoice.getPrice();
		}
        model.addAttribute("list_invoice", l);
        model.addAttribute("sum", formatDecimal(sum));
		return "statistical_end";
	}
	public String formatDecimal(float f) {
        Locale locale = new Locale("vi");
        NumberFormat format =  NumberFormat.getCurrencyInstance(locale);
        return format.format(f) + "VNĐ";
	}
}

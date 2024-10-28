package vn.iotstar.controllers.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vn.iotstar.entity.Category;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
//methods:
	@RequestMapping("")		//de khoang trang thi no hieu la lay cai uri phia tren luon ko truy cap sau hon.
	public String all(Model model) {		//tra model ve cho view
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);		//<=> tuong duong voi lenh req.setAttribute hoi lam ben servlet.
		return "admin/category/list";
	}		//tra ve cai view. (trong thu muc thu muc admin nam trong thu muc view.
	@GetMapping("/add")
	public String add(Model model) {
		CategoryModel category = new CategoryModel();
		
		model.addAttribute("category", category);
		return "admin/category/add";
	}
	@PostMapping("save")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("category") CategoryModel cateModel, BindingResult result) {
			if(result.hasErrors()) {
			return new ModelAndView("admin/category/add");
			}
			Category entity = new Category();
			//copy từ Model sang Entity
			BeanUtils.copyProperties(cateModel, entity);
			//goi hàm save trong service
			categoryService.save(entity);
			//đưa thông báo về cho biến message
			String message= "";
			if(cateModel.getIsEdit() == true) {
			message="Category is Edited! ! ! !!!!! ";

			}else {
			message="Category is saved! ! ! ! ! !!! ";
			}
			model.addAttribute("message",message);
			//redirect ve URL controller
			return new ModelAndView("forward:/admin/categories",model);
	}
	@GetMapping("/edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long categoryId)
	{
		Optional<Category> optCategory = categoryService.findById(categoryId);
		CategoryModel cateModel = new CategoryModel();
		//kiểm tra sự tồn tại của category
		if(optCategory.isPresent()) {
		Category entity = optCategory.get();
		//copy từ entity sang cateModel
		BeanUtils.copyProperties(entity, cateModel);
		cateModel.setIsEdit(true);
		//đẩy dữ liệu ra view
		model.addAttribute("category", cateModel);

		return new ModelAndView("admin/category/add",model);
		}
		model.addAttribute("message","Category is not existed !!!! ");
		return new ModelAndView("forward:/admin/categories",model);
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long categoryId)
	{
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Category is deleted!!!");
		return new ModelAndView("forward:/admin/categories", model);
	}
}

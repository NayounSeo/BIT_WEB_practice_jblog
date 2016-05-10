package com.estsoft.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/insert/{blogNo}", method=RequestMethod.POST)
	public String insertCategory(@PathVariable("blogNo") long blogNo, @ModelAttribute CategoryVo categoryVo ) {
		System.out.println("blogNo가 들어갔을까? category service insert"+categoryVo);
		categoryService.createCategory(categoryVo);
		return "redirect:/blog/managecategory/"+categoryVo.getBlogNo( );
	}
	
	//TODO - 어 왜 여기 POST 쓰면 안돼요..? requestParam으로 가져갈걸 그랬나 ㅇㅅㅇ
	@RequestMapping("/delete/{categoryNo}")
	public String deleteCategory(@PathVariable("categoryNo") long categoryNo) {
		CategoryVo categoryVo = categoryService.getCategory(categoryNo);
		categoryService.deleteCategory(categoryNo);
		return "redirect:/blog/managecategory/"+categoryVo.getBlogNo( );
	}
	
}

package com.example.gatn.Controller.TTByProduct;

import com.example.gatn.Entity.*;
import com.example.gatn.Repositoris.*;
import com.example.gatn.Service.ColorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pdtt")
public class TTCTProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private LaceRepository laceRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private SocklinerRepository socklinerRepository;

    @Autowired
    private SoleRepository soleRepository;

    @GetMapping("/hienthi_product")
    public String getproduct(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Product> list = productRepository.findAll(pageable);
        model.addAttribute("product", list);
        return "qlproduct/qlpro/pro";
    }

    @GetMapping("/hienthi_brand")
    public String getbrand(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Brand> list = brandRepository.findAll(pageable);
        model.addAttribute("brand", list);
        return "qlproduct/qlbrand/ttbrand";
    }

    @GetMapping("/hienthi_category")
    public String getcategory(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Category> list = categoryRepository.findAll(pageable);
        model.addAttribute("category", list);
        return "qlproduct/qlcategory/category";
    }

    @GetMapping("/hienthi_color")
    public String getcolor(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Color> list = colorRepository.findAll(pageable);
        model.addAttribute("color", list);
        return "qlproduct/qlcolor/color";
    }

    @GetMapping("/hienthi_lace")
    public String getlace(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Lace> list = laceRepository.findAll(pageable);
        model.addAttribute("lace", list);
        return "qlproduct/qllace/lace";
    }

    @GetMapping("/hienthi_material")
    public String getmaterial(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Material> list = materialRepository.findAll(pageable);
        model.addAttribute("material", list);
        return "qlproduct/qlmaterial/material";
    }

    @GetMapping("/hienthi_size")
    public String getsize(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Size> list = sizeRepository.findAll(pageable);
        model.addAttribute("size", list);
        return "qlproduct/qlsize/size";
    }

    @GetMapping("/hienthi_sockliner")
    public String getsockliner(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Sockliner> list = socklinerRepository.findAll(pageable);
        model.addAttribute("sockliner", list);
        return "qlproduct/qlsockliner/sockliner";
    }

    @GetMapping("/hienthi_sole")
    public String getsole(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 6);
        Page<Sole> list = soleRepository.findAll(pageable);
        model.addAttribute("sole", list);
        return "qlproduct/qlsole/sole";
    }

//    DETAIL

    @GetMapping("/deatil_product/{id}")
    public String detailProduct(@RequestParam( defaultValue = "0", name = "page") Integer number,
                                @PathVariable("id") String id, Model model){
        Product list = productRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Product> pro = productRepository.findAll(pageable);
        model.addAttribute("product", list);
        model.addAttribute("pro", pro);
        return "qlproduct/qlpro/ctpro";
    }

    @GetMapping("/detail_brand/{id}")
    public String detailbrand(@RequestParam( defaultValue = "0", name = "page") Integer number,
                           @PathVariable("id") String id, Model model){
        Brand list = brandRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Brand> bra = brandRepository.findAll(pageable);
        model.addAttribute("brand", list);
        model.addAttribute("bra", bra);
        return "qlproduct/qlbrand/ctbrand";
    }

    @GetMapping("/detail_category/{id}")
    public String detailcategory(@RequestParam( defaultValue = "0", name = "page") Integer number,
                              @PathVariable("id") String id, Model model){
        Category list = categoryRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Category> cate = categoryRepository.findAll(pageable);
        model.addAttribute("category", list);
        model.addAttribute("cate", cate);
        return "qlproduct/qlcategory/ctcategory";
    }

    @GetMapping("/detail_color/{id}")
    public String detailcolor(@RequestParam( defaultValue = "0", name = "page") Integer number,
                           @PathVariable("id") String id, Model model){
        Color list = colorRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Color> col = colorRepository.findAll(pageable);
        model.addAttribute("color", list);
        model.addAttribute("col", col);
        return "qlproduct/qlcolor/ctcolor";
    }

    @GetMapping("/detail_lace/{id}")
    public String detaillace(@RequestParam( defaultValue = "0", name = "page") Integer number,
                             @PathVariable("id") String id, Model model){
        Lace list = laceRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Lace> lac = laceRepository.findAll(pageable);
        model.addAttribute("lace", list);
        model.addAttribute("lac", lac);
        return "qlproduct/qllace/ctlace";
    }

    @GetMapping("/detail_material/{id}")
    public String detailmaterial(@RequestParam( defaultValue = "0", name = "page") Integer number,
                                 @PathVariable("id") String id, Model model){
        Material list = materialRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Material> mate = materialRepository.findAll(pageable);
        model.addAttribute("material", list);
        model.addAttribute("material", mate);
        return "qlproduct/qlmaterial/ctmaterial";
    }

    @GetMapping("/detail_size/{id}")
    public String detailsize(@RequestParam( defaultValue = "0", name = "page") Integer number,
                             @PathVariable("id") String id, Model model){
        Size list = sizeRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Size> siz = sizeRepository.findAll(pageable);
        model.addAttribute("size", list);
        model.addAttribute("size", siz);
        return "qlproduct/qlsize/ctsize";
    }

    @GetMapping("/detail_sockliner/{id}")
    public String detailsockliner(@RequestParam( defaultValue = "0", name = "page") Integer number,
                                  @PathVariable("id") String id, Model model){
        Sockliner list = socklinerRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Sockliner> sock = socklinerRepository.findAll(pageable);
        model.addAttribute("sockliner", list);
        model.addAttribute("sockliner", sock);
        return "qlproduct/qlsockliner/ctsockliner";
    }

    @GetMapping("/detail_sole/{id}")
    public String detailsole(@RequestParam( defaultValue = "0", name = "page") Integer number,
                             @PathVariable("id") String id, Model model){
        Sole list = soleRepository.findById(Integer.valueOf(id)).orElse(null);
        Pageable pageable = PageRequest.of(number, 6);
        Page<Sole> sol = soleRepository.findAll(pageable);
        model.addAttribute("sole", list);
        model.addAttribute("sole", sol);
        return "qlproduct/qlsole/ctsole";
    }

    //delete

    @GetMapping("/delete_product/{id}")
    public String deleteproduct(@PathVariable("id") String id) {
        productRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_product";
    }

    @GetMapping("/delete_brand/{id}")
    public String deletebrand(@PathVariable("id") String id) {
        brandRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_brand";
    }

    @GetMapping("/delete_category/{id}")
    public String deletecategory(@PathVariable("id") String id) {
        categoryRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_category";
    }

    @GetMapping("/delete_color/{id}")
    public String deletecolor(@PathVariable("id") String id) {
        colorRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_color";
    }

    @GetMapping("/delete_lace/{id}")
    public String deletelace(@PathVariable("id") String id) {
        laceRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_lace";
    }

    @GetMapping("/delete_material/{id}")
    public String deletematerial(@PathVariable("id") String id) {
        materialRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_material";
    }

    @GetMapping("/delete_size/{id}")
    public String deletesize(@PathVariable("id") String id) {
        sizeRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_size";
    }

    @GetMapping("/delete_sockliner/{id}")
    public String deletesockliner(@PathVariable("id") String id) {
        socklinerRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_sockliner";
    }

    @GetMapping("/delete_sole/{id}")
    public String deletesole(@PathVariable("id") String id) {
        soleRepository.deleteById(Integer.valueOf(id));
        return "redirect:/pdtt/hienthi_sole";
    }

    @PostMapping("/add_product")
    public String addproduct(@RequestParam("name") String name){
        Product pro = Product.builder()
                .name(name)
                .status(0)
                .build();
        productRepository.save(pro);
        return "redirect:/pdtt/hienthi_product";
    }

    @PostMapping("/add_brand")
    public String addbrand(@RequestParam("name") String name){
        Brand pro = Brand.builder()
                .name(name)
                .status(0)
                .build();
        brandRepository.save(pro);
        return "redirect:/pdtt/hienthi_brand";
    }

    @PostMapping("/add_category")
    public String addcategory(@RequestParam("name") String name){
        Category pro = Category.builder()
                .name(name)
                .status(0)
                .build();
        categoryRepository.save(pro);
        return "redirect:/pdtt/hienthi_category";
    }

    @PostMapping("/add_color")
    public String addcolor(@RequestParam("name") String name){
        Color pro = Color.builder()
                .name(name)
                .status(0)
                .build();
        colorRepository.save(pro);
        return "redirect:/pdtt/hienthi_color";
    }
//checkday
    @PostMapping("/add_lace")
    public String addlace(@RequestParam("name") String name, @RequestParam("length") String length){
        Lace pro = Lace.builder()
                .name(name)
                .length(Float.valueOf(length))
                .status(0)
                .build();
        laceRepository.save(pro);
        return "redirect:/pdtt/hienthi_lace";
    }

    @PostMapping("/add_material")
    public String addmaterial(@RequestParam("name") String name){
        Material pro = Material.builder()
                .name(name)
                .status(0)
                .build();
        materialRepository.save(pro);
        return "redirect:/pdtt/hienthi_material";
    }

    @PostMapping("/add_size")
    public String addsize(@RequestParam("name") String name){
        Size pro = Size.builder()
                .name(name)
                .status(0)
                .build();
        sizeRepository.save(pro);
        return "redirect:/pdtt/hienthi_size";
    }

    @PostMapping("/add_sockliner")
    public String addsockliner(@RequestParam("name") String name, @RequestParam("material") String material, @RequestParam("color") String color){
        Sockliner pro = Sockliner.builder()
                .name(name)
                .material(material)
                .color(color)
                .build();
        socklinerRepository.save(pro);
        return "redirect:/pdtt/hienthi_sockliner";
    }

    @PostMapping("/add_sole")
    public String addsole(@RequestParam("name") String name, @RequestParam("material") String material){
        Sole pro = Sole.builder()
                .name(name)
                .material(material)
                .status(0)
                .build();
        soleRepository.save(pro);
        return "redirect:/pdtt/hienthi_sole";
    }

    // update
    @PostMapping("/update_product")
    public String updateproduct(@RequestParam("name") String name,
                                @RequestParam("id") String id){
        Product pro = Product.builder()
                .name(name)
                .status(0)
                .build();
        Product product = productRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(product.getId());
        BeanUtils.copyProperties(pro, product);
        productRepository.save(product);
        return "redirect:/pdtt/hienthi_product";
    }

    @PostMapping("/update_brand")
    public String updatebrand(@RequestParam("name") String name,
                              @RequestParam("id") String id){
        Brand pro = Brand.builder()
                .name(name)
                .status(0)
                .build();
        Brand brand = brandRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(brand.getId());
        BeanUtils.copyProperties(pro, brand);
        brandRepository.save(brand);
        return "redirect:/pdtt/hienthi_brand";
    }

    @PostMapping("/update_category")
    public String updatecategory(@RequestParam("name") String name,
                                 @RequestParam("id") String id){
        Category pro = Category.builder()
                .name(name)
                .status(0)
                .build();
        Category category = categoryRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(category.getId());
        BeanUtils.copyProperties(pro, category);
        categoryRepository.save(category);
        return "redirect:/pdtt/hienthi_category";
    }

    @PostMapping("/update_color")
    public String updatecolor(@RequestParam("name") String name,
                              @RequestParam("id") String id){
        Color pro = Color.builder()
                .name(name)
                .status(0)
                .build();
        Color color = colorRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(color.getId());
        BeanUtils.copyProperties(pro, color);
        colorRepository.save(color);
        return "redirect:/pdtt/hienthi_color";
    }
    //checkday
    @PostMapping("/update_lace")
    public String updatelace(@RequestParam("name") String name, @RequestParam("length") String length,
                             @RequestParam("id") String id){
        Lace pro = Lace.builder()
                .name(name)
                .length(Float.valueOf(length))
                .status(0)
                .build();
        Lace lace = laceRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(lace.getId());
        BeanUtils.copyProperties(pro, lace);
        laceRepository.save(lace);
        return "redirect:/pdtt/hienthi_lace";
    }

    @PostMapping("/update_material")
    public String updatematerial(@RequestParam("name") String name, @RequestParam("id") String id){
        Material pro = Material.builder()
                .name(name)
                .status(0)
                .build();
        Material material = materialRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(material.getId());
        BeanUtils.copyProperties(pro, material);
        materialRepository.save(material);
        return "redirect:/pdtt/hienthi_material";
    }

    @PostMapping("/update_size")
    public String updatesize(@RequestParam("name") String name, @RequestParam("id") String id){
        Size pro = Size.builder()
                .name(name)
                .status(0)
                .build();
        Size size = sizeRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(size.getId());
        BeanUtils.copyProperties(pro, size);
        sizeRepository.save(size);
        return "redirect:/pdtt/hienthi_size";
    }

    @PostMapping("/update_sockliner")
    public String updatesockliner(@RequestParam("name") String name, @RequestParam("material") String material,
                                  @RequestParam("color") String color, @RequestParam("id") String id){
        Sockliner pro = Sockliner.builder()
                .name(name)
                .material(material)
                .color(color)
                .build();
        Sockliner sockliner = socklinerRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(sockliner.getId());
        BeanUtils.copyProperties(pro, sockliner);
        socklinerRepository.save(sockliner);
        return "redirect:/pdtt/hienthi_sockliner";
    }

    @PostMapping("/update_sole")
    public String updatesole(@RequestParam("name") String name, @RequestParam("material") String material,
                             @RequestParam("id") String id){
        Sole pro = Sole.builder()
                .name(name)
                .material(material)
                .status(0)
                .build();
        Sole sole = soleRepository.findById(Integer.valueOf(id)).orElse(null);
        pro.setId(sole.getId());
        BeanUtils.copyProperties(pro, sole);
        soleRepository.save(sole);
        return "redirect:/pdtt/hienthi_sole";
    }



}

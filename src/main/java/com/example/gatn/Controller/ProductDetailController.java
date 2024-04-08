package com.example.gatn.Controller;

import com.example.gatn.Entity.*;
import com.example.gatn.Entity.Color;
import com.example.gatn.Entity.Image;
import com.example.gatn.Repositoris.*;
import com.example.gatn.Service.Impl.ProductDetailImpl;
import com.example.gatn.Service.ProductDetailService;
import com.google.zxing.WriterException;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/productdetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService ;

    @Autowired
    private ProductDetailReponsitoty productDetailReponsitoty;

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

    @Autowired
    private ImageRepository imageRepository;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @GetMapping("/hienthi")
    public String getall(@RequestParam( defaultValue = "0", name = "page") Integer number, Model model){
        Pageable pageable = PageRequest.of(number, 4);
        List<Category> category = categoryRepository.findAll();
        List<Size> size = sizeRepository.findAll();
        List<Product> product = productRepository.findAll();
        List<Material> material = materialRepository.findAll();
        List<Brand> brand = brandRepository.findAll();
        List<Color> color = colorRepository.findAll();
        List<Sole> sole = soleRepository.findAll();
        List<Lace> lace = laceRepository.findAll();
        List<Sockliner> sockliner = socklinerRepository.findAll();
        Page<ProductDetail> listproduct = productDetailReponsitoty.findAll(pageable);
        model.addAttribute("listprd", listproduct);
        model.addAttribute("category", category);
        model.addAttribute("size", size);
        model.addAttribute("product", product);
        model.addAttribute("material", material);
        model.addAttribute("brand", brand);
        model.addAttribute("color", color);
        model.addAttribute("sole", sole);
        model.addAttribute("lace", lace);
        model.addAttribute("sockliner", sockliner);
        return "qlproduct/product";
    }

    @GetMapping("/filter")
    public String filterList(@RequestParam( defaultValue = "0", name = "page") Integer number,
                             @RequestParam("keyLoc") String keyLoc, Model model) {
        Pageable pageable = PageRequest.of(number, 4);
        List<Category> category = categoryRepository.findAll();
        List<Size> size = sizeRepository.findAll();
        List<Product> product = productRepository.findAll();
        List<Material> material = materialRepository.findAll();
        List<Brand> brand = brandRepository.findAll();
        List<Color> color = colorRepository.findAll();
        List<Sole> sole = soleRepository.findAll();
        List<Lace> lace = laceRepository.findAll();
        List<Sockliner> sockliner = socklinerRepository.findAll();
        Page<ProductDetail> listproduct = productDetailService.getall(Integer.valueOf(keyLoc), pageable);
        model.addAttribute("listprd", listproduct);
        model.addAttribute("category", category);
        model.addAttribute("size", size);
        model.addAttribute("product", product);
        model.addAttribute("material", material);
        model.addAttribute("brand", brand);
        model.addAttribute("color", color);
        model.addAttribute("sole", sole);
        model.addAttribute("lace", lace);
        model.addAttribute("sockliner", sockliner);
        return "qlproduct/product";
    }

    @GetMapping("/search")
    public String search(@RequestParam( defaultValue = "0", name = "page") Integer number,
                         Model model, @RequestParam("keySearch") String key){
        Pageable pageable = PageRequest.of(number, 4);
        List<Category> category = categoryRepository.findAll();
        List<Size> size = sizeRepository.findAll();
        List<Product> product = productRepository.findAll();
        List<Material> material = materialRepository.findAll();
        List<Brand> brand = brandRepository.findAll();
        List<Color> color = colorRepository.findAll();
        List<Sole> sole = soleRepository.findAll();
        List<Lace> lace = laceRepository.findAll();
        List<Sockliner> sockliner = socklinerRepository.findAll();
        Page<ProductDetail> listproduct =productDetailReponsitoty.findAll(pageable);
        if(key != null){
            listproduct = productDetailService.search(key, pageable);
        }
        model.addAttribute("listprd", listproduct);
        model.addAttribute("category", category);
        model.addAttribute("size", size);
        model.addAttribute("product", product);
        model.addAttribute("material", material);
        model.addAttribute("brand", brand);
        model.addAttribute("color", color);
        model.addAttribute("sole", sole);
        model.addAttribute("lace", lace);
        model.addAttribute("sockliner", sockliner);
        return "qlproduct/product";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        productDetailReponsitoty.deleteById(Integer.valueOf(id));
        return "redirect:/productdetail/hienthi";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String UPLOAD_DIR = "imagesp/";
        if (!file.isEmpty()) {
            String originalFileName = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + originalFileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return originalFileName;
        }
        return "No file selected";
    }

    @GetMapping("/detail/{id}")
    public String detail(@RequestParam( defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") String id, Model model){
        ProductDetail Productdetail = productDetailReponsitoty.findById(Integer.valueOf(id)).orElse(null);
        List<Category> category = categoryRepository.findAll();
        List<Size> size = sizeRepository.findAll();
        List<Product> product = productRepository.findAll();
        List<Material> material = materialRepository.findAll();
        List<Brand> brand = brandRepository.findAll();
        List<Color> color = colorRepository.findAll();
        List<Sole> sole = soleRepository.findAll();
        List<Lace> lace = laceRepository.findAll();
        List<Sockliner> sockliner = socklinerRepository.findAll();
        model.addAttribute("sp", Productdetail);
        model.addAttribute("category", category);
        model.addAttribute("size", size);
        model.addAttribute("product", product);
        model.addAttribute("material", material);
        model.addAttribute("brand", brand);
        model.addAttribute("color", color);
        model.addAttribute("sole", sole);
        model.addAttribute("lace", lace);
        model.addAttribute("sockliner", sockliner);

        Pageable pageable = PageRequest.of(number, 4);
        Page<ProductDetail> listproduct =productDetailReponsitoty.findAll(pageable);
        model.addAttribute("listprd", listproduct);
        return "qlproduct/ctproduct";
    }

    @PostMapping("/add")
    public String add(@RequestParam("category") String categoryid, @RequestParam("size") String sizeid,
                      @RequestParam("product") String productid, @RequestParam("material") String materialid,
                      @RequestParam("brand") String brandid, @RequestParam("color") String colorid,
                      @RequestParam("sole") String soleid, @RequestParam("lace") String laceid,
                      @RequestParam("sockliner") String socklinerid, @RequestParam("quantity") String quantity,
                      @RequestParam("describe") String describe, @RequestParam("gender") String gender,
                      @RequestParam("price") String price,
                      @RequestParam("anhsp") MultipartFile imageofsp) throws IOException {
        Category category = categoryRepository.findById(Integer.valueOf(categoryid)).orElse(null);
        Size size = sizeRepository.findById(Integer.valueOf(sizeid)).orElse(null);
        Product product = productRepository.findById(Integer.valueOf(productid)).orElse(null);
        Material material = materialRepository.findById(Integer.valueOf(materialid)).orElse(null);
        Brand brand = brandRepository.findById(Integer.valueOf(brandid)).orElse(null);
        Color color = colorRepository.findById(Integer.valueOf(colorid)).orElse(null);
        Sole sole = soleRepository.findById(Integer.valueOf(soleid)).orElse(null);
        Lace lace = laceRepository.findById(Integer.valueOf(laceid)).orElse(null);
        Sockliner sockliner = socklinerRepository.findById(Integer.valueOf(socklinerid)).orElse(null);
        ProductDetail sp = ProductDetail.builder()
                .category(category)
                .size(size)
                .product(product)
                .material(material)
                .brand(brand)
                .color(color)
                .sole(sole)
                .lace(lace)
                .sockliner(sockliner)
                .quantity(Integer.valueOf(quantity))
                .describe(describe)
                .gender(Boolean.valueOf(gender))
                .price(Float.valueOf(price))
                .status(Integer.valueOf(0))
                .build();
        productDetailReponsitoty.save(sp);

        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("imagesp");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path fileim = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(imageofsp.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(fileim)) {
            os.write(imageofsp.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageName = imageofsp.getOriginalFilename();

        ProductDetail idprodt = productDetailReponsitoty.findById(sp.getId()).orElse(null);
        Image im = Image.builder()
                .name(imageName)
                .productDetail(idprodt)
                .build();
        imageRepository.save(im);

        int width = 400;
        int height = 200;
        String barcodeText  = String.valueOf(sp.getId()); // Kết hợp ID và nội dung thành một chuỗi
        String fileName = "barcodeid" + sp.getId() + ".png"; // Tên của file barcode

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 1);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            MultiFormatWriter writer = new MultiFormatWriter();
            BitMatrix bitMatrix = writer.encode(barcodeText, BarcodeFormat.CODE_128, width, height, hints);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.fillRect(0, 0, width, height);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (bitMatrix.get(j, i)) {
                        graphics.setColor(java.awt.Color.BLACK);
                        graphics.drawRect(j, i, 1, 1);
                    }
                }
            }

            // Lưu file vào thư mục view
            String filePath = "src/main/resources/static/" + fileName; // Đường dẫn tới file barcode trong thư mục view
            File file = new File(filePath);
            ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi tạo barcode: " + e.getMessage();
        }

        return "redirect:/productdetail/hienthi";
    }

    @PostMapping("/update")
    public String update(@RequestParam("category") String categoryid, @RequestParam("size") String sizeid,
                         @RequestParam("product") String productid, @RequestParam("material") String materialid,
                         @RequestParam("brand") String brandid, @RequestParam("color") String colorid,
                         @RequestParam("sole") String soleid, @RequestParam("lace") String laceid,
                         @RequestParam("sockliner") String socklinerid, @RequestParam("quantity") String quantity,
                         @RequestParam("describe") String describe, @RequestParam("gender") String gender,
                         @RequestParam("price") String price, @RequestParam("id") String id){
        Category category = categoryRepository.findById(Integer.valueOf(categoryid)).orElse(null);
        Size size = sizeRepository.findById(Integer.valueOf(sizeid)).orElse(null);
        Product product = productRepository.findById(Integer.valueOf(productid)).orElse(null);
        Material material = materialRepository.findById(Integer.valueOf(materialid)).orElse(null);
        Brand brand = brandRepository.findById(Integer.valueOf(brandid)).orElse(null);
        Color color = colorRepository.findById(Integer.valueOf(colorid)).orElse(null);
        Sole sole = soleRepository.findById(Integer.valueOf(soleid)).orElse(null);
        Lace lace = laceRepository.findById(Integer.valueOf(laceid)).orElse(null);
        Sockliner sockliner = socklinerRepository.findById(Integer.valueOf(socklinerid)).orElse(null);
        ProductDetail sp = ProductDetail.builder()
                .category(category)
                .size(size)
                .product(product)
                .material(material)
                .brand(brand)
                .color(color)
                .sole(sole)
                .lace(lace)
                .sockliner(sockliner)
                .quantity(Integer.valueOf(quantity))
                .describe(describe)
                .gender(Boolean.valueOf(gender))
                .price(Float.valueOf(price))
                .build();
        ProductDetail findProduct = productDetailReponsitoty.findById(Integer.valueOf(id)).orElse(null);
        sp.setId(findProduct.getId());
        BeanUtils.copyProperties(sp, findProduct);
        productDetailService.add(findProduct);


        return "redirect:/productdetail/hienthi";
    }

    @GetMapping("updatett/{id}/{status}")
    public String updatett(@PathVariable("id") String id, @PathVariable("status") String tt) {
        ProductDetail findProduct = productDetailReponsitoty.findById(Integer.valueOf(id)).orElse(null);
        if(tt.equals("0")){
            findProduct.setStatus(1);
        }else{
            findProduct.setStatus(0);
        }
        productDetailService.add(findProduct);
        return "redirect:/productdetail/hienthi";
    }

}

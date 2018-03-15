package business.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import business.entity.Business;
import business.entity.Category;
import business.entity.Product;
import business.entity.Promotion;
import business.service.BusinessService;
import business.service.impl.BusinessServiceImpl;
import business.utils.UploadUtils;

public class AddProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//创建map 放入前台传递的数据
			HashMap<String, Object> map = new HashMap<>();
			//创建磁盘文件项
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建核心上传对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析request
			List<FileItem> list = upload.parseRequest(request);
			//遍历集合
			for (FileItem fi : list) {
				//判断是否是普通的上传组件
				if(fi.isFormField()){
					//普通上传组件
					map.put(fi.getFieldName(),fi.getString("utf-8"));
				}else{
					//文件上传组件
					//获取文件名称
					String name = fi.getName();
					//获取文件的真实名称    
					String realName = UploadUtils.getRealName(name);
					//获取文件的随机名称
					String uuidName = UploadUtils.getUUIDName(realName);
					//获取文件的存放路径
					String path = this.getServletContext().getRealPath("/user/image");
					//获取文件流
					InputStream is = fi.getInputStream();
					//保存图片
					FileOutputStream os = new FileOutputStream(new File(path, uuidName));
					IOUtils.copy(is, os);
					os.close();
					is.close();
					
					//删除临时文件
					fi.delete();
					
					//在map中设置文件的路径
					map.put(fi.getFieldName(), "/user/image/"+uuidName);
					
				}
			}
			
			
			//1.封装参数
			Product p = new Product();
			BeanUtils.populate(p, map);
			//1.1 商品id
			p.setPid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
			//1.2 商品时间
			p.setPdate(new Date());
			//1.3 封装 cateogry
			Category c = new Category();
			c.setCid((String)map.get("cid"));
			p.setCategory(c);
			//1.4 封装promotion
			Promotion pro = new Promotion();
			pro.setPnid((String)map.get("pnid"));
			p.setPromotion(pro);
			//1.5 封装business
			Business b = new Business();
			b.setBid((String)map.get("bid"));
			p.setBusiness(b);
			
			//2.调用service完成添加
			BusinessService businessService=new BusinessServiceImpl();
			businessService.add(p);
			
			//3.页面重定向
			response.sendRedirect(request.getContextPath()+"/Business_Pro?method=findAllByBid");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/business/jsp/msg.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

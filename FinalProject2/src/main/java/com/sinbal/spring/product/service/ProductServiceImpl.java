package com.sinbal.spring.product.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sinbal.spring.product.dao.ProductDao;
import com.sinbal.spring.product.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void insert(ProductDto dto) {
		productDao.insert(dto);
	}
	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
		//원본 파일명
		String orgFileName=mFile.getOriginalFilename();
		// webapp/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath=request.getServletContext().getRealPath("/upload");
		//저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload=new File(filePath);
		if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
			upload.mkdir(); //만들어 준다.
		}
		//저장할 파일 명을 구성한다.
		String saveFileName=
				System.currentTimeMillis()+orgFileName;
		try {
			//upload 폴더에 파일을 저장한다.
			mFile.transferTo(new File(filePath+saveFileName));
			System.out.println(filePath+saveFileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Map 에 업로드된 이미지 파일의 경로를 담아서 리턴한다
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("imageSrc","/upload/"+saveFileName);
		
		return map;
	}
	@Override
	public void getList(ModelAndView mView) {
		
		mView.addObject("list",productDao.getList());
	}
	
	
	//한 페이지에 나타낼 row 의 갯수
	final int PAGE_ROW_COUNT=5;
	//하단 디스플레이 페이지 갯수
	final int PAGE_DISPLAY_COUNT=9;
	
	
	@Override
	public void productList(HttpServletRequest request) {
			String search = (String)request.getParameter("search");
			String kind = (String)request.getParameter("kind");
			String arr = (String)request.getParameter("arr");
			
			if(search==null) {
				search="";
			}
			if(kind==null) {
				kind="";
			}
			if(arr==null) {
				arr="";
			}
			
			System.out.println(search);
			System.out.println(kind);
			System.out.println(arr);
			
			String encodedK=URLEncoder.encode(search);
			
			
			//보여줄 페이지의 번호
			int pageNum=1;
			//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
			String strPageNum=request.getParameter("pageNum");
			if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
				//페이지 번호를 설정한다.
				pageNum=Integer.parseInt(strPageNum);
			}
			//보여줄 페이지 데이터의 시작 ResultSet row 번호
			int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
			//보여줄 페이지 데이터의 끝 ResultSet row 번호
			int endRowNum=pageNum*PAGE_ROW_COUNT;
			
			//startRowNum, endRowNum 을 담을 Dto 객체 생성
			ProductDto dto=new ProductDto();
			dto.setStartRowNum(startRowNum);
			dto.setEndRowNum(endRowNum);
			dto.setSearch(search);
			
			if(!search.equals("")) {
				dto.setSearch(search);
			}
			if(!kind.equals("")) {
				dto.setKind(kind);
			}
			if(!arr.equals("")) {
				dto.setArr(arr);
			}
			
			
			//파일 목록 얻어오기
			List<ProductDto> list=productDao.productListSearch(dto);
			//전체 row 의 갯수 
			int totalRow=productDao.getCount(dto);
			
			//전체 페이지의 갯수 구하기
			int totalPageCount=
					(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
			//시작 페이지 번호
			int startPageNum=
				1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
			//끝 페이지 번호
			int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
			//끝 페이지 번호가 잘못된 값이라면 
			if(totalPageCount < endPageNum){
				endPageNum=totalPageCount; //보정해준다. 
			}
			
			//EL 에서 사용할 값을 미리 request 에 담아두기
			request.setAttribute("list", list);
			request.setAttribute("startPageNum", startPageNum);
			request.setAttribute("endPageNum", endPageNum);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("totalPageCount", totalPageCount);
			request.setAttribute("search", search);
			request.setAttribute("encodedK", encodedK);
			request.setAttribute("arr", arr);
			request.setAttribute("kindSelect", kind);
	}
}

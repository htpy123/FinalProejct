<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<form action="${pageContext.request.contextPath }/shop/shop.do" method="post" id="listForm">
			<div class="form-group">
				<label for="kindSelect">카테고리</label>
				<select id="kindSelect" name="kindSelect">
					<option value="default">==선택==</option>
			        <option value="sneakers" <c:if test="${kindSelect eq 'sneakers' }">selected</c:if>>스니커즈</option>
			        <option value="running" <c:if test="${kindSelect eq 'running' }">selected</c:if>>런닝화</option>
			        <option value="walker" <c:if test="${kindSelect eq 'walker' }">selected</c:if>>워커</option>
			     </select>
			</div>
			<div class="form-group">
				<label for="arr">정렬</label>
				<select id="arr" name="arr">
					<option value="default">==선택==</option>
					<option value="newArr" <c:if test="${arr eq 'newArr' }">selected</c:if>>최신순</option>
					<option value="popArr" <c:if test="${arr eq 'popArr' }">selected</c:if>>인기순</option>
					<option value="priceHighArr" <c:if test="${arr eq 'priceHighArr' }">selected</c:if>>가격높은순</option>
					<option value="priceLowArr" <c:if test="${arr eq 'priceLowArr' }">selected</c:if>>가격낮은순</option>
					<option value="saleArr" <c:if test="${arr eq 'saleArr' }">selected</c:if>>판매순</option>
					<option value="stockArr" <c:if test="${arr eq 'stockArr' }">selected</c:if>>재고없음</option>
				</select>
			</div>
			<input value="${keyword }" type="text" name="keyword" placeholder="검색어..."/>
			<button type="submit" onclick="to_ajax();">검색</button>
		</form>
		
		<script>
		//form ajax 요청으로 리스트 불러오기
		function to_ajax(){
			$(onClick)
			var formData = $("#listForm").serialize();
		    $.ajax({
		        type : 'post',
		        url : '${pageContext.request.contextPath }/shop/shop.do',
		        data : formData,
		        success:function(data){
		        }
		    });
		    return false;
		}
		</script>
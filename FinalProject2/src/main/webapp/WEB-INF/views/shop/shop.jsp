<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/shop/shop.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/sinbar.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-lates.min.js"></script>
</head>
<body>

	
<jsp:include page="../include/header.jsp">
	<jsp:param value="shop" name="thisPage"/>
</jsp:include>



  <!-- Page Content  카테고리-->
  <div class="">

    <div class="row">

	<div class="col-lg-3">
		<form action="${pageContext.request.contextPath }/shop/shop.do" method="post" id="listForm">
			<div class="form-group">
				<label for="kind">카테고리</label>
				<select id="kind" name="kind">
					<option value="default">==선택==</option>
			        <option value="sneakers" <c:if test="${kindSelect eq 'sneakers' }">selected</c:if>>스니커즈</option>
			        <option value="running" <c:if test="${kindSelect eq 'running' }">selected</c:if>>런닝화</option>
			        <option value="walker" <c:if test="${kindSelect eq 'walker' }">selected</c:if>>워커</option>
			     </select>
			</div>
			<div class="form-group">
				<label for="arr">정렬</label>
				<select id="arr" name="arr">
					<option value="default" >==선택==</option>
					<option value="newArr" <c:if test="${arr eq 'newArr' }">selected</c:if>>최신순</option>
					<option value="popArr" <c:if test="${arr eq 'popArr' }">selected</c:if>>인기순</option>
					<option value="priceHighArr" <c:if test="${arr eq 'priceHighArr' }">selected</c:if>>가격높은순</option>
					<option value="priceLowArr" <c:if test="${arr eq 'priceLowArr' }">selected</c:if>>가격낮은순</option>
					<option value="saleArr" <c:if test="${arr eq 'saleArr' }">selected</c:if>>판매순</option>
					<option value="stockArr" <c:if test="${arr eq 'stockArr' }">selected</c:if>>재고없음</option>
				</select>
			</div>
		</form>
	</div>
      <!-- /.col-lg-3  상품목록-->

      <div class="col-lg-9" style="margin-top: 100px">


        <div class="row">
		<c:forEach var="tmp" items="${list }">
		<div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="${pageContext.request.contextPath }${tmp.profile}" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">${tmp.productname }</a>
                </h4>
                <h6>${tmp.price }</h6>
                <p class="card-text">심플 이즈 베스트 단화!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
		
		</c:forEach>
        
        </div>
        <!-- /.row -->
        
        
		<div class="page-display">
			<ul class="pagination pagination-sm">
			<c:if test="${startPageNum ne 1 }">
				<li class="page-item"><a class="page-link" href="shop.do?pageNum=${startPageNum-1 }&search=${encodedK }">Prev</a></li>
			</c:if>
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${i eq pageNum }">
						<li class="page-item active"><a class="page-link" href="shop.do?pageNum=${i }&search=${encodedK }">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="shop.do?pageNum=${i }&search=${encodedK }">${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${endPageNum lt totalPageCount }">
				<li class="page-item"><a class="page-link" href="shop.do?pageNum=${endPageNum+1 }&search=${encodedK }">Next</a></li>
			</c:if>
			</ul>	
		</div>	

	
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  

  
<jsp:include page="../include/footer.jsp">
	<jsp:param value="shop" name="thisPage"/>
</jsp:include>


<script>
$('#arr').change(function() {
    var value = $(this).val();
    $('#listForm').submit();
});
$('#kind').change(function() {
    var value = $(this).val();
    $('#listForm').submit();
});
</script>
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
//分页查询(首页、上一页、下一页、尾页)
	function firstPage(pageNum) {
		$("#pageNum").val(pageNum);
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
	
	function prevPage(pageNum) {
		$("#pageNum").val(pageNum);
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
	
	function nextPage(pageNum) {
		$("#pageNum").val(pageNum);
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
	
	function endPage(pageNum) {
		$("#pageNum").val(pageNum);
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
</script>

<a class="btn btn-mini btn-info">共${pageList.totalRecordsNum}条记录</a>
<a class="btn btn-mini btn-info">第${pageList.pageNum}页 / 共${pageList.totalPage}页</a>
<a class="btn btn-mini btn-info" onclick="firstPage('1');" >首页</a>
<a class="btn btn-mini btn-info" onclick="prevPage('${pageList.prevPageNum}');">上一页</a>
<a class="btn btn-mini btn-info" onclick="nextPage('${pageList.nextPageNum}');">下一页</a>
<a class="btn btn-mini btn-info" onclick="endPage('${pageList.totalPage}');">尾页</a>
<input type="hidden" id="pageNum" name="pageNum" value="${pageList.pageNum}" /> 
<input type="hidden" id="pageSize" name="pageSize" value="${pageList.pageSize}" /> 

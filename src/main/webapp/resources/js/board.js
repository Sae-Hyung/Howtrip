/**
 * 
 */
 
function loginCheck() {
 	$.ajax({
 		url : "writeCheck",
 		type : "GET",
 		success : function (data) {
 			if(data == 0) {
 				alert("로그인이 필요한 서비스입니다.");
 				location.href = "../member/loginForm.do";
 			} else {
 				location.href = "board/writeForm";
 			}
 		}
 	})
}
 
 function goView(boardId) {
 	
 	//document.getElementById("boardId").value = boardId; // hidden 타입의 input 태그의 value를 boardId 값으로 설정

 	$.ajax({
 		url : "board/viewCheck",
 		type : "GET",
 		data : {
 			"boardId" : boardId
 		},
 		success : function(data) {
 			if (data == 0) {
 				$("#boardId").val(boardId);
 				var boardForm = $("#boardForm");
			 	boardForm.attr("action", "board/viewBoard/" + boardId);
			 	boardForm.attr("method", "GET");
			 	boardForm.submit();
 			} else {
 				alert("해당 게시글을 찾을 수 없습니다.");
 			}
 		},
 		error: function(xhr, status, error) {
            console.error("Ajax 요청 실패:", error);
            alert("게시글 조회 중 오류가 발생했습니다.");
        }
 	})
 }
 
 function goUpdateBoard(boardId) {
 	$("#boardId").val(boardId);
 	
 	var goUpdateForm = $("#viewForm");
 	goUpdateForm("action", "board/updateBoardForm");
 	goUpdateForm("method", " POST");
 	goUpdateForm.submit();
 }
 
 function boardUpdate(){
	$.ajax({
		type : "POST",
		url : "board/updateBoard",
		success: function(data){
			if(data == "Y"){
				alert("글 수정이 완료되었습니다.");
				fn_goView(seq);
			}else{
				alert("글 수정이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
}

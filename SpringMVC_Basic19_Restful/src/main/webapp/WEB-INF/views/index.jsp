<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
	<table>
		<thead>
			<tr>
				<th><input type="text" name="search" id="search"
					placeholder="사원이름을 입력하고 Enter"></th>
				<th colspan='7'>EmpList</th>
			</tr>
			<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>SAL</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody id="main-container">

		</tbody>
		<tr id="inputArea">
			<td><input type="button" onclick="createinput(this)"
				value="사원등록"></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	let search = '';
	$('#search').on({
		//onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"/>
		keypress: (event) => {
			if (event.keyCode == 13) {
				search = $('#search').val();
				getSearch(search);
			}
		}
	})

	function getList() {
		$.ajax({
			type: "get",
			url: "emp",
			success: (list) => {
				let maincontainer = "";
				$.each(list, (index, list) => {
					maincontainer +=
						'<tr>' +
						'<th>' + list.empno + '</th>' +
						'<th>' + list.ename + '</th>' +
						'<th>' + list.sal + '</th>' +
						'<th><input type="button" onclick="empupdate(this)" value="수정"></th>' +
						'<th><input type="button" onclick="empdelete(' + list.empno +
						')" value="삭제"></th>' +
						'</tr>';
				}) //each end
				$('#main-container').empty();
				$('#main-container').append(maincontainer);
			}, //success Function end
			error: () => {
				console.log('error')
				alert('error');
			} //error Function end
		}); //ajax end
	} //getList Function end
	
	//조건조회
	function getSearch(empno) {
		if(empno != null && empno != ""){
		$.ajax({
			type: "get",
			url: "emp/" + empno,
			success: (list) => {
				$('#main-container').empty();
				if(list != null && list!=""){
					let maincontainer = 
						'<tr>' +
						'<th>' + list.empno + '</th>' +
						'<th>' + list.ename + '</th>' +
						'<th>' + list.sal + '</th>' +
						'<th><input type="button" onclick="empupdate(this)" value="수정"></th>' +
						'<th><input type="button" onclick="empdelete(' + list.empno +
						')" value="삭제"></th>' +
						'</tr>';
				
					$('#main-container').append(maincontainer);
				}
			}, //success Function end
			error: () => {
				console.log('error')
				alert('error');
			} //error Function end
		}); //ajax end
	}else{
		$('#main-container').empty();
	}
	} //getList Function end

	//update 준비 버튼?
	function empupdate(element) {
		const tr = $(element).closest('tr');
		const tharr = [...tr[0].childNodes];

		const empno = $(tharr[0]).text()
		const ename = $(tharr[1]).text()
		const sal = $(tharr[2]).text()

		let td = "<td><input type='text' value='" + empno + "'></td>";
		td += "<td><input type='text' value='" + ename + "'></td>";
		td += "<td><input type='text' value='" + sal + "'></td>";
		td += "<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료'/></td>";
		$(tr).empty();
		$(tr).append(td);
	} //empupdate Function end

	//update 비동기 처리 함수
	function empupdateconfirm(me) {
		var tr = $(me).closest('tr');
		var emp = {
			empno: tr.find("td:eq(0)").children().val(),
			ename: tr.find("td:eq(1)").children().val(),
			sal: tr.find("td:eq(2)").children().val()
		}; //data end
		$.ajax({
			type: "put",
			url: "emp",
			contentType: 'application/json',
			data: JSON.stringify(emp),
			success: function (list) {
				getList();
			}
		}) //ajax end
	} //empupdateconfirm Function end

	//사원등록 버튼용 함수
	function createinput(me) {
		var tr = $(me).closest('tr');
		tr.empty();
		var td = "<td><input type='text'></td>";
		td += "<td><input type='text'></td>";
		td += "<td><input type='text'></td>";
		td += "<td><input type='button'onclick='empinsert(this)' value='완료'/></td>";
		td += "<td><input type='button'onclick='cancel(this)' value='취소'/></td>";
		$(tr).append(td);
	} //createinput Function end

	//취소버튼
	function cancel(me) {
		var tr = $(me).closest('tr');
		tr.empty();
		tr.append("<td colspan='10'><input type='button' onclick='createinput(this)' value='사원등록'></td>");
	} //cancle Function end
	//등록 처리
	function empinsert(me) {
		var tr = $(me).closest('tr');

		var emp = {
			empno: tr.find("td:eq(0)").children().val(),
			ename: tr.find("td:eq(1)").children().val(),
			sal: tr.find("td:eq(2)").children().val()	
		};
		$.ajax({
			type: "post",
			url: "emp",
			data: emp,
			success: (list) => {
				getList();
				$('#inputArea').empty();
				$('#inputArea').append(
					"<td colspan='10'><input type='button' onclick='createinput(this)' value='사원등록'></td>");
			},
			error: (list) => {
				alert(list)
			}
		})
	} //empinsert Function end

	function empdelete(empno) {
		console.log(empno);
		$.ajax({
			type: 'DELETE',
			url: "emp/" + empno,
			success: (list) => {
				getList();
			},
			error: (error) => {
				alert(error);
			}
		});
	}
	getList();
</script>

</html>
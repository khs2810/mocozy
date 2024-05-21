function loadImg(inputFile, num){
    // console.log(inputFile)
    // console.log(num)
    //inputFile : 현재 변화가 생긴 input type=file 요소객체
    //num : 몇번째 input요소인지 확인하기 위한 파라미터
    
    
    //inputFile.files[0] => 선택된 파일이 담겨있다.
    //inputFile.files.length -> 1
    console.log(inputFile.files.length)

    if (inputFile.files.length == 1){//파일을 하나 선택 => 미리보기
        const reader = new FileReader();

        reader.readAsDataURL(inputFile.files[0]);

        reader.onload = function(ev){
            if(num == 1) {
                document.getElementById("fileImg").src = ev.target.result;
            }
        }
    } else { // 선택된 파일을 취소한 경우 => 미리보기 지우기
        if (num == 1) {
            // document.getElementById("fileImg").src = "${pageContext.request.contextPath}/img/fileImg.png";
            document.getElementById("fileImg").src = "${pageContext.request.contextPath}/resources/jun/img/fileImg.png";
        }
    }
}

function chooseFile(num){
    const imgInput = document.querySelector("#file" + num);
    imgInput.click();
}

$('#question').keyup(function (e){
    let content = $(this).val();
    $('#question_letter_count').text(content.length+" / 300");

    if (content.length > 300){
        alert("최대 300자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 300));
        $('#question_letter_count').text("(300 / 300)");
    }
});

$(document).ready(function() {
  $('#summernote').summernote({
	  placeholder: "게시글을 작성해주세요.",
	  height: 600,
	//   maxHeight: 1000,
	  width: 560,
	  toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['Insert',['picture']]
		  ],
      focus: true,
      disableResizeEditor: true,
	  callbacks: {
		    onImageUpload: fileUpload
	  }
  });
});

//썸머노트에 이미지업로드가 발생하였을 때 동작하는 함수
function fileUpload(fileList){
	//썸머노트는 이미지를 추가하면 해당이미지파일을 전달해준다.
	//callback함수를 작성하지 않을경우 자동으로 이미지를 string으로 변환해서 보여주지만
	//customCallback을 작성할 경우 해당 이미지의 경로를 직접 주어야한다.

	//파일업로드를 할때는 form태그에서 encType을 multipart/form-data형식으로
	//요청하는 것처럼 자바스크립트 객체에 FormData객체를 이용해서 ajax요청을 해준다.

	const fd = new FormData();
	for(let file of fileList){
		fd.append("fileList", file);
	}

	insertFileApi(fd, function(nameList){
		for(let name of nameList) {
			$("#summernote").summernote('insertImage', "/summer" + name);	 
		}
	});
}

function insertFileApi(data,callback){
	$.ajax({
		url: "upload",
		type: "POST",
		data: data,
		processData: false, //기본이 true로 true일때는 전송하는 data를 string으로 변환해서 요청
		contentType: false, // application/x-www-form-urlencoded; charset=UTF-8; -> multipart/form-data로 보내기위해 false로 지정
		dataType: "json", // 서버로부터 json으로 데이터를 받겠다.
		success: function(changeNameList){
			callback(changeNameList)
		},
		error: function(){
			console.log("파일업로드 api요청 실패")
		}
	})
}
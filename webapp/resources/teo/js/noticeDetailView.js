function confirmDelete(data) {
    const result = confirm("정말 공지사항을 삭제 하시겠습니까?");
    const url = "delete.no?nno=" + data;
    if (result) {
        location.href = url;
    }

}
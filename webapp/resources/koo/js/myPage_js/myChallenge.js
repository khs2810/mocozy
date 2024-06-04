$(document).ready(function() {
    $('#optionSelect').change(function() {
        const selectedOption = $(this).val();

        if (selectedOption === '진행중') {
            $('#club-ing').show();
            $('#club-done').hide();
        } else if (selectedOption === '종료됨') {
            $('#club-ing').hide();
            $('#club-done').show();
        }
    })
});
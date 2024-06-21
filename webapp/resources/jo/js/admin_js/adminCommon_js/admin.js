$(document).ready(function() {
    $('.tile-content').each(function() {
        $(this).find('p').hide(); 
        $(this).find('p:first').show();
    });
});
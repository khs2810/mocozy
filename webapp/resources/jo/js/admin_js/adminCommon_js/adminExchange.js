document.addEventListener('DOMContentLoaded', function() {
    let selectElement = document.querySelector('.zuzy3c.l84FKc');
    let displayElement = document.querySelector('.sBsFoc');
  
    selectElement.addEventListener('change', function() {
      displayElement.textContent = selectElement.options[selectElement.selectedIndex].text;
    });
  });

  document.addEventListener('DOMContentLoaded', function() {
    let selectElement = document.querySelector('.zuzy3c.NKvwhd');
    let displayElement = document.querySelector('.sBsF9c');
  
    selectElement.addEventListener('change', function() {
      displayElement.textContent = selectElement.options[selectElement.selectedIndex].text;
    });
  });
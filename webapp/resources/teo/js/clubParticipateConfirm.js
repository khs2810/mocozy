function confirm() {
    const confirmBtn = document.querySelector('#checkbox_pre_participate');
    const nextBtn = document.querySelector('.club_next_btn');
    if (nextBtn.disabled) {
        nextBtn.style.backgroundColor = "#70C9A0";
        nextBtn.disabled = false;
        nextBtn.style.pointerEvents = "auto";
        confirmBtn.classList.add("clicked_confirm_btn");
        confirmBtn.classList.remove("checkbox_pre_participate");
        checkBtn = true;
    } else {
        nextBtn.style.backgroundColor = "#e7e7e7";
        nextBtn.style.pointerEvents = "none";
        checkBtn = false;
        confirmBtn.classList.remove("clicked_confirm_btn");
        confirmBtn.classList.add("checkbox_pre_participate");
        nextBtn.disabled = true;
    } 
    
}
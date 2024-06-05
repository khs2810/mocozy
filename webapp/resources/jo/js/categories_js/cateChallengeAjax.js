function cateBestChallengeAjax(list){
    const topBody = document.querySelector(".display");
    $(topBody).empty();
    
    for(let club of list) {
        const div = document.createElement("div");
        div.className = "contentcard";
        let str = "";
        str = `
        <div class="socialing">
            <a class="cardlink" href="detail.cl?cno=${club.boardNo}">
                <img class="img" src="${club.thumbnailImg}" />
                <div class="info">
                    <div class="subject">
                        <div class="tag">${club.clubType}</div>
                        <div class="tagone">${club.categoryName1}</div>
                        <div class="tagtwo">${club.categoryName2}</div>
                    </div>
                    <div class="infotitle">${club.boardTitle}</div>
                    <div class="describe">
                        <svg class="image" xmlns="http://www.w3.org/2000/svg" width="10" height="10" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
                        </svg>
                        ${club.address} · ${club.eventDate}
                    </div>
                    <div class="participant">`;
            if(club.profileImg && club.profileImg.length > 0){
                        str += `<img class="people" src="${club.profileImg[0]}" />`;
                    }
                }
                        str += `<div class="profileimglist">`;
            if(club.profileImg && club.profileImg.length >= 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }
                }

            if(club.profileImg && club.profileImg.length > 1 && club.profileImg.length < 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }  
                }

                  str += ` </div>
                    <div class="socialmember">
                         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
                             <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
                             <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
                         </svg>
                         <div class="count">${club.count}</div>
                     </div>
                </div>
             </div>
        </a>
    </div> `;
        div.innerHTML = str;
        topBody.appendChild(div);
    }

//페이지네이션 처리해서 가져와야함....
function cateBestChallengeAjax(callback){
    $.ajax({
        url: "cateBestChallengeAjax.ct",
        success : callback,
        error: function(){
            console.log("ajax실패")
        }
    })
}

function cateHotChallengeAjax(list){
    const topBody = document.querySelector(".display");
    $(topBody).empty();
    
    for(let club of list) {
        const div = document.createElement("div");
        div.className = "contentcard";
        let str = "";
        str = `
        <div class="socialing">
            <a class="cardlink" href="detail.cl?cno=${club.boardNo}">
                <img class="img" src="${club.thumbnailImg}" />
                <div class="info">
                    <div class="subject">
                        <div class="tag">${club.clubType}</div>
                        <div class="tagone">${club.categoryName1}</div>
                        <div class="tagtwo">${club.categoryName2}</div>
                    </div>
                    <div class="infotitle">${club.boardTitle}</div>
                    <div class="describe">
                        <svg class="image" xmlns="http://www.w3.org/2000/svg" width="10" height="10" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
                        </svg>
                        ${club.address} · ${club.eventDate}
                    </div>
                    <div class="participant">`;
            if(club.profileImg && club.profileImg.length > 0){
                        str += `<img class="people" src="${club.profileImg[0]}" />`;
                    }
                }
                        str += `<div class="profileimglist">`;
            if(club.profileImg && club.profileImg.length >= 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }
                }

            if(club.profileImg && club.profileImg.length > 1 && club.profileImg.length < 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }  
                }

                  str += ` </div>
                    <div class="socialmember">
                         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
                             <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
                             <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
                         </svg>
                         <div class="count">${club.count}</div>
                     </div>
                </div>
             </div>
        </a>
    </div> `;
        div.innerHTML = str;
        topBody.appendChild(div);
    }

//페이지네이션 처리해서 가져와야함....
function cateHotChallengeAjax(callback){
    $.ajax({
        url: "cateActivityAjax.ct",
        success : callback,
        error: function(){
            console.log("ajax실패")
        }
    })
}

function cateRecentChallengeAjax(list){
    const topBody = document.querySelector(".display");
    $(topBody).empty();
    
    for(let club of list) {
        const div = document.createElement("div");
        div.className = "contentcard";
        let str = "";
        str = `
        <div class="socialing">
            <a class="cardlink" href="detail.cl?cno=${club.boardNo}">
                <img class="img" src="${club.thumbnailImg}" />
                <div class="info">
                    <div class="subject">
                        <div class="tag">${club.clubType}</div>
                        <div class="tagone">${club.categoryName1}</div>
                        <div class="tagtwo">${club.categoryName2}</div>
                    </div>
                    <div class="infotitle">${club.boardTitle}</div>
                    <div class="describe">
                        <svg class="image" xmlns="http://www.w3.org/2000/svg" width="10" height="10" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6" />
                        </svg>
                        ${club.address} · ${club.eventDate}
                    </div>
                    <div class="participant">`;
            if(club.profileImg && club.profileImg.length > 0){
                        str += `<img class="people" src="${club.profileImg[0]}" />`;
                    }
                }
                        str += `<div class="profileimglist">`;
            if(club.profileImg && club.profileImg.length >= 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }
                }

            if(club.profileImg && club.profileImg.length > 1 && club.profileImg.length < 5){
                    for(let profileImg of club.profileImg){
                        str += `<img class="cardImg" src="${profileImg}" />`;
                    }  
                }

                  str += ` </div>
                    <div class="socialmember">
                         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16" style="color: gray;">
                             <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71z"/>
                             <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0"/>
                         </svg>
                         <div class="count">${club.count}</div>
                     </div>
                </div>
             </div>
        </a>
    </div> `;
        div.innerHTML = str;
        topBody.appendChild(div);
    }

//페이지네이션 처리해서 가져와야함....
function cateRecentChallengeAjax(callback){
    $.ajax({
        url: "cateRecentChallengeAjax.ct",
        success : callback,
        error: function(){
            console.log("ajax실패")
        }
    })
}
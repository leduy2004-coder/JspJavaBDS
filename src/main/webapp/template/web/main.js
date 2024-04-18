let icon = document.querySelector('.menu-icon');
let menu = document.querySelector('.menu');
let modal = document.querySelector('.modal');
let menuList = document.querySelectorAll('.menu li');
let modalInput = document.querySelector('.modal-input');
let formLogin = document.querySelector('.form-login');
let formRegister = document.querySelector('.form-register');
let formBtnBack = document.querySelectorAll('.back');
let registerBtn = document.querySelector('.register-btn');
let loginBtn = document.querySelector('.login-btn');
let openLogin = document.querySelector('.open-login');
let openRegister = document.querySelector('.open-register');
let closeToast = document.querySelector('.toast-close i');
let toast = document.querySelector('.toast');

icon.addEventListener("click", function(e) {
    modal.classList.add("open");
    menu.classList.add("active");
});

modal.addEventListener("click", function(e) {
    if (e.target == e.currentTarget) {
        modal.classList.remove("open");
        menu.classList.remove("active");
    }
})

menuList.forEach((item) => {
    item.addEventListener("click", function() {
        modal.classList.remove("open");
        menu.classList.remove("active");
    })
});


let prev = document.querySelector('.prev');
let next = document.querySelector('.next');
let list = document.querySelector('.out-wrapper');
const widthItem = document.querySelector('.product-arrow-item').offsetWidth;


next.addEventListener("click", function() {
    list.scrollLeft += widthItem;
})
prev.addEventListener("click", function() {
    list.scrollLeft -= widthItem;
})



var btnList= document.querySelectorAll(".project__nav-button");
var imgList = document.querySelectorAll(".filter");
btnList.forEach(btn=>{
    btn.addEventListener('click',e=>{
        let type= e.currentTarget.getAttribute('type')
        btnList.forEach(check=>{
            if(type == check.getAttribute('type')){
                check.classList.add('active')
            }else {
                check.classList.remove('active')
            }
        })
        
        
        imgList.forEach(img => {
           let cateType = img.getAttribute('type')
           if(type == 'all'|| cateType == type){
                img.classList.remove('hide')
           }else {
                img.classList.add('hide')
           }
        })
       
    })
})


//Phân trang
let thisPage = 1;
let limit = 8;

function loadItem(){
    let beginGet = limit * (thisPage -1 );
    let endGet = limit * thisPage -1;
    imgList.forEach((item, key)=>{
        if(key >= beginGet && key <= endGet){
            item.style.display = 'block';
        }else{
            item.style.display = 'none';
        }
    })
    listPage();
}
loadItem();
function listPage(){
    let count = Math.ceil(imgList.length / limit);
    document.querySelector('.pagination').innerHTML = '';

    if(thisPage != 1){
        let left = document.createElement('li');
        left.innerHTML = '<i class="pagination-item__icon fas fa-angle-left"></i>'
        left.setAttribute('onclick', "changePage(" +(thisPage-1)+ ")");
        document.querySelector('.pagination').appendChild(left);
    }
    for (i = 1; i <= count; i++) {
        let newPage = document.createElement('li');
        newPage.innerText = i;
        if(i == thisPage){
            newPage.classList.add('active');
        }
        newPage.setAttribute('onclick', "changePage(" +i+ ")");
        document.querySelector('.pagination').appendChild(newPage);
    }

    if(thisPage != count){
        let right = document.createElement('li');
        right.innerHTML = ' <i class="pagination-item__icon fas fa-angle-right"></i>'
        right.setAttribute('onclick', "changePage(" +(thisPage+1) + ")");
        document.querySelector('.pagination').appendChild(right);
    }
}
function changePage(i){
    thisPage =i;
    loadItem();
}



	var slide = document.querySelectorAll('.new__content');
    // Lấy danh sách các phần tử li
    var items = document.querySelectorAll('.new__list-item');
    var check=true;
    slide.forEach(function (o) {
        if(check){
            o.classList.add('block');
            check = false;
        }else {
            o.classList.add('hide');
        }
        
    })
    // Gán sự kiện mouseover cho từng phần tử li
    items.forEach(function (item) {
      item.addEventListener('mouseover', function () {
       
        slide.forEach(function (s){
                s.classList.add('hide');
       
            if(s.getAttribute('type')==item.getAttribute('type')){
                s.classList.remove('hide');
            }
            
        })
      });
    });

closeToast.addEventListener("click", function() {
	toast.classList.add("none");
})


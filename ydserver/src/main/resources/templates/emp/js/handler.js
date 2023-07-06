
init();

// 최초 셋팅
function init() {

    document.getElementById('allCheck')
        .addEventListener('click', allCheckEvent);

    document.getElementById('resetBtn')
        .addEventListener('click', resetCheck);
    
    document.getElementById('initBtn')
        .addEventListener('click', formInit);
}


// 사원정보 전체 선택
function allCheckEvent(e) {
    let allCheckTag = document.getElementById('allCheck');
    let checkTags = document.querySelectorAll('[type="checkbox"]');
    checkTags.forEach(el => {
        el.checked = allCheckTag.checked;
    })
}

// 사원정보 선택취소
function resetCheck(e) {
    let checkTags = document.querySelectorAll('[type="checkbox"]');
    checkTags.forEach(el => {
        el.checked = false;
    })
}

// 초기화
function formInit() {
    let insertList = document.querySelectorAll('#empInfo input, #empInfo select');
    insertList.forEach(el => el.value = '');
}

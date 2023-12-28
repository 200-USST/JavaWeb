const sideMenu = document.querySelector('aside');
const menuBtn = document.getElementById('menu-btn');
const closeBtn = document.getElementById('close-btn');

const darkMode = document.querySelector('.dark-mode');

menuBtn.addEventListener('click', () => {
    sideMenu.style.display = 'block';
});

closeBtn.addEventListener('click', () => {
    sideMenu.style.display = 'none';
});

darkMode.addEventListener('click', () => {
    document.body.classList.toggle('dark-mode-variables');
    darkMode.querySelector('span:nth-child(1)').classList.toggle('active');
    darkMode.querySelector('span:nth-child(2)').classList.toggle('active');
})

// 我加的

// sidebar点击切换界面

let item = document.querySelectorAll(".sidebar a")
let main_all = document.querySelectorAll("main")

function inactive_all () {
    item.forEach((a) => {
        a.classList.remove("active")
    })

    main_all.forEach((main) => {
        // main.style.display = "none"
        main.style.visibility = "hidden"
        main.style.opacity = "0"
    })
}

function active (a) {
    inactive_all()
    a.classList.add("active")

    let main = document.getElementById(a.id + "-main")
    // main.style.display = "block"
    main.style.visibility = "visible"
    main.style.opacity = "1"
}

item.forEach((a) => {
    a.addEventListener("click", () => {
        active(a)
    })
})

// personal-info
// 设置可编辑
let modify_butts = document.querySelectorAll(".modify");

modify_butts.forEach((butt) => {
    butt.addEventListener("click", () => {
        // 获取当前按钮所在的表单
        let form = butt.closest('.switch');

        // 修改当前表单中的元素
        form.querySelector(".modify").style.display = "none";
        form.querySelector(".submit").style.display = "inline";
        let del_butt = form.querySelector(".delete")
        if (del_butt) del_butt.style.display = "inline"

        let all_input = form.querySelectorAll("input");
        all_input.forEach((e) => {
            if (e.classList.contains("cannot-modify")) return;
            e.removeAttribute("readonly");
        });

        let area = form.querySelector("textarea");
        if (area) area.removeAttribute("readonly")

        let file_input = form.querySelector(".img-upload");
        if (file_input) {
            if (file_input.classList.contains("cannot-modify")) return;
            file_input.removeAttribute("disabled")
        }
    });
});


let delete_butts = document.querySelectorAll(".delete");
delete_butts.forEach((butt) => {
    butt.addEventListener("click", () => {
        console.log("in")
        let form = butt.closest('.switch');
        let all_input = form.querySelectorAll("input");
        let id = all_input[all_input.length - 2].value
        let pic = all_input[all_input.length - 1].value
        let servlet = butt.id
        location.href = servlet + '?type=deleteDish&activeBar=dishes-guard&dishId=' + id + "&dishPic=" + pic;
    })
})





// canteen-info
// 点table
document.querySelectorAll(".canteen-tr").forEach((tr) => {
    tr.addEventListener("click", () => {
        let form = tr.closest('main').querySelector("form.switch")
        let inputs = form.querySelectorAll("input")
        let area = form.querySelector("textarea")
        inputs[0].value = tr.getAttribute("cname")
        inputs[1].value = tr.getAttribute("clocation")
        inputs[3].value = tr.getAttribute("cid")
        inputs[4].value = tr.getAttribute("cpic")
        area.value = tr.getAttribute("cabstract")

        let json = document.getElementById("storage").getAttribute("cmJson")
        let p_tag = form.querySelector(".input-like")
        let text = ''
        json = JSON.parse(json)
        let manager_list = json[tr.getAttribute("cname")]
        for (var i in manager_list) {
            text += manager_list[i] + '、'
        }
        p_tag.innerText = text

        let img = form.querySelector("img")
        img.src = img.getAttribute("basesrc") + tr.getAttribute("cpic")
    })
})

// 有图片上传
document.querySelectorAll(".img-upload").forEach((e) => {
    let preview = e.closest("div").querySelector("img")
    let objectURL
    e.addEventListener('change', function(event) {
        var file = event.target.files[0];
        if (file) {
            objectURL = URL.createObjectURL(file);
            preview.src = objectURL
        }
    });
    preview.onload = () => {
        URL.revokeObjectURL(objectURL);
    }

})


// account-info

document.querySelectorAll(".account-tr").forEach((tr) => {
    tr.addEventListener("click", () => {
        let form = tr.closest('main').querySelector("form.switch")
        let inputs = form.querySelectorAll("input")
        inputs[0].value = tr.getAttribute("uname")
        inputs[1].value = tr.getAttribute("upassword")
        inputs[2].value = tr.getAttribute("uidentity")
        inputs[3].value = tr.getAttribute("ugender")
        inputs[4].value = tr.getAttribute("uage")
        inputs[5].value = tr.getAttribute("ucanteen")
        inputs[6].value = tr.getAttribute("uid")
    })
})

// canteen-guard

document.addEventListener("DOMContentLoaded", () => {
    let json = document.getElementById("storage").getAttribute("cmJson")
    let p_tag = document.querySelector("#canteen-guard-main p.input-like")
    let text = ''
    json = JSON.parse(json)
    let manager_list = json[p_tag.getAttribute("cname")]
    for (var i in manager_list) {
        text += manager_list[i] + '、'
    }
    p_tag.innerText = text;
})

// dish-guard

document.querySelectorAll(".dishes-tr").forEach((tr) => {
    tr.addEventListener("click", () => {
        let form = tr.closest('main').querySelector("form.switch")
        let inputs = form.querySelectorAll("input")
        let area = form.querySelector("textarea")
        let img = form.querySelector("img")
        inputs[0].value = tr.getAttribute("dname")
        inputs[1].value = tr.getAttribute("dclass")
        inputs[2].value = tr.getAttribute("dprice")
        inputs[4].value = tr.getAttribute("did")
        inputs[5].value = tr.getAttribute("dpic")

        area.value = tr.getAttribute("dinfo")
        img.src = img.getAttribute("basesrc") + tr.getAttribute("dpic")
    })
})

// dish-search
document.querySelectorAll("#dishes-search-main div.user").forEach((div) => {
    div.addEventListener("click", () => {
        let form = div.closest('main').querySelector("form.info-display")
        let p_tag = form.querySelectorAll("p")
        let img = form.querySelector("img")
        p_tag[0].innerText = div.getAttribute("dname")
        p_tag[1].innerText = div.getAttribute("dclass")
        p_tag[2].innerText = div.getAttribute("dprice")
        p_tag[3].innerText = div.getAttribute("dinfo")

        img.src = img.getAttribute("basesrc") + div.getAttribute("dpic")
    })
})

// canteen-search
document.querySelectorAll("#canteen-search-main div.user").forEach((div) => {
    div.addEventListener("click", () => {
        let form = div.closest('main').querySelector("form.info-display")
        let p_tag = form.querySelectorAll("p")
        let img = form.querySelector("img")
        p_tag[0].innerText = div.getAttribute("cname")
        p_tag[1].innerText = div.getAttribute("clocation")
        p_tag[2].innerText = div.getAttribute("cabstract")

        img.src = img.getAttribute("basesrc") + div.getAttribute("cpic")
    })
})


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


// Orders.forEach(order => {
//     const tr = document.createElement('tr');
//     const trContent = `
//         <td>${order.productName}</td>
//         <td>${order.productNumber}</td>
//         <td>${order.paymentStatus}</td>
//         <td class="${order.status === 'Declined' ? 'danger' : order.status === 'Pending' ? 'warning' : 'primary'}">${order.status}</td>
//         <td class="primary">Details</td>
//     `;
//     tr.innerHTML = trContent;
//     document.querySelector('table tbody').appendChild(tr);
// });


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
let submit_butts = document.querySelectorAll(".submit");
let delete_butts = document.querySelectorAll(".delete");

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
    });
});

submit_butts.forEach((butt) => {
    butt.addEventListener("click", () => {
        // 获取当前按钮所在的表单
        let form = butt.closest('.switch');

        // 修改当前表单中的元素
        form.querySelector(".modify").style.display = "inline";
        form.querySelector(".submit").style.display = "none";
        let del_butt = form.querySelector(".delete")
        if (del_butt) del_butt.style.display = "none"

        let all_input = form.querySelectorAll("input");
        all_input.forEach((e) => {
            e.setAttribute("readonly", true);
        });

        let area = form.querySelector("textarea");
        if (area) area.setAttribute("readonly", true)
    });
});

delete_butts.forEach((butt) => {
    butt.addEventListener("click", () => {
        // 获取当前按钮所在的表单
        let form = butt.closest('.switch');

        // 修改当前表单中的元素
        form.querySelector(".modify").style.display = "inline";
        form.querySelector(".submit").style.display = "none";
        form.querySelector(".delete").style.display = "none";

        let all_input = form.querySelectorAll("input");
        all_input.forEach((e) => {
            e.setAttribute("readonly", true);
        });

        let area = form.querySelector("textarea");
        if (area) area.setAttribute("readonly", true)
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
        area.value = tr.getAttribute("cabstract")

        let json = document.getElementById("storage").getAttribute("cmJson")
        let p_tag = form.querySelector(".input-like")
        p_tag.innerText = ''
        json = JSON.parse(json)
        let manager_list = json[tr.getAttribute("cname")]
        for (var i in manager_list) {
            p_tag.innerText += manager_list[i] + '、'
        }
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


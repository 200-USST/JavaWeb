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

modify_butts.forEach((butt, i) => {
    butt.addEventListener("click", () => {
        // 获取当前按钮所在的表单
        let form = butt.closest('.switch');

        // 修改当前表单中的元素
        form.querySelector(".modify").style.display = "none";
        form.querySelector(".submit").style.display = "inline";

        let all_input = form.querySelectorAll("input");
        all_input.forEach((e) => {
            if (e.id === "cannot-modify") return;
            e.removeAttribute("readonly");
        });

        let area = form.querySelector("textarea");
        if (area != null) area.removeAttribute("readonly")
    });
});

submit_butts.forEach((butt, i) => {
    butt.addEventListener("click", (event) => {
        // 获取当前按钮所在的表单
        let form = butt.closest('.switch');

        // 修改当前表单中的元素
        form.querySelector(".modify").style.display = "inline";
        form.querySelector(".submit").style.display = "none";

        let all_input = form.querySelectorAll("input");
        all_input.forEach((e) => {
            e.setAttribute("readonly", true);
        });

        let area = form.querySelector("textarea");
        if (area != null) area.setAttribute("readonly", true)
    });
});




// canteen-info

document.querySelectorAll(".butt-tr").forEach((tr) => {
    tr.addEventListener("click", () => {
        let canteen_input = document.querySelectorAll("#modify-canteen input")
        let canteen_area = document.querySelector("#modify-canteen textarea")
        canteen_input[0].value = tr.getAttribute("cname")
        canteen_input[1].value = tr.getAttribute("clocation")
        canteen_area.value = tr.getAttribute("cabstract")
    })
})


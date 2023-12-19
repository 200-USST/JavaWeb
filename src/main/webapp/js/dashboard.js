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

    localStorage.setItem("last", a.id)
    console.log(localStorage.getItem("last"));
    console.log('1231');
}

item.forEach((a) => {
    a.addEventListener("click", () => {
        active(a)
    })
})

// 自动回到上一次打开的界面

// personal-info
// 设置可编辑
let modify_butt = document.querySelector("#personal-info-main .modify")
let submit_butt = document.querySelector("#personal-info-main .submit")
let all_input = document.querySelectorAll(".personal-info-profile input")

modify_butt.addEventListener("click", () => {
    modify_butt.style.display = "none"
    submit_butt.style.display = "inline"

    all_input.forEach((e) => {
        if (e.id === "cannot-modify") return
        e.removeAttribute("readonly")
    })
})

submit_butt.addEventListener("click", (event) => {
    modify_butt.style.display = "inline"
    submit_butt.style.display = "none"
    all_input.forEach((e) => {
        e.setAttribute("readonly", true)
    })
})



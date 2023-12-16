let funcbutt = document.querySelectorAll(".funcbutt");

/* JavaScript 中对应的部分 */
funcbutt.forEach((butt) => {
    butt.addEventListener("click", () => {
        let div_id = butt.id + "div";
        let tooltipElement = document.getElementById(div_id);
        let imagesAndTexts = tooltipElement.querySelectorAll('.tooltip-func1, .tooltip-text');

        // 隐藏所有的 tooltip 除了当前点击按钮对应的 tooltip
        let all_tip = document.querySelectorAll('.tooltip');
        all_tip.forEach((e) => {
            if (e !== tooltipElement) {
                e.style.display = "none";
            }
        });

        // 显示选中的 tooltip
        tooltipElement.style.display = "block";

        // 对图片和文字进行渐变
        imagesAndTexts.forEach((element) => {
            element.style.opacity = 0;
            fadeIn(element, 500); // 500 毫秒为渐变时间，可以根据需要调整
        });

        // 对图片进行缓慢上升
        let images = tooltipElement.querySelectorAll('.tooltip-func1');
        images.forEach((image) => {
            image.style.transform = 'translate(-50%, -50%)'; // 恢复初始位置
            setTimeout(() => {
                image.style.transform = 'translate(-50%, -70%)'; // 上升的位置
            }, 50); // 50 毫秒为图片抬起的间隔，可以根据需要调整
        });
    });
});

// 渐变显示函数
function fadeIn(element, duration) {
    let start = null;

    function step(timestamp) {
        if (!start) start = timestamp;
        const progress = timestamp - start;
        element.style.opacity = progress / duration;

        if (progress < duration) {
            window.requestAnimationFrame(step);
        }
    }

    window.requestAnimationFrame(step);
}

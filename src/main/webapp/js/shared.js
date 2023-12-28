window.onload = function() {
    setTimeout(function() {
        var messageBox = document.getElementById("message-box");
        if (messageBox) {
            messageBox.style.display = 'none';
        }
    }, 3000); // 3秒后消失
};